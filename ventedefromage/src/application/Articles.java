package application;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Articles {

	private List<Fromage> lesFromages;
	
	public Articles() {
		this.lesFromages = new LinkedList<Fromage>();
	}
	
	public void addFromages(List<Fromage> fromages) {
		this.lesFromages.addAll(fromages);
	}
	
	public String toStringFromagesEtArticles() {
		StringBuffer enForme = new StringBuffer();
		for (Fromage f : this.lesFromages) {
			enForme.append(f.toString() + '\n');
			if (f.nombreArticles() > 0) {
				for (Article article : f.getArticles()) {
					enForme.append(article.toString() + '\n');
				}
			}
		}
		return enForme.toString();
	}
	
	public String toStringArticlesEtStock() {
		StringBuffer enForme = new StringBuffer();
		for (Fromage f : this.lesFromages) {
			if (f.nombreArticles() > 0) {
				for (Article article : f.getArticles()) {
					enForme.append(article.toStringAvecStock() + '\n');
				}
			}
		}
		return enForme.toString();
	}
	
	public void reg�n�rationDuStock() {
		for (Fromage f : this.lesFromages) {
			if (f.nombreArticles() > 0) {
				for (Article article : f.getArticles()) {
					article.setQuantit�EnStock((int) Math.round(Math.random()*100));
				}
			}
		}
	}
	

	public String v�rificationSaisie( ) {
		StringBuffer enForme = new StringBuffer();
		for (Fromage f : this.lesFromages) {
			if (f.nombreArticles() == 0) {
				enForme.append("Pas d'articles pour " + f.toString() + '\n');
			}
		}
		return enForme.toString();
	}
	
	public List<Fromage> fromageAuLaitDe(TypeLait lait) {
		List<Fromage> listeFromage = new ArrayList<Fromage>();
		for (Fromage cheese: lesFromages) {
			if (cheese.getTypeFromage() == lait) {
				listeFromage.add(cheese);
			}
		}
		return listeFromage;
	}
	
	public List<Fromage> getLesFromages() {
		List<Fromage> listeFromage = new ArrayList<Fromage>();
		for (Fromage cheese: lesFromages) {
			listeFromage.add(cheese);
		}
		return listeFromage;
	}
	
	public Article getArticle(String d�signation, String cl�) throws Exception {
		for (Fromage cheese: lesFromages) {
			if (cheese.getD�signation() == d�signation) {
				for (Article article : cheese.getArticles()) {
					if (article.getCl�() == cl�) {
						return article;
					}
				}
			}
		}
		throw new Exception("Article introuvable");
	}
}
