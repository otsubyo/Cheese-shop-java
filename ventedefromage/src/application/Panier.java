package application;

import java.util.ArrayList;
import java.util.List;

public class Panier {
	private List<Article> listpanier;
	private float total;
	private TypeTransport typeTransport;
	private List<Integer> listquantit�;
	
	public Panier() {
		this.listpanier = new ArrayList<Article>();
		this.total = 0.0F;
		this.typeTransport= null;
		this.listquantit� = new ArrayList<Integer>();
	}
	
	public void ajoutArticlePanier(Article a, int quantit�)throws IllegalArgumentException {
		if(a.getQuantit�EnStock()<quantit�) {
			throw new IllegalArgumentException("quantit� indisponible dans nos stock");
		}
		this.listpanier.add(a);
		this.listquantit�.add(quantit�);
		this.total += a.getPrixTTC() * quantit�;
		a.pr�empterQuantit�(quantit�);
	}
	
	public boolean estDansPanier(Article a) {
		for (Article i : this.listpanier) {
            if (i.equals(a)) {
                return true;
            }
        }
		return false;
	}
	
	public int getQuantit�Article(Article a) {
		return this.listquantit�.get(this.listpanier.indexOf(a));
	}
	
	public List<Article> getPanier(){
		return this.listpanier;
	}
	
	public List<Integer> getQuantit�(){
		return this.listquantit�;
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
		a.rendreQuantit�(getQuantit�Article(a));
		this.total = this.total - a.getPrixTTC() * getQuantit�Article(a);
		this.listquantit�.remove(this.listpanier.indexOf(a));
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
			this.listquantit�.clear();
			this.total = 0.0F;
			this.typeTransport =null;
			return this;
		}
	}
	
}