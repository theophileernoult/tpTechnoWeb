package isep.lab1.bean;

public class Person {

	private String nom;
	private String prenom;
	private String date;
	private String sexe;

	public String getNom() {
		return this.nom;
	}
	
	public String getPrenom() {
		return this.prenom;
	}
	
	public String getDate() {
		return this.date;
	}
	
	public String getSexe() {
		return this.sexe;
	}
	
	public void setNom( String nom ) {
		this.nom = nom;
	}
	
	public void setPrenom( String prenom ) {
		this.prenom = prenom;
	}
	
	public void setDate( String date ) {
		this.date = date;
	}
	
	public void setSexe( String sexe ) {
		this.sexe = sexe;
	}
	
}
