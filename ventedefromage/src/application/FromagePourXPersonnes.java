package application;

public class FromagePourXPersonnes extends Fromage {

	public FromagePourXPersonnes(String d�signation) {
		super(d�signation);
	}
	
	public String toString() {
		return super.toString() + ", vendu par nombre de personnes";
	}

}
