package application;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestSaisieFromage {

	@Test
	public void testSaisieFromageALaCoupe() {
		SaisieFromage uneSaisie = new SaisieFromage(null, null, TypeVente.A_LA_COUPE_AU_POIDS);
		assertTrue(uneSaisie.builderFromage() instanceof FromageALaCoupe);
	}
	
	@Test
	public void testSaisieFromageEtArticlesALaCoupe() {
		SaisieFromage uneSaisie = new SaisieFromage("Brie de Melun", 
				"Plus petit que son grand fr�re «le Brie de Meaux», il a cependant plus de caract�re. Ce fromage au lait cru de vache vous offrira une pâte "
				+"souple de couleur jaune d’or à l’int�rieur, et une croûte fleurie blanche parsem�e de stries ou de taches rouges ou brunes à l’ext�rieur. "  
				+"Le Brie de Melun vous proposera une saveur tr�s fruit�e avec un l�ger goût de noisette accompagn�e d’une odeur du terroir qui le rendra "
				+"indispensable sur un plateau de fromages. Il pourra aussi entrer dans la confection de sp�cialit�s r�gionales dont la plus connue, "
				+"la croûte au brie.", 
				TypeVente.A_LA_COUPE_AU_POIDS, new String[]{"250 g", "500 g", "1 Kg"}, new float[]{9.15F, 18.3F, 36.6F});
		Fromage f = uneSaisie.builderFromage();
		assertEquals("Brie de Melun", f.getD�signation());
		assertEquals(3, f.nombreArticles());
		assertEquals("250 g", f.getArticles().get(0).getCl�());
		assertEquals(9.15F, f.getArticles().get(0).getPrixTTC(), 0F);
		assertEquals("500 g", f.getArticles().get(1).getCl�());
		assertEquals(18.3F, f.getArticles().get(1).getPrixTTC(), 0F);
		assertEquals("1 Kg", f.getArticles().get(2).getCl�());
		assertEquals(36.6F, f.getArticles().get(2).getPrixTTC(), 0F);
	}

	@Test
	public void testSaisieFromageALunit�() {
		SaisieFromage uneSaisie = new SaisieFromage(null, null, TypeVente.A_L_UNITE);
		assertTrue(uneSaisie.builderFromage() instanceof FromageALUnit�);
	}
	
	@Test 
	public void testSaisieFromageEtArticleALunit�() {
		SaisieFromage uneSaisie  = new SaisieFromage("Brique de Brebis Fermi�re", 
				"Cette brique est fabriqu�e à base de lait cru de brebis, elle dispose d’une croûte tendre de couleur ivoire pliss�e "
				+"et d’une pâte onctueuse et fondante de couleur blanche. "
				+"Lors de sa d�gustation vous d�couvrirez des saveurs fruit�es, l�g�rement sal�es avec des arômes de brebis, de noisette et de lait chaud. "  
				+"Une authenticit� qui r�v�le la diversit� des pâturages du Tarn grâce à son herbage riche et floral. "
				+ "Un vrai produit qui doit sa beaut� simplement au fermier artisan. "
				+ "Elle est fondante, douce et persistante, prend du caract�re sans agressivit� en s’affinant avec un petit goût de noisette.", 
				TypeVente.A_L_UNITE,new String[]{""} ,new float[]{7.89F});
		Fromage f = uneSaisie.builderFromage();
		assertEquals("Brique de Brebis Fermi�re", f.getD�signation());
		assertEquals(1, f.nombreArticles());
		assertEquals("", f.getArticles().get(0).getCl�());
		assertEquals(7.89F, f.getArticles().get(0).getPrixTTC(), 0F);
	}
	
	@Test
	public void testSaisieFromageEntierOuMoiti�() {
		SaisieFromage uneSaisie = new SaisieFromage(null, null, TypeVente.ENTIER_OU_MOITIE);
		assertTrue(uneSaisie.builderFromage() instanceof FromageEntierOuMoiti�);
	}
	
	@Test
	public void testSaisieFromageEtArticlesEntierOuMoiti�() {
		SaisieFromage uneSaisie = new SaisieFromage("Brin d'Amour Corse", 
				"Ce fromage au lait cru de brebis à pâte molle à croûte fleurie, propose un caract�re corse qui s'exprime par sa croûte recouverte d'herbes, "
				+"de sarriettes et de romarin. Le Brin d'Amour offre un goût inimitable et une saveur parfum�e et intense, il reste une merveille pour le palais. "
				+"C'est tout le caract�re du fromage corse vous faisant voyager qui s'exprime dans ce mariage tr�s heureux de lait de brebis et d’aromates. "
				+ "La «Fleur du maquis» dont la pâte est fine et la couleur varie entre le rouge et le vert.", 
				TypeVente.ENTIER_OU_MOITIE, new String[]{""} ,new float[]{8.5F, 16.8F});
		Fromage f = uneSaisie.builderFromage();
		assertEquals("Brin d'Amour Corse", f.getD�signation());
		assertEquals(2, f.nombreArticles());
		assertEquals("moiti�", f.getArticles().get(0).getCl�());
		assertEquals(8.5F, f.getArticles().get(0).getPrixTTC(), 0F);
		assertEquals("entier", f.getArticles().get(1).getCl�());
		assertEquals(16.8F, f.getArticles().get(1).getPrixTTC(), 0F);
	}
	
	@Test
	public void testSaisieFromageALunit�PlusieursChoix() {
		SaisieFromage uneSaisie = new SaisieFromage(null, null, TypeVente.A_L_UNITE_PlUSIEURS_CHOIX);
		assertTrue(uneSaisie.builderFromage() instanceof FromageALUnit�PlusieursChoix);
	}
	
	@Test
	public void testSaisieFromageEtArticlesALunit�PlusieursChoix() {
		SaisieFromage uneSaisie = new SaisieFromage("Cabris Fermier", 
				"Produit par nos soins sous le nom de l'EARL Chemin Fleury, nous respectons le savoir faire de cette grande r�gion, tout en se distinguant "
						+"par une texture et un goût qui lui sont bien sp�cifiques. Au lait cru de ch�vre, nos fromages pr�sentent une croûte fine sal�e au sel blanc "
						+"ou cendr� renfermant une pâte souple, tendre et homog�ne de couleur blanche. "
						+"Leurs doux goûts de ch�vre uniques raviront vos papilles et celles de vos convives.", 
						TypeVente.A_L_UNITE_PlUSIEURS_CHOIX, new String[]{"Moelleux cendr� - Jeune et doux", "Moelleux blanc - Jeune et doux"} ,new float[]{3.39F});
		Fromage f = uneSaisie.builderFromage();
		assertEquals("Cabris Fermier", f.getD�signation());
		assertEquals(2, f.nombreArticles());
		assertEquals("Moelleux cendr� - Jeune et doux", f.getArticles().get(0).getCl�());
		assertEquals(3.39F, f.getArticles().get(0).getPrixTTC(), 0F);
		assertEquals("Moelleux blanc - Jeune et doux", f.getArticles().get(1).getCl�());
		assertEquals(3.39F, f.getArticles().get(1).getPrixTTC(), 0F);
	}	
	
	@Test
	public void testSaisieFromagePourXPersonnes() {
		SaisieFromage uneSaisie = new SaisieFromage(null, null, TypeVente.POUR_X_PERSONNES);
		assertTrue(uneSaisie.builderFromage() instanceof FromagePourXPersonnes);
	}
	
	@Test
	public void testSaisieFromageEtArticlesPourXPersonnes() {
		SaisieFromage uneSaisie = new SaisieFromage("Fondue Savoyarde", 
				"Id�al pour un repas convivial avec vos amis ou en famille. C'est un m�lange de parfum, d'onctuosit�, et de raffinement pour "
				+"cette fondue savoyarde. Allez y piquez vos morceaux de pain dans le caquelon au centre de la table. "
				+"La fondue savoyarde est un plat r�gional de la gastronomie française à base de fromage fondu et de pain, traditionnel des pays de Savoie. "  
				+"Ce plat populaire, vous envoûtera de part ses multiples arômes.", 
				TypeVente.POUR_X_PERSONNES, new String[]{"3","5", "10"}, new float[]{22.5F, 33.75F, 67.5F});
		Fromage f = uneSaisie.builderFromage();
		assertEquals("Fondue Savoyarde", f.getD�signation());
		assertEquals(3, f.nombreArticles());
		assertEquals("pour 3 personnes", f.getArticles().get(0).getCl�());
		assertEquals(22.5F, f.getArticles().get(0).getPrixTTC(), 0F);
		assertEquals("pour 5 personnes", f.getArticles().get(1).getCl�());
		assertEquals(33.75F, f.getArticles().get(1).getPrixTTC(), 0F);
		assertEquals("pour 10 personnes", f.getArticles().get(2).getCl�());
		assertEquals(67.5F, f.getArticles().get(2).getPrixTTC(), 0F);
	}
}
