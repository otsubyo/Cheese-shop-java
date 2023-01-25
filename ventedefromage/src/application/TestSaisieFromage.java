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
				"Plus petit que son grand frère Â«le Brie de MeauxÂ», il a cependant plus de caractère. Ce fromage au lait cru de vache vous offrira une pÃ¢te "
				+"souple de couleur jaune dâ€™or Ã  lâ€™intérieur, et une croÃ»te fleurie blanche parsemée de stries ou de taches rouges ou brunes Ã  lâ€™extérieur. "  
				+"Le Brie de Melun vous proposera une saveur très fruitée avec un léger goÃ»t de noisette accompagnée dâ€™une odeur du terroir qui le rendra "
				+"indispensable sur un plateau de fromages. Il pourra aussi entrer dans la confection de spécialités régionales dont la plus connue, "
				+"la croÃ»te au brie.", 
				TypeVente.A_LA_COUPE_AU_POIDS, new String[]{"250 g", "500 g", "1 Kg"}, new float[]{9.15F, 18.3F, 36.6F});
		Fromage f = uneSaisie.builderFromage();
		assertEquals("Brie de Melun", f.getDésignation());
		assertEquals(3, f.nombreArticles());
		assertEquals("250 g", f.getArticles().get(0).getClé());
		assertEquals(9.15F, f.getArticles().get(0).getPrixTTC(), 0F);
		assertEquals("500 g", f.getArticles().get(1).getClé());
		assertEquals(18.3F, f.getArticles().get(1).getPrixTTC(), 0F);
		assertEquals("1 Kg", f.getArticles().get(2).getClé());
		assertEquals(36.6F, f.getArticles().get(2).getPrixTTC(), 0F);
	}

	@Test
	public void testSaisieFromageALunité() {
		SaisieFromage uneSaisie = new SaisieFromage(null, null, TypeVente.A_L_UNITE);
		assertTrue(uneSaisie.builderFromage() instanceof FromageALUnité);
	}
	
	@Test 
	public void testSaisieFromageEtArticleALunité() {
		SaisieFromage uneSaisie  = new SaisieFromage("Brique de Brebis Fermière", 
				"Cette brique est fabriquée Ã  base de lait cru de brebis, elle dispose dâ€™une croÃ»te tendre de couleur ivoire plissée "
				+"et dâ€™une pÃ¢te onctueuse et fondante de couleur blanche. "
				+"Lors de sa dégustation vous découvrirez des saveurs fruitées, légèrement salées avec des arÃ´mes de brebis, de noisette et de lait chaud. "  
				+"Une authenticité qui révèle la diversité des pÃ¢turages du Tarn grÃ¢ce Ã  son herbage riche et floral. "
				+ "Un vrai produit qui doit sa beauté simplement au fermier artisan. "
				+ "Elle est fondante, douce et persistante, prend du caractère sans agressivité en sâ€™affinant avec un petit goÃ»t de noisette.", 
				TypeVente.A_L_UNITE,new String[]{""} ,new float[]{7.89F});
		Fromage f = uneSaisie.builderFromage();
		assertEquals("Brique de Brebis Fermière", f.getDésignation());
		assertEquals(1, f.nombreArticles());
		assertEquals("", f.getArticles().get(0).getClé());
		assertEquals(7.89F, f.getArticles().get(0).getPrixTTC(), 0F);
	}
	
	@Test
	public void testSaisieFromageEntierOuMoitié() {
		SaisieFromage uneSaisie = new SaisieFromage(null, null, TypeVente.ENTIER_OU_MOITIE);
		assertTrue(uneSaisie.builderFromage() instanceof FromageEntierOuMoitié);
	}
	
	@Test
	public void testSaisieFromageEtArticlesEntierOuMoitié() {
		SaisieFromage uneSaisie = new SaisieFromage("Brin d'Amour Corse", 
				"Ce fromage au lait cru de brebis Ã  pÃ¢te molle Ã  croÃ»te fleurie, propose un caractère corse qui s'exprime par sa croÃ»te recouverte d'herbes, "
				+"de sarriettes et de romarin. Le Brin d'Amour offre un goÃ»t inimitable et une saveur parfumée et intense, il reste une merveille pour le palais. "
				+"C'est tout le caractère du fromage corse vous faisant voyager qui s'exprime dans ce mariage très heureux de lait de brebis et dâ€™aromates. "
				+ "La Â«Fleur du maquisÂ» dont la pÃ¢te est fine et la couleur varie entre le rouge et le vert.", 
				TypeVente.ENTIER_OU_MOITIE, new String[]{""} ,new float[]{8.5F, 16.8F});
		Fromage f = uneSaisie.builderFromage();
		assertEquals("Brin d'Amour Corse", f.getDésignation());
		assertEquals(2, f.nombreArticles());
		assertEquals("moitié", f.getArticles().get(0).getClé());
		assertEquals(8.5F, f.getArticles().get(0).getPrixTTC(), 0F);
		assertEquals("entier", f.getArticles().get(1).getClé());
		assertEquals(16.8F, f.getArticles().get(1).getPrixTTC(), 0F);
	}
	
	@Test
	public void testSaisieFromageALunitéPlusieursChoix() {
		SaisieFromage uneSaisie = new SaisieFromage(null, null, TypeVente.A_L_UNITE_PlUSIEURS_CHOIX);
		assertTrue(uneSaisie.builderFromage() instanceof FromageALUnitéPlusieursChoix);
	}
	
	@Test
	public void testSaisieFromageEtArticlesALunitéPlusieursChoix() {
		SaisieFromage uneSaisie = new SaisieFromage("Cabris Fermier", 
				"Produit par nos soins sous le nom de l'EARL Chemin Fleury, nous respectons le savoir faire de cette grande région, tout en se distinguant "
						+"par une texture et un goÃ»t qui lui sont bien spécifiques. Au lait cru de chèvre, nos fromages présentent une croÃ»te fine salée au sel blanc "
						+"ou cendré renfermant une pÃ¢te souple, tendre et homogène de couleur blanche. "
						+"Leurs doux goÃ»ts de chèvre uniques raviront vos papilles et celles de vos convives.", 
						TypeVente.A_L_UNITE_PlUSIEURS_CHOIX, new String[]{"Moelleux cendré - Jeune et doux", "Moelleux blanc - Jeune et doux"} ,new float[]{3.39F});
		Fromage f = uneSaisie.builderFromage();
		assertEquals("Cabris Fermier", f.getDésignation());
		assertEquals(2, f.nombreArticles());
		assertEquals("Moelleux cendré - Jeune et doux", f.getArticles().get(0).getClé());
		assertEquals(3.39F, f.getArticles().get(0).getPrixTTC(), 0F);
		assertEquals("Moelleux blanc - Jeune et doux", f.getArticles().get(1).getClé());
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
				"Idéal pour un repas convivial avec vos amis ou en famille. C'est un mélange de parfum, d'onctuosité, et de raffinement pour "
				+"cette fondue savoyarde. Allez y piquez vos morceaux de pain dans le caquelon au centre de la table. "
				+"La fondue savoyarde est un plat régional de la gastronomie franÃ§aise Ã  base de fromage fondu et de pain, traditionnel des pays de Savoie. "  
				+"Ce plat populaire, vous envoÃ»tera de part ses multiples arÃ´mes.", 
				TypeVente.POUR_X_PERSONNES, new String[]{"3","5", "10"}, new float[]{22.5F, 33.75F, 67.5F});
		Fromage f = uneSaisie.builderFromage();
		assertEquals("Fondue Savoyarde", f.getDésignation());
		assertEquals(3, f.nombreArticles());
		assertEquals("pour 3 personnes", f.getArticles().get(0).getClé());
		assertEquals(22.5F, f.getArticles().get(0).getPrixTTC(), 0F);
		assertEquals("pour 5 personnes", f.getArticles().get(1).getClé());
		assertEquals(33.75F, f.getArticles().get(1).getPrixTTC(), 0F);
		assertEquals("pour 10 personnes", f.getArticles().get(2).getClé());
		assertEquals(67.5F, f.getArticles().get(2).getPrixTTC(), 0F);
	}
}
