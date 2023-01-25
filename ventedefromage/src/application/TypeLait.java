package application;

public enum TypeLait {
	VACHE("Vache"), CHEVRE("Ch�vre"), BREBIS("Brebis");

	private String typeDeLait;
	
	private TypeLait(String typeDeLait) {
		this.typeDeLait = typeDeLait;
	}
	
	public String getTypeDeLait() {
		return this.typeDeLait;
	}
}
