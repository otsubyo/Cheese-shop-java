package application;

public class FromageEntierOuMoiti� extends Fromage {
	
	public static final String MOITIE = "moiti�";
	public static final String ENTIER = "entier";

	public FromageEntierOuMoiti�(String d�signation) {
		super(d�signation);
	}
	
	public String toString() {
		return super.toString() + ", vendu entier ou par moiti�";
	}

}
