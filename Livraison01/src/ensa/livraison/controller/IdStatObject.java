package ensa.livraison.controller;

public class IdStatObject {
	
	private	String id ;
	private	String state ;
		public IdStatObject(String id,String state) {
			this.setId(id) ;
			this.setState(state) ;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		
	}
