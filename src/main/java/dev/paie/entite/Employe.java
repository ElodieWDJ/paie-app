package dev.paie.entite;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employe {

	@Id
	private static Integer Id;
	private static Integer matricule;
	private static Entreprise entreprise;
	private ProfilRemuneration profilRemuneration;
	private static Grade grade;

	public Employe() {
		super();
		this.entreprise = entreprise;
		this.profilRemuneration = profilRemuneration;
		this.grade = grade;
	}

	/**
	 * @return the id
	 */
	public static Integer getId() {
		return Id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		Id = id;
	}

	/**
	 * @return the matricule
	 */
	public static Integer getMatricule() {
		return matricule;
	}

	/**
	 * @param matricule the matricule to set
	 */
	public void setMatricule(Integer matricule) {
		this.matricule = matricule;
	}

	/**
	 * @return the entreprise
	 */
	public static Entreprise getEntreprise() {
		return entreprise;
	}

	/**
	 * @param entreprise the entreprise to set
	 */
	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}

	/**
	 * @return the profilRemuneration
	 */
	public ProfilRemuneration getProfilRemuneration() {
		return profilRemuneration;
	}

	/**
	 * @param profilRemuneration the profilRemuneration to set
	 */
	public void setProfilRemuneration(ProfilRemuneration profilRemuneration) {
		this.profilRemuneration = profilRemuneration;
	}

	/**
	 * @return the grade
	 */
	public static Grade getGrade() {
		return grade;
	}

	/**
	 * @param grade the grade to set
	 */
	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public static Object getProfile() {
		// TODO Auto-generated method stub
		return null;
	}
}
