package application;

import java.util.LinkedList;
import java.util.List;

public class Fromage implements Comparable<Fromage> {
	
	private String d�signation;
	private String description;
	private TypeLait typeFromage;
	private List<Article> articles;

	public Fromage(String d�signation) {
		this.d�signation = d�signation;
		this.articles = new LinkedList<Article>();
	}	
	
	public String getD�signation() {
		return this.d�signation;
	}
	
	public String getDescription() {
		assert !(this.description == null);
		if (this.description == null)
			return "Pas de description de ce fromage pour le moment. Nous en sommes d�sol�s";
		return this.description;
	}

	public void addDescription(String description) {
		this.description = description;
	}
	
	public void updateTypeFromage(TypeLait type) {
		this.typeFromage = type;
	}
	
	public TypeLait getTypeFromage() {
		return this.typeFromage;
	}

	public String toString() {
		return this.getD�signation() 
				+ ", Fromage au lait de " 
				+ this.typeFromage.getTypeDeLait();
	}
	
	public void addArticle(String cl�, float prixTTC) {
		this.articles.add(new Article(this, cl�, prixTTC));
	}
	
	public int nombreArticles() {
		return this.articles.size();
	}
	
	public List<Article> getArticles() {
		return this.articles;
	}
	
	public int compareTo(Fromage f) {
		return this.d�signation.compareTo(f.d�signation);
	}
	
	public boolean equals(Object obj) {
		Fromage other = (Fromage) obj;
		return this.d�signation.equals(other.d�signation);
	}

}
