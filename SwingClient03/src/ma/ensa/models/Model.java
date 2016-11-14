package ma.ensa.models;

public class Model {
	
	 private UserModel userModel ;
	 private CommandeModel commandeModel ;
	 private ConnectionModel connectionModel ;
	 private ProductModel productModel ;
	 
	 
     public Model() {
    	 connectionModel= new ConnectionModel();
    	 userModel =new UserModel(connectionModel) ;
    	 commandeModel =new CommandeModel(connectionModel);
    	 productModel =new ProductModel(connectionModel) ;
	}
    public UserModel getUserModel() {
		return userModel;
	}
     
    public CommandeModel getCommandeModel() {
		return commandeModel;
	}
    public ConnectionModel getConnectionModel() {
		return connectionModel;
	}
    public ProductModel getProductModel() {
		return productModel;
	}
}