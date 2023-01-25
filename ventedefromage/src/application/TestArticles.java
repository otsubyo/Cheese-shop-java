package application;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;

public class TestArticles {
	private Articles mesArticles = GenerationFromages.générationBaseFromages();
	
	@Test
	public void TestfiltreTypeFromageLait() {
		List<Fromage> liste = mesArticles.fromageAuLaitDe(TypeLait.VACHE);
		for (Fromage cheese : liste) {
			assertEquals(cheese.getTypeFromage(), TypeLait.VACHE);
		}
	}
	
	@Test
	public void TestfiltreTypeFromageChevre() {
		List<Fromage> liste = mesArticles.fromageAuLaitDe(TypeLait.CHEVRE);
		for (Fromage cheese : liste) {
			assertEquals(cheese.getTypeFromage(), TypeLait.CHEVRE);
		}
	}
	
	@Test
	public void TestfiltreTypeFromageBrebis() {
		List<Fromage> liste = mesArticles.fromageAuLaitDe(TypeLait.BREBIS);
		for (Fromage cheese : liste) {
			assertEquals(cheese.getTypeFromage(), TypeLait.BREBIS);
		}
	}
}
