package application;

public class FromageALUnit�PlusieursChoix extends Fromage {
	
	public FromageALUnit�PlusieursChoix(String d�signation) {
		super(d�signation);
	}
	
	public String toString() {
		return super.toString() + ", vendu à l'unit� avec plusieus choix";
	}

}
