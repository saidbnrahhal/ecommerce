package ma.ensa.models;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import javax.imageio.ImageIO;

import ma.ensa.models.entity.Product;
import ma.ensa.services.interfaces.ProductService;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class ProductModel {

	ProductService productService;

	public ProductModel(ConnectionModel connectionModel) {
		productService = connectionModel.getProductService();
	}

	public void send(String path, Long operationId) throws Exception {

		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost uploadFile = new HttpPost(
				"http://localhost:8080/Atlas01/UploadServlet");
		MultipartEntityBuilder builder = MultipartEntityBuilder.create();
		builder.addTextBody("field1", "yes", ContentType.TEXT_PLAIN);
		builder.addBinaryBody("file", new File(path),
				ContentType.APPLICATION_OCTET_STREAM, operationId + ".png");
		HttpEntity multipart = builder.build();

		uploadFile.setEntity(multipart);

		CloseableHttpResponse response = httpClient.execute(uploadFile);
		HttpEntity responseEntity = response.getEntity();
		System.out.println(responseEntity.getContent().toString());
	}

	public BufferedImage loadImage(String Path) {
		BufferedImage image =null ;
		try {
			 image = ImageIO.read(new File(Path));
		} catch (IOException ex) {

		}
		return image;
	}

	public BufferedImage loadImage(URL url ) {
		BufferedImage image =null ;
		try {
			 image = ImageIO.read(url);
		} catch (IOException ex) {

		}
		return image;
	}

	public List<Product> getAllProduct() {
		return productService.getAllProduct();
	}

	public void addProduct(Product product) {
		Product productTemp=product ;
		Long operationId =System.currentTimeMillis() ;
		try {
			send(productTemp.getImageLink(),operationId);
			productTemp.setImageLink(operationId+"");
		} catch (Exception e) {
			
		}
		
		
		productService.addProduct(productTemp);
	}

	public void updateProduct(Long id, Product product) {
		Product productTemp=product ;
		Long operationId =System.currentTimeMillis() ;
		try {
			send(productTemp.getImageLink(),operationId);
			productTemp.setImageLink(operationId+"");
		} catch (Exception e) {
			
		}
		productService.updateProduct(id, productTemp);
		
		

	}

	public Product getProductById(Long id) {
		return productService.getProductById(id);
	}

	public void deleteProduct(Long id) {
		productService.deleteProduct(id);
	}
}
