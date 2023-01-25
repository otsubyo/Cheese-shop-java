package application;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

public class TestappPanier {
	
	Panier panier;
	List<Article> listepanier1;
	Article article;
	Fromage fromage1;
	
	@Before
	public void setup() {
		this.fromage1 = new Fromage("f1");
		this.panier = new Panier();
		this.article= new Article(fromage1,"clé1",10.5F);
		this.listepanier1= new ArrayList<Article>();
		this.listepanier1.add(article);
	}
	
	@After
	public void teardown() {
		this.panier = null;
		this.article = null;
		this.fromage1 = null;
		this.listepanier1 =null;
	}
	
	@Test
	public void panierVide() {
		assertEquals(0.0F,panier.getPrixTotal(),0.1f);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testlevéExceptionquantité() {
		panier.ajoutArticlePanier(article, 1);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testlevéExceptionSuppressionArticle() {
		panier.suppresionArticlePanier(article);
	}
	
	@Test
	public void testajoutPanier() {
		article.setQuantitéEnStock(20);
		panier.ajoutArticlePanier(article, 1);
		assertEquals(10.5F,panier.getPrixTotal(),0.1f);
	}
	
	@Test
	public void testquantitéArticle() {
		article.setQuantitéEnStock(20);
		panier.ajoutArticlePanier(article, 3);
		assertEquals(3,panier.getQuantitéArticle(article));
	}
	
	@Test
	public void testSuppressionArticle() {
		article.setQuantitéEnStock(20);
		panier.ajoutArticlePanier(article, 1);
		panier.suppresionArticlePanier(article);
		assertEquals(0.0F,panier.getPrixTotal(),0.1f);
	}
	
	@Test
	public void testValidationPanier() {
		article.setQuantitéEnStock(20);
		panier.ajoutArticlePanier(article, 1);
		panier.choixTransport(TypeTransport.COLISSIMO_POINT_RELAI);
		panier.validerPanier(true);
		assertEquals(15.4F,panier.getPrixTotal(),0.1f);
	}
	
	@Test
	public void testEstDansPanier() {
		article.setQuantitéEnStock(20);
		panier.ajoutArticlePanier(article, 3);
		assertEquals(true,panier.estDansPanier(article));
	}
	
	@Test
	public void testModificationStock1() {
		article.setQuantitéEnStock(20);
		panier.ajoutArticlePanier(article, 3);
		assertEquals(17,article.getQuantitéEnStock());
	}
	
	@Test
	public void testModificationStock2() {
		article.setQuantitéEnStock(20);
		panier.ajoutArticlePanier(article, 3);
		panier.suppresionArticlePanier(article);
		assertEquals(20,article.getQuantitéEnStock());
	}
	
	@Test
	public void testajoutPanier2() {
		article.setQuantitéEnStock(20);
		panier.ajoutArticlePanier(article, 3);
		assertEquals(listepanier1,panier.getPanier());
	}
	
	@Test
	public void testSuppressionArticle2() {
		article.setQuantitéEnStock(20);
		panier.ajoutArticlePanier(article, 3);
		panier.suppresionArticlePanier(article);
		listepanier1.remove(article);
		assertEquals(listepanier1,panier.getPanier());
	}
	
	@Test
	public void testTransport() {
		article.setQuantitéEnStock(20);
		panier.choixTransport(TypeTransport.COLISSIMO_POINT_RELAI);
		assertEquals(TypeTransport.COLISSIMO_POINT_RELAI,panier.getTransportType());
	}
	
	@Test
	public void testSuppressionPanier1() {
		article.setQuantitéEnStock(20);
		panier.ajoutArticlePanier(article, 1);
		panier.validerPanier(false);
		assertEquals(0.0F,panier.getPrixTotal(),0.1f);
	}
	
	@Test
	public void testSuppressionPanier2() {
		article.setQuantitéEnStock(20);
		panier.ajoutArticlePanier(article, 1);
		panier.validerPanier(false);
		listepanier1.remove(article);
		assertEquals(listepanier1,panier.getPanier());
	}
	
}
