package application;

public class FromageALaCoupe extends Fromage {

	public FromageALaCoupe(String d�signation) {
		super(d�signation);
	}
	
	public String toString() {
		return super.toString() + ", vendu à la coupe ou au poids";
	}

}
