package application;
public class SaisieFromage {
	
	private String d�signation;
	private String description;
	private TypeVente vente;
	private String[] cl�Article;
	private float[] prixArticle;
	
	public SaisieFromage(String d�signation, String description, TypeVente vente) {
		this.d�signation = d�signation;
		this.description = description;
		this.vente = vente;
	}
	
	public SaisieFromage(String d�signation, String description, TypeVente vente, String[] cl�Article, float[] prixArticle) {
		this(d�signation, description, vente);
		this.cl�Article = cl�Article;
		this.prixArticle = prixArticle;
	}
	
	public Fromage builderFromage() {
		Fromage f = null;
		switch (vente) {
		case A_LA_COUPE_AU_POIDS : 
			f = new FromageALaCoupe(d�signation);
			if (this.prixArticle != null && this.prixArticle.length > 1 
					&& this.cl�Article != null && this.cl�Article.length > 1
					&& this.cl�Article.length == this.prixArticle.length)
				for (int i = 0; i < this.cl�Article.length; i++)
					f.addArticle(this.cl�Article[i], this.prixArticle[i]);
			break;
		case A_L_UNITE : 
		    f = new FromageALUnit�(d�signation);
		    if (this.prixArticle != null)
		    	f.addArticle("", this.prixArticle[0]);
		    break;
		case ENTIER_OU_MOITIE : 
			f = new FromageEntierOuMoiti�(d�signation);
			if (this.prixArticle != null && this.prixArticle.length == 2) {
				f.addArticle(FromageEntierOuMoiti�.MOITIE, this.prixArticle[0]);
				f.addArticle(FromageEntierOuMoiti�.ENTIER, this.prixArticle[1]);
			}
			break;
		case A_L_UNITE_PlUSIEURS_CHOIX :
			f = new FromageALUnit�PlusieursChoix(d�signation);
			if (this.prixArticle != null && this.prixArticle.length == 1 
				&& this.cl�Article != null && this.cl�Article.length > 1)
				for (String cl�: this.cl�Article)
					f.addArticle(cl�, this.prixArticle[0]);
			break;
		case POUR_X_PERSONNES :
			f = new FromagePourXPersonnes(d�signation);
			if (this.prixArticle != null && this.prixArticle.length > 1 
					&& this.cl�Article != null && this.cl�Article.length > 1
					&& this.cl�Article.length == this.prixArticle.length)
				for (int i = 0; i < this.cl�Article.length; i++)
					f.addArticle("pour " + this.cl�Article[i] + " personnes", this.prixArticle[i]);
			break;
		}
		f.addDescription(description);
		return f;
	}

}
