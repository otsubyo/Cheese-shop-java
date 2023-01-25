package application;

public class FromageALUnité extends Fromage {
	
	public FromageALUnité(String désignation) {
		super(désignation);
	}

	public String toString() {
		return super.toString() + ", vendu Ã  l'unité";
	}

}
