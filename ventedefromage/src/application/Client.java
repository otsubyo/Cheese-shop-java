package application;

public class Client {
	private String nom;
	private String prenom;
	private String adresse;
	private String adresse2;
	private String c_postal;
	private String ville;
	private String telephone;
	private String mail;
	
	public Client(String nom, String prenom, String adresse, String adresse2, String c_postal, String ville, String telephone, String mail){
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.adresse2 = adresse2;
		this.c_postal = c_postal;
		this.ville = ville;
		this.telephone = telephone;
		this.mail = mail;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public String getAdresse2() {
		return adresse2;
	}

	public String getC_postal() {
		return c_postal;
	}

	public String getVille() {
		return ville;
	}

	public String getTelephone() {
		return telephone;
	}

	public String getMail() {
		return mail;
	}
	
	
}
