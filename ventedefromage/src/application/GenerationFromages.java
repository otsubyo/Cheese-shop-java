package application;
import java.util.LinkedList;
import java.util.List;

public class GenerationFromages {

	public static void main(String[] args) {
		Articles mesArticles = g�n�rationBaseFromages();
		System.out.println("Liste des fromages et articles :");
		System.out.println();
		System.out.println(mesArticles.toStringFromagesEtArticles());
		System.out.println();
		System.out.println("Liste des articles et de leurs stocks :");
		System.out.println();
		mesArticles.reg�n�rationDuStock();
		System.out.println(mesArticles.toStringArticlesEtStock());
		System.out.println("Erreurs de saisie : ");
		System.out.println(mesArticles.v�rificationSaisie());
	}

	public static Articles g�n�rationBaseFromages() {
		Articles mesArticles = new Articles();
		mesArticles.addFromages(GenerationFromageBrebis());
		mesArticles.addFromages(GenerationFromageCh�vre());
		mesArticles.addFromages(GenerationFromageVache());
		mesArticles.reg�n�rationDuStock();
		return mesArticles;
	}

	private static List<Fromage> GenerationFromageBrebis() {
		List<Fromage>  fromagesAuLaitDeBrebis = new LinkedList<Fromage>();
		SaisieFromage[] fromages =  {    
				new SaisieFromage("Brebis au Bleu", 
				"Le brebis au bleu a une pâte tr�s fondante, onctueuse fine et non friable. "
				+"Son persillage est bleu vert, fonc�, pouvant pr�senter des traces d’aiguilles. "
				+"Une saveur franche, tr�s typ�e, savoureuse, sans amertume. Un piquant doux et agr�able. "
				+"Pas de goût acide, de rance ou de saponification. Pas d’exc�s de sel. "
				+"Un goût tr�s puissant, aux arômes typiques de brebis, en font d�finitivement un fromage à d�couvrir ! "
				+"Son croûtage est clair, l�g�rement morg�. Il est fabriqu� au lait pasteuris�.", 
				TypeVente.A_LA_COUPE_AU_POIDS, new String[]{"250 g", "500 g", "1 kg"}, new float[]{8.2F, 16.4F, 32.8F}),
				new SaisieFromage("Brebis au Fenugrec",
				"Cette tomme de brebis a une pâte douce et souple, et sa croûte est �paisse et friable de couleur brune. "
				+"Lors de sa fabrication le fenugrec est incorpor� au lait, son goût est subtil mais tr�s pr�sent.", 
				TypeVente.A_LA_COUPE_AU_POIDS, new String[]{"250 g", "500 g", "1 kg"}, new float[]{8.2F, 16.4F, 32.8F}), 
				new SaisieFromage("Brebis Nature", 
				"Cette tomme de brebis au lait pasteuris� vous offrira un doux goût de brebis, fruit� et tendre "
				+"sa pâte douce et souple accompagnera votre plateau de fromages "
				+"mais pourra �galement être un ingr�dient dans plusieurs de vos recettes.", 
				TypeVente.A_LA_COUPE_AU_POIDS, new String[]{"250 g", "500 g", "1 kg"}, new float[]{7.7F, 15.4F, 30.8F}), 
				new SaisieFromage("Brebis au Piment", 
				"Le Brebis au Piment est un fromage à d�couvrir pour ceux qui aiment les fromages doux et raffin�s à la fois. "
				+"Le piment d’Espelette est incorpor� au lait, son goût est subtil mais tr�s pr�sent "
				+ "ce qui donne à la tomme des arômes cors�s.", 
				TypeVente.A_LA_COUPE_AU_POIDS, new String[]{"250 g", "500 g", "1 kg"}, new float[]{8.2F, 16.4F, 32.8F}),
				new SaisieFromage( "Brebis à la Truffe",
				"Cette tomme de brebis recouverte d'une croûte �paisse et friable de couleur brune, "
				+"renferme une pâte ferme à tendance blanche parsem�e de morceaux de truffe. "
				+"Lors de sa fabrication la truffe est incorpor�e au lait, son goût est subtil mais tr�s pr�sent. " 
				+"Alliez plaisir et originalit�, en faisant d�couvrir la truffe associ�e aux saveurs du lait de brebis à vos convives.", 
				TypeVente.A_LA_COUPE_AU_POIDS, new String[]{"250 g", "500 g", "1 kg"}, new float[]{10.2F, 20.4F, 40.8F}),
				new SaisieFromage("Brin d'Amour Corse", 
				"Ce fromage au lait cru de brebis à pâte molle à croûte fleurie, propose un caract�re corse qui s'exprime par sa croûte recouverte d'herbes, "
				+"de sarriettes et de romarin. Le Brin d'Amour offre un goût inimitable et une saveur parfum�e et intense, il reste une merveille pour le palais. "
				+"C'est tout le caract�re du fromage corse vous faisant voyager qui s'exprime dans ce mariage tr�s heureux de lait de brebis et d’aromates. "
				+ "La «Fleur du maquis» dont la pâte est fine et la couleur varie entre le rouge et le vert.", 
				TypeVente.ENTIER_OU_MOITIE, new String[]{""} ,new float[]{8.5F, 16.8F}),
				new SaisieFromage("Brique de Brebis Fermi�re", 
				"Cette brique est fabriqu�e à base de lait cru de brebis, elle dispose d’une croûte tendre de couleur ivoire pliss�e "
				+"et d’une pâte onctueuse et fondante de couleur blanche. "
				+"Lors de sa d�gustation vous d�couvrirez des saveurs fruit�es, l�g�rement sal�es avec des arômes de brebis, de noisette et de lait chaud. "  
				+"Une authenticit� qui r�v�le la diversit� des pâturages du Tarn grâce à son herbage riche et floral. "
				+ "Un vrai produit qui doit sa beaut� simplement au fermier artisan. "
				+ "Elle est fondante, douce et persistante, prend du caract�re sans agressivit� en s’affinant avec un petit goût de noisette.", 
				TypeVente.A_L_UNITE,new String[]{""} ,new float[]{7.89F}),
				new SaisieFromage("L'Encalat", 
				"D'origine du Larzac, ce fromage cr�meux au d�licieux goût de brebis est incontournable. "
				+"Sa texture en bouche est jug�e fondante voire tr�s fondante. C'est un produit doux à la saveur sal�e plutôt faiblement prononc�e. "
				+"L'Encalat est un fromage à pâte molle fleurie. Un affinage en cave de 2 semaines, offre une texture coulante et à cœur plus pâteuse. "
				+"Des saveurs à d�couvrir de toute urgence !!", 
				TypeVente.A_L_UNITE, new String[]{""} ,new float[]{8.4F}),
				new SaisieFromage("Ossau Iraty", 
				"Ce fromage au lait pasteuris� de brebis dispose d’une croûte dure de couleur beige orang� à gris clair à l’ext�rieur, et d’une pâte lisse "
				+"de couleur ivoire à l’int�rieur pr�sentant de petites ouvertures. En bouche, l’Ossau Iraty d�veloppera des saveurs fruit�es avec des notes "
				+"de noisette et de lait de brebis. De consistance onctueuse, ferme et dure, l'Ossau Iraty, d'origine Basque, se d�guste en amuse bouche, "
				+ "en casse croute, ou même en condiment. Ses arômes sont fruit�s et long en bouche.", 
				TypeVente.A_LA_COUPE_AU_POIDS, new String[]{"250 g", "500 g", "1 kg", "1/2 Tomme (2.1 kg environ)"}, new float[]{8.5F, 16.99F, 33.99F, 57.11F}),
				new SaisieFromage("Ossau Iraty - Saint Michel", 
				"Au lait cru de brebis, l'Ossau Iraty Saint-Michel dispose d’une croûte dure de couleur brune à l’ext�rieur, "
				+"et d’une pâte lisse l�g�rement cassante de couleur jaune à l’int�rieur. En bouche, elle d�veloppera des saveurs fruit�es relev�es "
				+"de notes de lait de brebis et de l�g�res notes de noisette. ", 
				TypeVente.A_LA_COUPE_AU_POIDS, new String[]{"250 g", "500 g", "1 kg"}, new float[]{9.25F, 18.5F, 36.99F}),
				new SaisieFromage("Roquefort l'Arbas",
				"Une saveur persill�e, plutôt acide et un peu fruit�, c’est ce que vous proposera ce fromage au lait cru de brebis. "
				+"Le Roquefort de l'Arbas est un fromage typ� de couleur blanc cr�me ou ivoire à l’ext�rieur à pâte fondante et onctueuse, "
				+"et parfum�e à l’int�rieur avec des veines bleu-vert bien r�parties et marbr�.", 
				TypeVente.A_LA_COUPE_AU_POIDS, new String[]{"250 g", "500 g", "1 kg"}, new float[]{7.25F, 14.5F, 28.99F}),
				new SaisieFromage("Roquefort Baragnaudes", 
				"Fromage au lait cru de brebis, le Roquefort Baragnaudes pr�sente une pâte fondante et onctueuse de couleur blanche ivoire pâle, "
				+"avec des veines bleues intenses bordant de nombreuses et larges cavit�s. "
				+"D’une odeur d�licate de lait de brebis elle s’accompagne d’un goût puissant aux arômes miell�s  qui ravira tous vos convives. " 
				+"Fin et onctueux, le Roquefort des Caves Baragnaudes invite à un v�ritable voyage des sens. "
				+"Avec des senteurs de sous-bois et de champignons, il d�veloppe un bouquet aromatique raffin� qui, port� par une texture onctueuse, "
				+"se diffuse lentement pour terminer par des notes noisettes et beurr�es.", 
				TypeVente.A_LA_COUPE_AU_POIDS, new String[]{"250 g", "500 g", "1 kg"}, new float[]{9.75F, 19.5F, 39F}),
				new SaisieFromage("Roquefort Carles",
				"Une saveur typiquement persill�e, plutôt acide et un peu fruit�, c’est ce que vous proposera ce fromage au lait cru de brebis. "
				+"Le Roquefort Carles est un fromage typ� de couleur blanc cr�me ou ivoire à l’ext�rieur à pâte fondante onctueuse, cr�meuse et parfum�e "
				+"à l’int�rieur. La maison Carles est une entreprise familiale cr��e en 1927, qui depuis trois g�n�rations, produit un roquefort d’exception, "
				+ "artisanal et de grande qualit�. C'est un m�lange r�ussi d'exigence, de tradition et de modernit� qui fait du Roquefort Carles, "
				+ "un grand moment gustatif.", 
				TypeVente.A_LA_COUPE_AU_POIDS, new String[]{"250 g", "500 g", "1 kg"}, new float[]{10.95F, 21.9F, 43.8F}),
				new SaisieFromage("Roquefort Papillon", 
				"Fromage au lait cru de brebis, le Roquefort Papillon pr�sente une pâte fondante et onctueuse de couleur blanche à ivoire pâle, "
				+"avec des veines bleues intenses bordant de nombreuses et larges cavit�s. "
				+"D’une odeur d�licate de lait de brebis elle s’accompagne d’un goût puissant et sal� qui ravira tous vos convives. "
				+"Depuis 1906, les fromageries PAPILLON façonnent un Roquefort authentique n� de la rencontre des hommes et de la nature. "
				+"Un lien plus que centenaire, dont la notori�t� du produit r�sulte de la confiance envers un savoir-faire naturel, une tradition, un goût, "
				+"qui le rendent inimitable. ", 
				TypeVente.A_LA_COUPE_AU_POIDS, new String[]{"250 g", "500 g", "1 kg"}, new float[]{9.25F, 18.5F, 36.99F}),
				new SaisieFromage("Tomme d'Estaing", 
				"L’ESTAING est un fromage au lait cru de brebis, à pâte press�e avec une croûte fleurie. Sa pâte tr�s souple, favorise en bouche "
				+"l’expression de tous les parfums du lait de Brebis. Cette tomme de brebis, au lait cru est produite sur le Larzac, et dispose d'un affinage "
				+"en cave entre 2 à 6 mois. Sa texture donne un produit qui ne pourra que ravir votre palais. Des saveurs inoubliables...", 
				TypeVente.A_LA_COUPE_AU_POIDS, new String[]{"250 g", "500 g", "1 kg"}, new float[]{8.99F, 17.99F, 35.99F}),
				new SaisieFromage("Tomme Le Lou Bren", 
				"D'une couleur de croûte orang�e, le Lou Bren peut avoir des tâches grises. La pâte est souple et de couleur ivoire avec quelques fines ouvertures. "
				+"Son odeur est fine et l�g�re rappelant la brebis. Sa saveur est florale et acidul�e. " 
				+"D'origine du Larzac, le Lou Bren est affin� en cave humide ce qui donnera une souplesse et un parfum de la flore des Causses, "
				+"en restant toujours doux en bouche.", 
				TypeVente.ENTIER_OU_MOITIE, new String[]{""} ,new float[]{10.3F, 18.45F})
				};
		for (SaisieFromage s : fromages) {
			fromagesAuLaitDeBrebis.add(s.builderFromage());
		}
		for (Fromage f : fromagesAuLaitDeBrebis)
			f.updateTypeFromage(TypeLait.BREBIS);
		return fromagesAuLaitDeBrebis;
	}

	private static List<Fromage> GenerationFromageCh�vre() {
		List<Fromage>  fromagesAuLaitDeCh�vre = new LinkedList<Fromage>();
		SaisieFromage[] fromages =  { 
				new SaisieFromage("Bouton de Culotte fermier", 
				"Au lait cru de ch�vre, ce petit fromage pr�sentera une croûte de couleur jaune pâle qui deviendra brunâtre en s’affinant, "
				+"renfermant une pâte tendre de couleur blanche qui deviendra cassante à maturit�. "
				+"Mais il ne faudra pas se fier à son apparence, malgr� sa petite taille celui-ci vous offrira un goût prononc� caprin "
				+"accompagn� d’une forte odeur de ch�vre.", 
				TypeVente.A_L_UNITE, new String[]{""} ,new float[]{3.8F}),
				new SaisieFromage("Pouligny Saint Pierre", 
				"Pyramide au lait cru de ch�vre, ce fromage vous offrira une croûte fine recouverte de l�g�res moisissures blanches et bleut�es renfermant "
				+"une pâte ferme et souple de couleur ivoire. Ce fromage fermier vous pr�sentera un goût de noisette accompagn� d’une l�g�re odeur caprine "
				+"qui sera appr�ci� par tous vos convives. Le Pouligny Saint Pierre pr�sente une �tendue de saveurs lui permettant d'être d�gust� par un large "
				+"public. Il est un produit authentiquement fermier et est fabriqu� dans le Berry.", 
				TypeVente.A_L_UNITE, new String[]{""} ,new float[]{8.9F}),
				new SaisieFromage("Rocamadour", 
				"Petit fromage au lait cru de ch�vre, il se pr�sentera en forme d’un palet proposant une croûte fine et fondante de couleur ivoire renfermant "
				+"une pâte onctueuse et souple de couleur blanche. Le Rocamadour sera un d�lice pour vos papilles vous offrant des saveurs de ch�vre, "
				+"de cr�me et de noisette relev� d’un peu de sel, le tout accompagn� d’une l�g�re odeur caprine. En bouche, le Rocamadour tout en douceur "
				+"fond contre le palais, suivant les goûts, on peut l'appr�cier cr�meux ou sec avec des arômes plus puissants.", 
				TypeVente.A_L_UNITE, new String[]{""} ,new float[]{2.9F}),
				new SaisieFromage("Persill� de Ch�vre", 
				"La particularit� de ce fromage est qu'il ressemble à un bleu, alors qu'il est fabriqu� à partir de lait pasteuris� de ch�vre. "
				+"Fromage original à la texture fondante et grasse du roquefort, il a un goût franc et puissant avec une saveur fine et prononc�e. "
				+"Le fromage doit fondre sous le palais en laissant une �tonnante sensation de salinit�. "
				+"Laissez-le s'affiner et il pourra être tr�s tr�s fort !", 
				TypeVente.A_LA_COUPE_AU_POIDS, new String[]{"250 g", "500 g"}, new float[]{10.95F, 21.9F}),
				new SaisieFromage("Tomme de Ch�vre", 
				"D’un goût subtil et d’une personnalit� tout en douceur et de finesse, ce fromage au lait pasteuris� de ch�vre à pâte press�e non cuite "
				+"ravivera vos papilles gustatives. La Tomme de Ch�vre offre une pâte ferme, fondante en bouche qui rel�vera une saveur typique et prononc�e "
				+"du lait de ch�vre avec des arômes de fruits secs. Fromage traditionnel, la d�gustation de la Tomme de Ch�vre en tranches fines allie "
				+"le charme de la rusticit� à la d�couverte d'arômes d�licats, elle pourra être utilis�e �galement en raclette.", 
				TypeVente.A_LA_COUPE_AU_POIDS, new String[]{"250 g", "500 g", "1 kg", "1/2 Tomme (2 kg environ)"}, new float[]{8.2F, 16.4F, 32.8F, 55.76F}),
				new SaisieFromage("Tomme de Ch�vre Thym Miel", 
				"Fromage originaire de la Hollande, la d�gustation de cette tomme de ch�vre vous offrira des saveurs à la fois d�licates de miel et de caramel, "
				+"et prononc�es de thym et d'arômes de ch�vre. En plus de son goût subtil, cette tomme est recouverte d'une croûte fleurie de thym "
				+"lav�e au caramel, celle-ci pr�sente un m�lange de couleur diff�rente, et renferme une pâte tendre à ferme de couleur ivoire "
				+"mouchet�e de thym.", 
				TypeVente.A_LA_COUPE_AU_POIDS, new String[]{"250 g", "500 g", "1 kg"}, new float[]{8.95F, 17.9F, 35.8F}),
				new SaisieFromage("Bûchette Fermi�re", 
				"D�livrant une onctuosit� rare, au lait cru de ch�vre, nos fromages pr�sentent une croûte fine cendr�e renfermant une pâte souple, "
				+"tendre et homog�ne de couleur blanche. Leurs doux goûts de ch�vre uniques raviront vos papilles et celles de vos convives. " 
				+"Cette Buchette Fermi�re est produite par nos soins sous le nom de l'EARL du Chemin Fleury, une ferme familiale situ�e à Louzy "
				+"dans les Deux- S�vres. ", 
				TypeVente.A_L_UNITE, new String[]{""} ,new float[]{3.99F}), 
				new SaisieFromage("Cabris Fermier", 
				"Produit par nos soins sous le nom de l'EARL Chemin Fleury, nous respectons le savoir faire de cette grande r�gion, tout en se distinguant "
				+"par une texture et un goût qui lui sont bien sp�cifiques. Au lait cru de ch�vre, nos fromages pr�sentent une croûte fine sal�e au sel blanc "
				+"ou cendr� renfermant une pâte souple, tendre et homog�ne de couleur blanche. "
				+"Leurs doux goûts de ch�vre uniques raviront vos papilles et celles de vos convives.", 
				TypeVente.A_L_UNITE_PlUSIEURS_CHOIX, new String[]{"Moelleux cendr� - Jeune et doux", "Moelleux blanc - Jeune et doux"} ,new float[]{3.39F}),
				new SaisieFromage("Chabis Fermier", 
				"Au lait cru de ch�vre, nos fromages pr�sentent une croûte fine sal�e au sel blanc ou cendr�e renfermant une pâte souple, "
				+"tendre et homog�ne de couleur blanche. Leurs doux goûts de ch�vre uniques raviront vos papilles et celles de vos convives. Le Chabis est "
				+"un habile m�lange de saveurs : l�g�rement sucr� avec une pointe de sel, d�licatement acide dans un arôme de lait. "
				+"Fabriqu� en Poitou à l'EARL du chemin fleury, c’est un excellent fromage de tradition !", 
				TypeVente.A_L_UNITE_PlUSIEURS_CHOIX, new String[]{"Moelleux cendr� - Jeune et doux", "Moelleux blanc - Jeune et doux"} ,new float[]{3.99F}),
				new SaisieFromage("Chabis frais aromatis� Fermier", 
				"Produit par nos soins sous le nom de l'EARL Chemin Fleury, au lait cru de ch�vre, nos Chabis frais aromatis�s pr�sentent une pâte tendre "
				+"moelleuse et fondante en bouche de couleur blanche recouverte de diff�rentes �pices : �chalotes, ails et fines herbes ou encore poivres "
				+"qui lui conf�re un goût exquis. Leurs doux goûts de ch�vre uniques raviront vos papilles et celles de vos convives.", 
				TypeVente.A_L_UNITE_PlUSIEURS_CHOIX, new String[]{"Echalotes", "Ail et fines herbes", "Poivres"} ,new float[]{3.99F}),
				new SaisieFromage("Coeur de ch�vre", 
				"Au lait cru de ch�vre, nos fromages pr�sentent une croûte fine sal�e au sel blanc ou cendr� renfermant une pâte souple, tendre et homog�ne "
				+"de couleur blanche. Leurs doux goûts de ch�vre uniques raviront vos papilles et celles de vos convives. Le coeur de ch�vre est un fromage "
				+"de ch�vre cr�meux, son goût peut se r�v�ler aussi bien doux que cors�, tant sa force varie en rapport imm�diat avec son degr� d’affinage. "
				+"Il est conçu par l'EARL du Chemin Fleury.", 
				TypeVente.A_L_UNITE, new String[]{""} ,new float[]{3.99F}),
				new SaisieFromage("Crottin Fermier", 
				"Au lait cru de ch�vre, nos fromages pr�sentent une croûte fine sal�e au sel blanc renfermant une pâte souple, tendre et homog�ne de couleur "
				+"blanche. Leurs doux goûts de ch�vre uniques raviront vos papilles et celles de vos convives. Issu du EARL du Chemin Fleury, ce fromage a "
				+"une texture tr�s tendre et moelleuse quand il est jeune. Il se durcit avec le temps pour devenir tr�s sec. "
				+"Il d�veloppe pleins d’arômes avec un goût de ch�vre marqu�s au d�part.\r\n", 
				TypeVente.A_L_UNITE_PlUSIEURS_CHOIX, new String[]{"moelleux (jeune et doux)", "affin� (tr�s prononc�)"} ,new float[]{3.90F}),
				new SaisieFromage("Crottin frais aromatis� Fermier", 
				"Produit par nos soins, sous le nom de l'EARL Chemin Fleury, au lait cru de ch�vre, nos crottins frais aromatis�s pr�sentent une pâte tr�s tendre "
				+"et moelleuse de couleur blanche recouverte de diff�rentes �pices : �chalotes, ails et fines et herbes ou encore poivre. "
				+ "Leurs doux goûts de ch�vre uniques raviront vos papilles et celles de vos convives.", 
				TypeVente.A_L_UNITE_PlUSIEURS_CHOIX, new String[]{"Poivre", "Echalotes", "Ail et fines herbes"} ,new float[]{2.99F}),
				new SaisieFromage("Faisselle de ch�vre 500g", 
				"La v�ritable faisselle est le caill� de lait de ch�vre frais mis à �goutter dans une faisselle puis dans un pot pour garder un peu de son "
				+"petit lait. Son goût varie selon les saisons. D'une saveur douce, elle prend au printemps un parfum diff�rent avec l'herbe verte et fraîche "
				+"des champs. Notre faisselle maison est appr�ci�e pour sa saveur fraîche et sa l�g�ret�. "
				+ "Au petit d�jeuner, en en-cas ou au dessert, la faisselle se consomme à toutes heures et vous apportera un peu de fraîcheur."
				, TypeVente.A_L_UNITE,new String[]{""} ,new float[]{3.99F}),
				new SaisieFromage("Galet de ch�vre", 
				"Produit dans les Deux-S�vres par l'EARL Chemin Fleury, au lait cru de ch�vre, le Galet de ch�vre pr�sente une croûte fine sal�e au sel blanc "
				+"renfermant une pâte souple, tendre et homog�ne de couleur blanche. Ce fromage vous offrira un doux goût de ch�vre dont les notes caprines "
				+"seront plus prononc�es en s'affinant.", 
				TypeVente.A_L_UNITE, new String[]{""}, new float[]{3.99F}),
				new SaisieFromage("Long Fermier", 
				"Produit par nos soins sous le nom de l'EARL Chemin Fleury, au lait cru de ch�vre, le long fermier met en valeur toutes les qualit�s du lait, "
				+"sa l�g�re acidit�, son discret goût de sel, et sa douceur se d�veloppent sous le palais. Les couleurs et la texture sont agr�ables et "
				+"laissent un long arri�re-goût en bouche.", 
				TypeVente.A_L_UNITE_PlUSIEURS_CHOIX, new String[]{"Blanc Moelleux - jeune et doux", "Cendr� Moelleux - jeune et doux"} ,new float[]{5.59F}),
				new SaisieFromage("Le Trio Ap�ro", 
				"Produit par nos soins, sous le nom de l'EARL Chemin Fleury, au lait cru de ch�vre, nos crottins frais aromatis�s pr�sentent une pâte tr�s tendre "
				+"et moelleuse de couleur blanche recouverte de diff�rentes �pices : �chalotes, ails et fines et herbes ou encore poivre. "
				+"Leurs doux goûts de ch�vre uniques raviront vos papilles et celles de vos convives.", 
				TypeVente.A_L_UNITE, new String[]{""}, new float[]{6.99F}),
				new SaisieFromage("Ovale Fermier", 
				"Au lait cru de ch�vre, ce fromage a une croûte l�g�rement cendr�e. Sa pâte est d'un blanc pur. Elle reste ferme tout en �tant souple "
				+"et moelleuse à la fois sous le doigt. Ce fromage d�gage une odeur subtile et agr�able. Leurs doux goûts de ch�vre uniques raviront "
				+"vos papilles et celles de vos convives. Une saveur exprim�e par la douceur d'un lait riche et cr�meux.", 
				TypeVente.A_L_UNITE, new String[]{""}, new float[]{3.99F}),
				new SaisieFromage("Pav� Fermier", 
				"Au lait cru de ch�vre, ce fromage pr�sente une croûte fine sal�e au sel cendr� renfermant une pâte souple, tendre et homog�ne de couleur blanche. "
				+"Son doux goût de ch�vre unique ravira vos papilles et celles de vos convives. En forme de pav�, il est fabriqu� à la Ferme du Chemin Fleury "
				+"dans les Deux-S�vres. Son expression buccale est tr�s pr�sente avec une mont�e rapide et pleine de d�licatesse.", 
				TypeVente.A_L_UNITE, new String[]{""}, new float[]{3.99F}),
				new SaisieFromage("Pyramide Fermi�re", 
				"La pyramide fermi�re est un fromage de ch�vre cr�meux, son goût peut se r�v�ler aussi bien doux que cors�, tant sa force varie en rapport "
				+"imm�diat avec son degr� d'affinage. Fabriqu�e par nos soins sous le nom de l'EARL chemin Fleury, la pyramide est un fromage au lait cru de "
				+"ch�vre, elle pr�sente une croûte fine sal�e au sel cendr� renfermant une pâte souple, tendre et homog�ne de couleur blanche.", 
				TypeVente.A_L_UNITE, new String[]{""}, new float[]{5.49F}), 
				new SaisieFromage("Sein Fleury", 
				"Au lait cru de ch�vre, le Sein Fleury pr�sente une croûte fine sal�e au sel cendr� renfermant une pâte souple, tendre et homog�ne de "
				+"couleur blanche. Son doux goût de ch�vre unique ravira vos papilles et celles de vos convives. Produit par des producteurs locaux de "
				+"EARL du chemin fleury, il respecte le savoir faire de cette grande r�gion, tout en se distinguant par une texture et un goût qui lui "
				+"sont bien sp�cifique.", 
				TypeVente.A_L_UNITE, new String[]{""}, new float[]{4.2F}),
				new SaisieFromage("Selle Fleury", 
				"Produit dans les Deux-S�vres par l'EARL Chemin Fleury, au lait cru de ch�vre, le Selle Fleury pr�sente une croûte fine sal�e au sel cendr� "
				+"renfermant une pâte souple, tendre et homog�ne de couleur blanche. Ce fromage vous offrira un doux goût de ch�vre dont les notes caprines "
				+"seront plus prononc�es en s'affinant.", 
				TypeVente.A_L_UNITE, new String[]{""}, new float[]{3.99F})
		};
		for (SaisieFromage s : fromages) {
			fromagesAuLaitDeCh�vre.add(s.builderFromage());
		}
		for (Fromage f : fromagesAuLaitDeCh�vre)
			f.updateTypeFromage(TypeLait.CHEVRE);
		return fromagesAuLaitDeCh�vre;	
	}

	private static List<Fromage> GenerationFromageVache() {
		List<Fromage>  fromagesAuLaitDeVache = new LinkedList<Fromage>();
		SaisieFromage[] fromages =  { 
				new SaisieFromage("Abondance", 
				"De fabrication fermi�re, et d'un affinage de 10 semaines en caves avec des soins de frottage, cette tomme d�gage une odeur de cave et offre "
				+"un fondant en bouche d�veloppant un goût de noisette. Ce fromage au lait cru de vache se pr�sente sous la forme d’une meule recouverte "
				+"d’une croûte lisse de couleur brune à l�g�rement grise, renfermant une pâte souple et fondante de couleur ivoire à jaune "
				+"l'Abondance pr�sente quelques trous. Elle vous offrira des saveurs fruit�es relev�es d’une l�g�re pointe de sel avec un parfum de noisette.", 
				TypeVente.A_LA_COUPE_AU_POIDS, new String[]{"250 g", "500 g", "1 Kg"}, new float[]{5.52F, 11.04F, 22.09F}),
				new SaisieFromage("Appenzeller", 
				"Le fromage Appenzeller est l’une des plus grandes sp�cialit�s fromag�res suisses. Savoureux et raffin�, il est une valeur sûre et "
				+"est appr�ci� depuis plus de 700 ans. C'est un fromage au lait cru de vache à pâte press�e demi-cuite, typique au goût cors�, "
				+"il doit son goût unique au traitement à la saumure aux herbes. il vous offrira un goût raffin� et aromatis� avec une pâte tendre "
				+"recouverte d’une croûte aux tons brun et rouge. L’Appenzeller d’un caract�re affirm� restera un myst�re mais un d�lice pour nos papilles." 
				, TypeVente.A_LA_COUPE_AU_POIDS, new String[]{"250 g", "500 g", "1 Kg"}, new float[]{8.9F, 17.8F, 35.6F}), 
				new SaisieFromage("Beaufort d'Alpage", 
				"Consid�r� comme le «Prince des Gruy�res», ce fromage au lait cru de vache à pâte press�e cuite, vous offrira un parfum fruit� et une "
				+"onctuosit� accompagn� d’un goût de noisette tr�s prononc�. Fromage savoyard AOC, le Beaufort se pr�sente d’une pâte ferme de couleur ivoire "
				+"à jaune pâle, recouvert d’une croûte lisse d’une couleur jaune orang�e. Il reste un fromage au goût typ� sans pour autant être fort.", 
				TypeVente.A_LA_COUPE_AU_POIDS, new String[]{"250 g", "500 g", "1 Kg"}, new float[]{12F, 24F, 48F}), 
				new SaisieFromage("Bleu d'Auvergne", 
				"Fromage au lait cru de vache à pâte persill�e, ce Bleu d’Auvergne dispose d’un goût affirm� et d’une texture fondante. "
				+"Celui-ci vous offrira une pâte de couleur blanche à ivoire parsem�e de moisissures bleu-vert, et une croûte fine naturelle fleurie "
				+"qui peut pr�senter des reflets de la même teinte. Ce bleu typ� mais pas fort sera d�licieux en fin de repas.", 
				TypeVente.A_LA_COUPE_AU_POIDS, new String[]{"250 g", "500 g", "1 Kg"}, new float[]{6.7F, 13.4F, 26.8F}), 
				new SaisieFromage("Bleu de Gex", 
				"Fromage au lait cru de vache, il dispose d’une croûte fine, s�che et l�g�rement farineuse de couleur blanche à jaune et renferme "
				+"une pâte souple, onctueuse et l�g�rement friable de couleur blanche à ivoire pr�sentant des veines bleues-vertes. "
				+"Le Bleu Gex vous offrira un goût l�ger et doux accompagn�e d’une saveur de noisette et de champignon, le tout relev� d’une l�g�re amertume "
				+"et d’une pointe de sel. ", 
				TypeVente.A_LA_COUPE_AU_POIDS, new String[]{"250 g", "500 g", "1 Kg"}, new float[]{5.6F, 11.2F, 22.4F}), 
				new SaisieFromage("Bleu des Causses", 
				"Principalement fabriqu� en Aveyron à Rodez et affin� dans les caves de Peyrelade dans les Gorges du Tarn, ce fromage est en quelque sorte "
				+"la version au lait de vache du Roquefort. En effet voisin de celui-ci avec son histoire, il est un fromage au lait pasteuris� de vache "
				+"à pâte persill�e. Il a une qualit� dans sa texture à la fois tendre et fondante et il propose une saveur alliant douceur et puissance. "
				+"Le Bleu des Causses est un bouquet raffin� qui offre une richesse aromatique à consommer toute l’ann�e de l’ap�ritif au dessert. " 
				+"Son goût cr�meux vous surprendra !", 
				TypeVente.A_LA_COUPE_AU_POIDS, new String[]{"250 g", "500 g", "1 Kg"}, new float[]{5.99F, 11.98F, 23.96F}),
				new SaisieFromage("Boulette d'Avesnes", 
				"Facilement reconnaissable à sa forme conique et irr�guli�re, la Boulette d'Avesnes fermi�re est un fromage au lait cru de vache de "
				+"couleur rouge brun. Elle est fabriqu�e à partir de brisures de maroilles frais enrichi de persil, d’estragon et de clou de girofle, "
				+"puis recouverte de paprika. Son odeur et son goût relev� et savoureux sont incomparables.", 
				TypeVente.A_L_UNITE, new String[]{""}, new float[]{6.5F}), 
				new SaisieFromage("Brie aux truffes", 
				"Couvert d’un blanc duveteux, d’une croûte fine pigment�e parfois de tâches rouges et proposant une pâte coulante. "
				+"L’arôme à la fois fin et puissant de la truffe se d�layant dans la pâte dense et les touches noiset�es du Brie, le tout li� par une "
				+"pr�paration cr�meuse à souhait. C’est un fromage pour les amateurs de saveurs prononc�es. Sp�cialit� de la maison des fromages, "
				+"le Brie Truff� est un d�lice, fabriqu� par nos soins selon des savoirs-faire secrets, le mariage du Brie et de la Truffe est "
				+"un chef d’œuvre gastronomique ! Nous vous aurons pr�venu : le goûter c'est l'adopter !", 
				TypeVente.A_L_UNITE, new String[]{""}, new float[]{15F}), 
				new SaisieFromage("Brie de Meaux", 
				"Situ�e au cœur de verts pâturages de la Meuse, la Fromagerie Dong� est la r�f�rence en mati�re de Brie de Meaux AOC depuis trois g�n�rations. "
				+"Couvert d’un blanc duveteux, d’une croûte fine pigment�e parfois de tâches rouges et proposant une pâte jaune paille clair onctueuse, "
				+"souple mais non coulante, le Brie de Meaux nous offre une saveur fine avec un goût de noisette. C’est un fromage pour les amateurs de "
				+"saveurs prononc�es.", 
				TypeVente.A_LA_COUPE_AU_POIDS, new String[]{"250 g", "500 g", "1 Kg"}, new float[]{5.99F, 11.98F, 23.96F}), 
				new SaisieFromage("Brie de Melun", 
				"Plus petit que son grand fr�re «le Brie de Meaux», il a cependant plus de caract�re. Ce fromage au lait cru de vache vous offrira une pâte "
				+"souple de couleur jaune d’or à l’int�rieur, et une croûte fleurie blanche parsem�e de stries ou de taches rouges ou brunes à l’ext�rieur. "  
				+"Le Brie de Melun vous proposera une saveur tr�s fruit�e avec un l�ger goût de noisette accompagn�e d’une odeur du terroir qui le rendra "
				+"indispensable sur un plateau de fromages. Il pourra aussi entrer dans la confection de sp�cialit�s r�gionales dont la plus connue, "
				+"la croûte au brie.", 
				TypeVente.A_LA_COUPE_AU_POIDS, new String[]{"250 g", "500 g", "1 Kg"}, new float[]{9.15F, 18.3F, 36.6F}), 
				new SaisieFromage("Brillat Savarin", 
				"Portant le nom de l'ancien gastronome, ce double cr�me à la forme d'un disque au lait cru de vache est un fromage à pâte molle à croûte "
				+"fleurie cotonneuse et blanche. Le Brillat Savarin se mange jeune et bien frais, mais il conservera sa douceur au palais en s’affinant et "
				+"vous offrira en bouche des arômes de bois et de noisette avec un cœur de cr�me aux saveurs douces l�g�rement acidul�es.", 
				TypeVente.ENTIER_OU_MOITIE, new String[]{""}, new float[]{7.5F, 14.5F}), 
				new SaisieFromage("Camembert de Buffone", 
				"Fromage au lait pasteuris� de Bufflonne, il se pr�sente sous la forme d’un petit camembert recouvert d'une fine croûte fleurie blanche, "
				+"renfermant un doux cœur cr�meux", 
				TypeVente.A_L_UNITE, new String[]{""}, new float[]{7.5F}), 
				new SaisieFromage("Camembert de Normandie AOP", 
				"Connu comme le fromage français par excellence, et de valeur sûre, il ne sera jamais de trop sur un plateau. Le Camembert de Normandie "
				+"vous offrira une saveur fruit�e avec un goût l�g�rement sal� qui s’accentuera en s’affinant. "
				+"Moul� à la louche il a une forme r�guli�re et  une surface stri�e, sa pâte est lisse et souple de couleur ivoire à jaune clair "
				+"lorsqu'il est affin� \"à cœur\". Demi-affin�, il reste au centre de la pâte un \"noyau\" blanc central de 2 mm. "
				+"Il est obligatoirement commercialis� dans une boite en bois.", 
				TypeVente.A_L_UNITE, new String[]{""}, new float[]{5.6F}), 
				new SaisieFromage("Camembert Gaslondes", 
				"Parfait pour les amateurs de camembert fort, le Gaslondes tr�s moelleux vous proposera un goût et un parfum prononc� sans piquant. "
				+"Fromage au lait cru de vache, il dispose d’une croûte stri�e et duvet�e de blanc l�g�rement pigment�e de rouge en fonction de l’affinage, "
				+"et qui renferme une pâte souple de couleur blanche à jaune cr�me. Le Camembert Gaslondes vous apportera des saveurs fruit�es accompagn�es "
				+"d’arômes laitiers.", 
				TypeVente.A_L_UNITE, new String[]{""}, new float[]{7.3F}), 
				new SaisieFromage("Chaource fermier", 
				"Excellent toute l'ann�e, le Chaource fermier est tr�s appr�ci� pour sa pâte. Fromage au lait cru de vache, il propose une croûte blanche "
				+"et duveteuse à l’ext�rieur, et une pâte fine et fondante à l’int�rieur accompagn�e d’arômes de cr�me et de champignons frais, "
				+"relev�s par une l�g�re pointe de sel. Sa saveur douce et fruit�e de noisette sera d�licieuse à d�guster en ap�ritif avec un porto "
				+"ou même un champagne. Un d�lice de raffinement.", 
				TypeVente.A_L_UNITE, new String[]{""}, new float[]{6.9F}), 
				new SaisieFromage("Comt� 18 mois", 
				"Fromage d'excellence, au lait cru de vache, le Comt� est un fromage à pâte press�e cuite et une texture souple et ferme à la fois. "
				+"Le Comt� reste un fromage d’exception qui se caract�rise par une grande diversit� aromatique. "
				+"Il pr�sente des arômes à dominantes fruit�s en �t�, et torr�fi�s avec des nuances de noisettes en hiver. Avant tout une histoire d'hommes "
				+"profond�ment attach�s aux valeurs de terroir et à celles du Comt�, les Maîtres de cave Marcel Petite s�lectionne leurs Comt�s en "
				+"recherchant la meilleure qualit� de finesse, subtilit� et intensit� du goût. Un d�lice dans vos plateaux !", 
				TypeVente.A_LA_COUPE_AU_POIDS, new String[]{"250 g", "500 g", "1 Kg"}, new float[]{8.95F, 17.9F, 35.8F}), 
				new SaisieFromage("Comt� sp�cial de Noël", 
				"Ce comt� est un produit tr�s rare à obtenir par notre partenaire PETITE. En effet, il est tr�s convoit� pour toutes ses qualit�s. "
				+"Fromage d'excellence, au lait cru de vache, ce Comt� à pâte press�e cuite d'une texture souple et ferme à la fois affin� 28 mois, "
				+"vous pr�sentera une pâte plus jaune parsem�e de mini-cristaux (appel� tyrosine) signe d'un affinage parfait et r�ussi. "
				+"Le Comt� reste un fromage d’exception qui se caract�rise par une grande diversit� aromatique. "
				+"Il pr�sente des arômes à dominantes fruit�s en �t�, et torr�fi�s avec des nuances de noisettes en hiver.", 
				TypeVente.A_LA_COUPE_AU_POIDS, new String[]{"250 g", "500 g", "1 Kg"}, new float[]{11.5F, 23F, 46F}), 
				new SaisieFromage("Coulommiers", 
				"Grand fr�re du Camembert et petit fr�re du Brie, ce fromage a maintenant une place de choix dans les familles. "
				+"Les coulommiers fermiers se font malheureusement rares, mais nous vous le proposons. Fromage au lait cru de vache, "
				+"il est recouvert d’une fine croûte duvet�e de blanc qui renferme une pâte jaune claire avec un cœur blanc. "
				+"Le Coulommiers vous offrira un moelleux et une onctuosit� accompagn�s d’une saveur d’amande douce et d’une odeur de champignons frais, "
				+"de cr�me et de lait chaud.", 
				TypeVente.ENTIER_OU_MOITIE, new String[]{""}, new float[]{5.5F, 10.99F}), 
				new SaisieFromage("Cur� Nantais", 
				"Connu comme le \"fromage nantais\", il a un parfum captivant et immanquable. On peut le d�guster toute l'ann�e. "
				+"Il pr�sente un goût de terroir prononc�. Il est propos� froid ou chaud, avec des fruits ou du poireau. C'est un fromage fort, sa pâte est "
				+"souple, cr�meuse et perc�e de quelques petits trous, elle r�v�le une saveur de lard fum� et un final �pic�. "
				+"La croûte est rugueuse, odorante et humide", 
				TypeVente.A_L_UNITE, new String[]{""}, new float[]{7.8F}),
				new SaisieFromage("Emmental de Savoie IGP", 
				"Fabriqu� en Savoie, au lait cru de vache, il est un fromage à pâte press�e cuite. Ayant une croûte jaune à brun pâle sign�e de la mention "
				+"Savoie sur le talon, et proposant une pâte jaune clair au toucher fin et souple, l’Emmental français offre une diversit� de goût "
				+"aux arômes subtils, doux et fruit�s. Seul ou accompagn� de pain, il s'accorde bien avec un verre de vin. "
				+"Traditionnellement utilis� pour la fondue savoyarde, on l'utilise �galement dans de nombreuses pr�parations culinaires, en tranches, "
				+"en cubes, râp� ...", 
				TypeVente.A_LA_COUPE_AU_POIDS, new String[]{"250 g", "500 g", "1 Kg"}, new float[]{6F, 12F, 24F}), 
				new SaisieFromage("Emmentaler Suisse", 
				"Indispensable sur un plateau de fromage, l'Emmental Suisse r�v�le toutes ses subtilit�s en cuisine, en plats chauds ou froids. "
				+"Savoureux sans être envahissant, il est id�al pour les sandwichs et salades, et même au petit-d�jeuner. Les Suisses en raffolent. "  
				+"Fromage au lait cru de vache proposant une pâte ferme et tendre de couleur cr�me à jaune clair, et une croûte lisse de couleur dor�e "
				+"ou brun clair recouverte d’une inscription rouge «Switzerland Emmentaler». "
				+"L’ Emmental Suisse vous offrira un goût doux, tendre aux d�licates nuances de noisette et de noix mais gagnera en puissance en s’affinant.", 
				TypeVente.A_LA_COUPE_AU_POIDS, new String[]{"250 g", "500 g", "1 Kg"}, new float[]{6.5F, 13F, 26F}), 
				new SaisieFromage("Epoisses", 
				"Au lait cru de vache, ce fromage dispose d’une croûte brillante orang�e renfermant une pâte souple beige clair. "
				+"En bouche, l’ Époisses vous offrira une onctuosit� et un goût relev� avec des notes de fruits secs. "
				+"D'un caract�re puissant, ce fromage particuli�rement goûteux est fabriqu� depuis des si�cles de tradition par les moines et "
				+"les fermi�re de la r�gion d’Époisses. Un d�lice sur un plateau, certains le place au four à même dans sa boîte.", 
				TypeVente.A_L_UNITE, new String[]{""}, new float[]{12.6F}), 
				new SaisieFromage("Fondue Savoyarde", 
				"Id�al pour un repas convivial avec vos amis ou en famille. C'est un m�lange de parfum, d'onctuosit�, et de raffinement pour "
				+"cette fondue savoyarde. Allez y piquez vos morceaux de pain dans le caquelon au centre de la table. "
				+"La fondue savoyarde est un plat r�gional de la gastronomie française à base de fromage fondu et de pain, traditionnel des pays de Savoie. "  
				+"Ce plat populaire, vous envoûtera de part ses multiples arômes.", 
				TypeVente.POUR_X_PERSONNES, new String[]{"3","5", "10"}, new float[]{22.5F, 33.75F, 67.5F}), 
				new SaisieFromage("Fourme d'Ambert", 
				"La Fourme d'Ambert est un fromage au lait cru de vache à pâte persill�e, elle vous offrira en bouche une saveur d�licate et une texture fondante. "
				+"Celle-ci pr�sentera une pâte de couleur blanche à ivoire parsem�e de moisissures bleu-vert, et une croûte fine naturelle fleurie "
				+"qui peut pr�senter des reflets de la même teinte. Reconnu pour être le fromage bleu le plus doux, ce fromage ravira vos papilles "
				+"et celles de vos convives.", 
				TypeVente.A_LA_COUPE_AU_POIDS, new String[]{"250 g", "500 g", "1 Kg"}, new float[]{6.2F, 12.4F, 24.8F}), 
				new SaisieFromage("Galet de Loire", 
				"C’est un fromage au lait pasteuris� de vache à patte molle à croûte fleurie blanche à jaunâtre, et l�g�rement stri�e et tachet�e. "
				+"Sans odeur et d’un goût de noisette, le galet de Loire nous invite à ne pas se fier sa petite apparence, "
				+"en bouche il reste d�licat et onctueux au cœur avec sa pâte est cr�meuse et d�voile un goût typ� ainsi qu’une importante diversit� d’arômes, "
				+"tantôt champignon, tantôt �table.", 
				TypeVente.A_L_UNITE, new String[]{""}, new float[]{5.5F}), 
				new SaisieFromage("Gaperon", 
				"Issu d'Auvergne, le Gaperon est un petit fromage dont la saveur varie suivant qu'on le mange frais, jeune, affin� ou tr�s affin�. "
				+"Il d�gage peu d'odeur mais sa saveur reste \"piquante\" à d�guster toute l'ann�e. Au lait cru de vache, celui-ci est conçu avec "
				+"ce qu’il reste du beurre apr�s sa fabrication, c’est -à-dire le «babeurre». Le Gaperon dispose d’une pâte de couleur ivoire à "
				+"jaune pâle à l’int�rieur et d’une croûte lisse et blanche à l’ext�rieur. Ce petit fromage parsem� de poivre moulu et de morceaux d’ail "
				+"vous offrira une saveur aromatis�e et intense.", 
				TypeVente.ENTIER_OU_MOITIE, new String[]{""}, new float[]{6.5F, 11.8F}), 
				new SaisieFromage("Gorgonzola", 
				"D’une pâte de couleur blanche parsem�e de veines vertes-bleut�es, le Gorgonzola propose une texture ferme mais moelleuse à la fois "
				+"aux saveurs particuli�res et caract�ristiques l�g�rement piquantes. Souvent utilis� dans de nombreuses recettes pour son fondant, "
				+"le Gorgonzola peut �galement être appr�ci� sur un plateau de fromages à d�guster en fin de repas et pourquoi pas l’associer à une poire. "
				+"Il reste et restera un fromage incontournable de la gastronomie italienne.", 
				TypeVente.A_LA_COUPE_AU_POIDS, new String[]{"250 g", "500 g", "1 Kg"}, new float[]{5.2F, 10.4F, 20.8F}), 
				new SaisieFromage("Gouda", 
				"Sp�cialit� fermi�re hollandaise, ce Gouda vieux dispose d'un affinage exceptionnel qui le rend dur et cassant avec un �tonnant goût de "
				+"noisette tr�s prononc�. Fromage au lait de vache pasteuris�, il offre une croûte lisse et dure de cire jaune renfermant une pâte ferme "
				+"et friable de couleur cr�me à jaune. Le Vieux Gouda vous apportera une saveur prononc�e et piquante avec des arômes de lait, de cr�me, "
				+"d’amande à d�guster à tous moments de la journ�e.", 
				TypeVente.A_LA_COUPE_AU_POIDS, new String[]{"250 g", "500 g", "1 Kg"}, new float[]{7.5F, 15F, 30F}), 
				new SaisieFromage("Gouda aux truffes", 
				"Fromage hollandais au lait de vache thermis�, il offre une croûte lisse et dure de cire noire renfermant une pâte jeune et souple agr�ablement "
				+"parfum� de couleur cr�me à jaune. La pâte est parsem�e de nombreux �clats de truffes. Ce Gouda vous apportera une saveur douce et subtile "
				+"il sera difficile de s'en passer. Tr�s goûteux aux arômes intenses de la truffe noire, il sera irr�sistible et pourra se manger à "
				+"l'ap�ritif ou même être ajout� dans des plats cuisin�s. Il vous fera d�couvrir des associations �tonnantes.",
				TypeVente.A_LA_COUPE_AU_POIDS, new String[]{"250 g", "500 g", "1 Kg"}, new float[]{8.75F, 17.5F, 35F}), 
				new SaisieFromage("Gruy�re Suisse", 
				"C’est un fromage au lait cru de vache au goût fin, subtil et aromatique. Le Gruy�re Suisse renferme une pâte souple et ferme de couleur "
				+"ivoire recouverte d’une croûte grain�e brunâtre. D’une saveur inimitable qui s’affirmera en fonction de son affinage, il sera tr�s appr�ci� "
				+"sur votre plateau fromage. Le Gruy�re Suisse traditionnel est fabriqu� dans les cantons de Fribourg, c'est l'authenticit� du travail "
				+"du fromager qui va apport� au fromage toute la richesse de son goût incomparable.", 
				TypeVente.A_LA_COUPE_AU_POIDS, new String[]{"250 g", "500 g", "1 Kg"}, new float[]{10.7F, 21.4F, 42.8F}), 
				new SaisieFromage("Kaltbach Suisse", 
				"En ap�ro, en fin de repas ou pour agr�menter vos plats, le Kaltbach r�galera petits et grands avec son goût tr�s fruit� et son fondant "
				+"incomparable. Enrichi en cr�me et affin� dans la grotte de Kaltbach en Suisse, ce fromage dispose d'une texture moelleuse et ferme à la "
				+"fois et d'une odeur franche mais tr�s agr�able.", 
				TypeVente.A_LA_COUPE_AU_POIDS, new String[]{"250 g", "500 g", "1 Kg"}, new float[]{8.7F, 17.4F, 34.8F}), 
				new SaisieFromage("Laguiole", 
				"Ce fromage au lait cru de vache dispose d’une pâte ferme et lisse de couleur jaune paille, recouvert d’une croûte naturelle et �paisse "
				+"de couleur orang� claire ou brun ambr�. Reconnaissable au Taureau imprim� sur la croûte suivi du mot \"Laguiole\", "
				+"il vous offrira un goût remarquable et unique des saveurs florales de son terroir à consommer à tout moment, de l’ap�ritif à la fin du repas.", 
				TypeVente.A_LA_COUPE_AU_POIDS, new String[]{"250 g", "500 g", "1 Kg"}, new float[]{6.5F, 13F, 26F}), 
				new SaisieFromage("Langres Fermier", 
				"Fromage au lait cru de vache, le Langres vous propose une pâte souple, fondante et cr�meuse de couleur blanche, recouverte d'une croûte "
				+"fine et brillante de couleur jaune clair à brun en s'affinant. En forme d'un cylindre dont le sommet se creuse formant une cuvette, "
				+"la \"Fontaine\", celle-ci permettant d'y verser du Champagne ou du Marc de Champagne : façon traditionnelle d’accommoder ce fromage, "
				+"vous d�couvrirez en le d�gustant des saveurs relev�es avec des notes d'alcool accompagn�es d'une forte odeur p�n�trante.", 
				TypeVente.A_L_UNITE, new String[]{""}, new float[]{7.9F}), 
				new SaisieFromage("Livarot", 
				"Appel� aussi \"le Colonel\" dû aux cinq bandes en roseau qui entourent sa croûte, appel�es \"laiches\", le Livarot au lait cru de vache "
				+"dispose d'une pâte souple et l�g�rement sal�e à l'int�rieur et d'une croûte orang�e et humide à l'ext�rieur. D'une odeur forte et d'un goût "
				+"relev� aux arômes floraux et aux saveurs de charcuteries fum�es, il apportera une note d'originalit� sur votre plateau mais pourra "
				+"�galement constituer un excellent en-cas.", 
				TypeVente.ENTIER_OU_MOITIE, new String[]{""}, new float[]{7.7F, 15.4F}), 
				new SaisieFromage("Maroilles Fermier", 
				"Fromage de caract�re le plus connus du nord de la France, le Maroilles vous proposera une odeur forte et une saveur cors�e. " 
				+"C'est un fromage au lait cru de vache qui dispose d'une croûte rouge orang�e lisse et brillante renfermant une pâte souple et onctueuse. "
				+"A d�couvrir sur votre plateau de fromages.", 
				TypeVente.ENTIER_OU_MOITIE, new String[]{""}, new float[]{10.69F, 20.99F}), 
				new SaisieFromage("Mimolette Tendre", 
				"La Mimolette ou appel�e �galement \"boule de Lille\" est un fromage au lait pasteuris�  de vache. Cette boule de couleur orang� int�rieur "
				+"comme à l'ext�rieur dispose d'une pâte tendre. La Mimolette jeune  vous offrira en bouche des saveurs d�licates de noisettes relev�es "
				+"de pointes de sel.", 
				TypeVente.A_LA_COUPE_AU_POIDS, new String[]{"250 g", "500 g", "1 Kg"}, new float[]{4.49F, 8.99F, 17.99F}), 
				new SaisieFromage("Mimolette Vieille", 
				"La Mimolette vieille est facilement identifiable par sa forme ronde. Sa croûte est grisâtre, rempli de trous et de fissures. "
				+"Sa pâte, est orange fonc�e, s�che et cassante. Sa saveur est fruit�e, l�g�rement piquante et se termine par une pointe d'amertume. "
				+"Un fromage de caract�re aux arômes sal�s et sucr�s accompagn�s d'une odeur fruit�e et de cave.", 
				TypeVente.A_LA_COUPE_AU_POIDS, new String[]{"200 g", "400 g", "1 Kg"}, new float[]{6.6F, 13.2F, 29.69F}), 
				new SaisieFromage("Mont d'Or boite", 
				"Les amateurs de Mont d'or l'attendent avec impatience : le Vacherin du Haut Doubs, pr�sent� dans sa boîte �pic�a où il donne l'air d'être "
				+"un peu à l'�troit avec sa croute l�g�rement pliss�e, est la star de la table où il peut être d�gust� à la petite cuill�re. "
				+"Le Mont d'Or est un fromage au lait cru de vache, à pâte molle, non cuite, l�g�rement press�e, de consistance cr�meuse, l�g�rement sal�e. "
				+"Il se reconnaît à sa croûte lav�e l�g�rement \"refleurie\", de couleur jaune à brun clair. "
				+"Il est cercl� d'une sangle d'�pic�a et ins�r� dans une boîte en bois d'�pic�a.", 
				TypeVente.A_L_UNITE, new String[]{""}, new float[]{11.8F}), 
				new SaisieFromage("Mont d'Or", 
				"Les amateurs de Mont d'or l'attendent avec impatience : le Vacherin du Haut Doubs, pr�sent� dans sa boîte �pic�a où il donne l'air d'être "
				+"un peu à l'�troit avec sa croute l�g�rement pliss�e, est la star de la table où il peut être d�gust� à la petite cuill�re. "
				+"Le Mont d'Or est un fromage au lait cru de vache, à pâte molle, non cuite, l�g�rement press�e, de consistance cr�meuse, l�g�rement sal�e. "
				+"Il se reconnaît à sa croûte lav�e l�g�rement \"refleurie\", de couleur jaune à brun clair. "
				+"Il est cercl� d'une sangle d'�pic�a et ins�r� dans une boîte en bois d'�pic�a.", 
				TypeVente.A_LA_COUPE_AU_POIDS, new String[]{"250 g", "500 g", "1 Kg"}, new float[]{6.75F, 13.5F, 27F}), 
				new SaisieFromage("Montbriac", 
				"Au lait de vache pasteuris�, ce fromage renferme une pâte cr�meuse de couleur ivoire l�g�rement persill�e recouverte d’une croûte tendre "
				+"de couleur grise. Le Montbriac connu aussi comme Rochebaron, vous offrira un parfum d�licat et une saveur fruit�e et sal�e avec de l�gers "
				+"arômes du terroir. Ce fromage est le r�sultat d'une exp�rience heureuse qui combine les moisissures bleue avec un fromage doux et cr�meux"
				+" typiquement français. D�gustez-le en fin de repas avec une baguette bien croustillante.", 
				TypeVente.ENTIER_OU_MOITIE, new String[]{""}, new float[]{6.8F, 13.6F}), 
				new SaisieFromage("Morbier", 
				"Marqu� en son centre d'une c�l�bre raie noire, le Morbier au lait cru de vache dispose d'une pâte souple et onctueuse color�e entre l'ivoire "
				+"et le jaune pâle avec de l�g�res ouvertures et de rares petits trous. Sa croûte lisse et fine de couleur ros� clair à beige orang� "
				+"renferme bien d'autres surprises et qualit�s. Le Morbier d�voilera un parfum franc et persistant ainsi qu'une odeur franche et fruit�, "
				+"et un l�ger goût de cr�me et de fruit comme la noisette.", 
				TypeVente.A_LA_COUPE_AU_POIDS, new String[]{"250 g", "500 g", "1 Kg"}, new float[]{5F, 10F, 19.99F}), 
				new SaisieFromage("Munster", 
				"D�licieux et d�licat fromage au lait cru de vache, il propose une pâte moelleuse aux saveurs d�licates et une croûte lisse de couleur dor�e "
				+"à orang�e. Le Munster au goût relev� et fruit� dispose d’une odeur forte et p�n�trante. En plateau ou en cuisine, il est souvent "
				+"consomm� avec du cumin ou du carvi.", 
				TypeVente.ENTIER_OU_MOITIE, new String[]{""}, new float[]{6.6F, 13.1F}), 
				new SaisieFromage("Munster au Cumin", 
				"D�licieux et d�licat fromage au lait cru de vache, il propose une pâte moelleuse aux saveurs d�licates et une croûte lisse de couleur dor�e "
				+"à orang�e parsem�e de cumin. Le Munster au goût relev� et fruit� dispose d’une odeur forte et p�n�trante.", 
				TypeVente.ENTIER_OU_MOITIE, new String[]{""}, new float[]{9.4F, 18.8F}), 
				new SaisieFromage("Neufchâtel Cœur", 
				"Le Neufchâtel convient à tous les palais, sous sa croûte blanche fleurie, se cache une pâte lisse et moelleuse (on la dit \"mouss�e\") "
				+"de couleur blanche à ivoire. Au lait cru de vache, ce petit fromage en forme de cœur vous apportera une saveur d�licate mais soutenue, "
				+"sal�e et acidul�e accompagn�e d'une l�g�re odeur de lait. Le Neufchâtel vous offrira un goût de champignons et de lait qui "
				+"s'accentuera en s'affinant.", 
				TypeVente.A_L_UNITE, new String[]{""}, new float[]{4.99F}), 
				new SaisieFromage("Olivet", 
				"C’est un fromage au lait de vache pasteuris� recouvert de cendre, il dispose d’une croûte mince de couleur grise d�gageant une l�g�re "
				+"odeur de terre, renfermant une pâte souple de couleur blanche à ivoire. L’Olivet Cendr� vous offrira des saveurs fruit�es relev�es "
				+"d’une pointe de sel. Son processus d’affinage lui permettra de d�velopper un goût d'herbe fraîche plus nuanc� que le camembert.", 
				TypeVente.A_L_UNITE, new String[]{""}, new float[]{4.99F}), 
				new SaisieFromage("Parmesan Reggiano", 
				"Le parmesan, est un fromage italien traditionnel, qui jouit d'une renomm�e mondiale, il a une saveur lactique, fruit�e, sal�e, parfois "
				+"piquante et rentre dans la composition de beaucoup de recettes. Fromage au lait cru de vache, le Parmesan est un fromage à pâte press�e cuite. "
				+"D’une croûte brune huil�e, aux saveurs tr�s fruit�es et d’un piquant unique, il dispose d’une qualit� toujours excellente.", 
				TypeVente.A_LA_COUPE_AU_POIDS, new String[]{"250 g", "500 g", "1 Kg"}, new float[]{8.7F, 17.4F, 34.8F}), 
				new SaisieFromage("Pont l'Evêque", 
				"Au lait cru de vache, ce pav� dispose d’une croûte lisse de couleur beige clair à l’ext�rieur et d’une pâte tendre de couleur jaune pâle "
				+"à l’int�rieur. Le Pont l’Évêque au goût subtil et fruit� avec des notes de noisettes sera un d�lice en fin de repas à d�guster sans mod�ration.", 
				TypeVente.ENTIER_OU_MOITIE, new String[]{""}, new float[]{5.3F, 10.5F}), 
				new SaisieFromage("Raclette de Savoie", 
				"La Raclette est aussi savoureuse à manger à la main comme fondu, elle est de forme ronde, sa croûte lisse de couleur orange fonc� à brun, "
				+"pâte souple caract�ris�e par une couleur jaune ivoire, goût franc et tr�s parfum�e. A pleine maturit� elle devient plus cors�e.", 
				TypeVente.A_LA_COUPE_AU_POIDS, new String[]{"250 g", "500 g", "1 Kg", "1/2 Tomme 2,6 Kg (environ)"}, new float[]{4.52F, 9.04F, 18.08F, 47.01F}), 
				new SaisieFromage("Reblochon", 
				"Au lait cru de vache ce fromage fermier pr�sente une croûte lisse jaune orang� recouverte par une l�g�re mousse blanche, renfermant "
				+"une pâte onctueuse de couleur ivoire. Le Reblochon vous offrira une saveur subtile relev�e d’une note de noisette qui reste en bouche "
				+"apr�s l'avoir d�gust�. Principalement utilis� pour la traditionnelle Tartiflette, il sera un d�lice sur vos plateaux de fromages.", 
				TypeVente.ENTIER_OU_MOITIE, new String[]{""}, new float[]{8.99F, 17.6F}), 
				new SaisieFromage("Rosettes de tête de moine", 
				"Pourquoi avoir absolument besoin du friseur à fromage, pour être en mesure d'appr�cier la tête de moine ? La saveur de la rosette est garantie "
				+"grâce ce concept. Nous proposons ce service pour assurer des rosettes a�r�es et solides. Elles sont pr�par�es par nos soins le jour de "
				+"l'exp�dition. Elles sont conditionn�es dans une boite plastique. La quantit� par boite peut varier de 12 à 14 rosettes. " 
				+"La tête de moine est un fromage Suisse au lait cru de vache, il propose une croûte ferme brune renfermant une pâte de couleur ivoire à "
				+"jaune clair, l�g�rement dure et fondante en bouche. La Tête de Moine vous apportera des saveurs aromatiques qui s’affirmeront en s’affinant. ", 
				TypeVente.A_L_UNITE, new String[]{""}, new float[]{8.9F}), 
				new SaisieFromage("Saint F�licien", 
				"Ce fromage au lait cru de vache vous proposera un goût cr�meux l�g�rement sal� et noiset�. Le Saint-F�licien offrira une pâte souple "
				+"recouverte d’une croûte naturelle de couleur blanche à jaune clair. Il sera un fromage fermier qui comblera les amateurs de fromages doux. " 
				+"Le Saint-F�licien s�duit de plus en plus de consommateurs par son onctuosit�, son cr�meux et son bon goût.", 
				TypeVente.A_L_UNITE, new String[]{""}, new float[]{6.1F}), 
				new SaisieFromage("Saint Marcellin Fermier", 
				"Fromage au lait thermis� de vache, il propose une pâte molle et cr�meuse de couleur ivoire recouverte d'une croûte fine et fleurie de "
				+"couleur blanche. D’un goût l�g�rement acide aux arômes de noisette accompagn� d’un parfum bois�, c'est un petit fromage produit dans la Drôme, "
				+"il est à consommer peu affin� accompagn� d'une salade mais il d�veloppera toute sa typicit� quand il sera coulant sous une croûte bleue.", 
				TypeVente.A_L_UNITE, new String[]{""}, new float[]{2.47F}), 
				new SaisieFromage("Saint Nectaire Fermier", 
				"Ce fromage au lait cru de vache à pâte press�e non cuite, propose une belle pâte de texture souple de couleur cr�me. Il est savoureux et "
				+"doit être mang� à cœur et non pas coulant. Offrant toutes les essences des prairies de son terroir et un d�licat goût noisette "
				+"le Saint Nectaire est un fleuron gastronomique auvergnat. Au parfum inimitable de terroir qui laisse �chapper quelques odeurs de noisette, "
				+"chaud ou froid, notre fromage s'adapte à vos envies. Ce fromage d'Auvergne pourra se d�guster tout simplement sur une g�n�reuse "
				+"tranche de pain de campagne.", 
				TypeVente.A_LA_COUPE_AU_POIDS, new String[]{"250 g", "500 g", "1 Kg", "fromage entier de 1,5 Kg (environ)"}, new float[]{7.45F, 14.9F, 29.8F, 40.23F}), 
				new SaisieFromage("Salers", 
				"La personnalit� du Salers, l’extraordinaire �tendue de sa palette de goûts, permettent des mariages gourmands allant du classique au plus insolite. "
				+"Fromage fermier au lait cru de vache, il dispose d’une pâte jaune et bien li�e recouverte d’une croûte dor�e, �paisse et fleurie de tâches "
				+"rouges et orang�es. Le Salers vous offre un goût cors�, �pic�, lactique et fruit� à d�guster tout au long de l’ann�e. "
				+"Vous l’identifierez par une plaque rouge et une empreinte grav�e en creux «Salers-Salers» sur l’une des faces de ce fromage.", 
				TypeVente.A_LA_COUPE_AU_POIDS, new String[]{"250 g", "500 g", "1 Kg"}, new float[]{7.75F, 15.5F, 31F}), 
				new SaisieFromage("Tête de Moine", 
				"Fromage Suisse au lait cru de vache, il propose une croûte ferme brune renfermant une pâte de couleur ivoire à jaune clair, l�g�rement dure "
				+"et fondante en bouche. La Tête de Moine vous apportera des saveurs aromatiques qui s’affirmeront en s’affinant. G�n�ralement, pour d�guster "
				+"la Tête de Moine AOP, il ne faut pas couper le fromage mais le racler en rosettes tr�s fines, grâce au friseur à fromage. "
				+"En effet, le raclage modifie la structure de la pâte, la plus grande surface mise en contact avec l'air met particuli�rement en valeur "
				+"l'arôme typique  et permet de mieux la savourer.", 
				TypeVente.A_LA_COUPE_AU_POIDS, new String[]{"200 g", "400 g", "Tête de Moine enti�re 850 g (environ)"}, new float[]{7.56F, 15.12F, 28.92F}), 
				new SaisieFromage("Tomme de Savoie", 
				"Doyenne des fromages de Savoie, la Tomme de Savoie est une fabrication ancestrale issue d'un environnement naturel exceptionnel. "
				+"Les saveurs de ce fromage reposaient donc sur les parfums du lait, li�s notamment aux herbages sp�cifiques dont se nourrissaient "
				+"les troupeaux. D’une croûte grise fleurie de moisissures blanches renfermant une pâte tendre de couleur blanche à jaune pâle pr�sentant "
				+"de l�g�res ouvertures. Ce fromage au lait cru de vache offre un goût de noisette l�g�rement sal� accompagn� d’un parfum de cave, "
				+"la tomme de Savoie reste un fromage typique à partager toute l’ann�e.", 
				TypeVente.A_LA_COUPE_AU_POIDS, new String[]{"250 g", "500 g", "1 Kg", "tomme enti�re de 1,6 Kg (environ)"}, new float[]{5.99F, 11.99F, 23.99F, 30.7F}), 
				new SaisieFromage("Tomme des Pyr�n�es", 
				"Fromage au lait cru de vache, il pr�sente une croûte stri�e, orang�e et dor�e renfermant une pâte souple et onctueuse de couleur jaune "
				+"a�r�e par de petites ouvertures. La Tomme de Vache offrira en bouche des saveurs fruit�es l�g�rement sucr�es et acidul�e aux notes de noisettes, "
				+"le tout s’accompagnant d’une l�g�re odeur de cave. La tomme des Pyr�n�es \"Bethmale\" offre une saveur forte et fruit�e qui saura vous "
				+"faire voyager au cœur des montagnes d’Ari�ge.", 
				TypeVente.A_LA_COUPE_AU_POIDS, new String[]{"250 g", "500 g", "1 Kg"}, new float[]{7.2F, 14.4F, 28.8F}), 
				new SaisieFromage("Trou du Cru", 
				"Petit fromage au lait pasteuris� de vache, il se pr�sente sous la forme d’un petit cylindre recouvert d’une croûte lisse et collante de couleur "
				+"orang� à rouge, renfermant une pâte onctueuse et fondante de couleur jaune clair. D’un goût puissant et d�licat à la fois il vous offrira "
				+"des saveurs parfum�es, sal�es et sucr�es relev� d’arômes d’alcool, accompagn� d’une l�g�re odeur de paille. Ne vous fiez pas à sa petite taille, "
				+"affin� avec du marc de Bourgogne, son goût puissant avec une arri�re bouche florale enchantera les amateurs de sensations fortes.", 
				TypeVente.A_L_UNITE, new String[]{""}, new float[]{3.99F}), 
				new SaisieFromage("Vieux Lille", 
				"Au lait cru de vache, le Vieux Lille se pr�sente sous la forme d’un pav� de couleur grisâtre. Sa pâte �tant �labor�e à base de Maroilles "
				+"mac�r� dans une saumure, celle-ci est donc souple et offre une odeur puissante accompagn� d’un goût prononc�, sal� et l�g�rement piquant.", 
				TypeVente.A_L_UNITE, new String[]{""}, new float[]{6.99F})
		};
		for (SaisieFromage s : fromages) {
			fromagesAuLaitDeVache.add(s.builderFromage());
		}
		for (Fromage f : fromagesAuLaitDeVache)
			f.updateTypeFromage(TypeLait.VACHE);
		return fromagesAuLaitDeVache;	
	}
}