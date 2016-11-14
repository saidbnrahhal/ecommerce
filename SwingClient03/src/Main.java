import ma.ensa.controllers.Controller;
import ma.ensa.models.Model;

public class Main {

	public Main() {
		
		Model model = new Model() ;
		Controller controller= new Controller(model);
	}
	
	public static void main(String[] args) {
		Main main =new Main() ;
	}

}
