package application;

import java.util.ArrayList;
import java.util.List;

public class Panier {
	private List<Article> listpanier;
	private float total;
	private TypeTransport typeTransport;
	private List<Integer> listquantité;
	
	public Panier() {
		this.listpanier = new ArrayList<Article>();
		this.total = 0.0F;
		this.typeTransport= null;
		this.listquantité = new ArrayList<Integer>();
	}
	
	public void ajoutArticlePanier(Article a, int quantité)throws IllegalArgumentException {
		if(a.getQuantitéEnStock()<quantité) {
			throw new IllegalArgumentException("quantité indisponible dans nos stock");
		}
		this.listpanier.add(a);
		this.listquantité.add(quantité);
		this.total += a.getPrixTTC() * quantité;
		a.préempterQuantité(quantité);
	}
	
	public boolean estDansPanier(Article a) {
		for (Article i : this.listpanier) {
            if (i.equals(a)) {
                return true;
            }
        }
		return false;
	}
	
	public int getQuantitéArticle(Article a) {
		return this.listquantité.get(this.listpanier.indexOf(a));
	}
	
	public List<Article> getPanier(){
		return this.listpanier;
	}
	
	public List<Integer> getQuantité(){
		return this.listquantité;
	}
	
	public float getPrixTotal() {
		return this.total;
	}
	
	public TypeTransport getTransportType() {
		return this.typeTransport;
	}
	public void suppresionArticlePanier(Article a)throws IllegalArgumentException {
		if (!estDansPanier(a)) {
			throw new IllegalArgumentException("l'article n'est pas dans le panier");
		}
		a.rendreQuantité(getQuantitéArticle(a));
		this.total = this.total - a.getPrixTTC() * getQuantitéArticle(a);
		this.listquantité.remove(this.listpanier.indexOf(a));
		this.listpanier.remove(a);
	}
	
	public void choixTransport(TypeTransport transport) {
		this.typeTransport = transport;
	}
	
	public Panier validerPanier(boolean validation) {
		if (validation) {
			switch (this.typeTransport) {
			case COLISSIMO_POINT_RELAI: this.total=this.total+4.9F;
				
				break;
				
			case COLISSIMO_A_DOMICILE: this.total=this.total+4.9F;
			
				break;
			
			case CHRONOPOST: this.total=this.total+9.9F;
			
				break;

			default:
				break;
			}
			return this;
		}else {
			this.listpanier.clear();
			this.listquantité.clear();
			this.total = 0.0F;
			this.typeTransport =null;
			return this;
		}
	}
	
}