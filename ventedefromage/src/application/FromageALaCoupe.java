package application;

public class FromageALaCoupe extends Fromage {

	public FromageALaCoupe(String désignation) {
		super(désignation);
	}
	
	public String toString() {
		return super.toString() + ", vendu Ã  la coupe ou au poids";
	}

}
