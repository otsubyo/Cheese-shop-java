package application;

public class Article {

	private Fromage fromage;
	private String cl�;
	private float prixTTC;
	private int quantit�EnStock;
	
	public Article(Fromage fromage, String cl�, float prixTTC) {
		this.fromage = fromage;
		this.cl� = cl�;
		this.prixTTC = prixTTC;
		this.quantit�EnStock = 0;
	}
	 
	public Fromage getFromage() {
		return this.fromage;
	}

	public float getPrixTTC() {
		return this.prixTTC;
	}
	
	public int getQuantit�EnStock() {
		return quantit�EnStock;
	}
	
	public String getCl�() {
		return this.cl�;
	}

	public void setQuantit�EnStock(int quantit�EnStock) {
		this.quantit�EnStock = quantit�EnStock;
	}
	
	public void pr�empterQuantit�(int quantit�){
		this.quantit�EnStock -= quantit�;
	}
	
	public void rendreQuantit�(int quantit�) {
		this.quantit�EnStock += quantit�;
	}

	public String toString() {
		if (cl�.equals(""))
			return this.fromage.getD�signation() + ", Prix TTC : " + this.getPrixTTC() + " €";
		else
			return this.fromage.getD�signation() + ", " + this.cl� + ", Prix TTC : " + this.getPrixTTC() + " €";
	}
	
	public String toStringAvecStock() {
		return this.toString() + ", Quantit� en stock : " + this.quantit�EnStock;
	}
	
	public boolean equals(Object obj) {
		Article other = (Article) obj;
		return (this.fromage.equals(other.fromage) && this.cl�.equals(other.cl�));
	}
	
}
