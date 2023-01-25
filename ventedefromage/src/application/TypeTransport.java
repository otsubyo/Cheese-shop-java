package application;
public enum TypeTransport {
	COLISSIMO_POINT_RELAI("Colissimo en point relai"), COLISSIMO_A_DOMICILE("Colissimo a domicile"), CHRONOPOST("Chronopost");

	private String typeDeTransport;
	
	private TypeTransport(String typeDeTransport) {
		this.typeDeTransport = typeDeTransport;
	}
	
	public String getTypeDeTransport() {
		return this.typeDeTransport;
	}
}
