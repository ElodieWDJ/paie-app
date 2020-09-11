package dev.paie.controller;

import dev.paie.entite.ProfilRemuneration;
import dev.paie.entite.RemunerationEmploye;

public class CreerEmployeResponseDto extends CreerEmployeRequestDto {

	public CreerEmployeResponseDto(RemunerationEmploye remunerationEmploye) {
		this.setId(remunerationEmploye.getId());
		this.setMatricule(remunerationEmploye.getMatricule());
		this.setEntreprise(remunerationEmploye.getEntreprise());
		this.setProfilRemuneration(remunerationEmploye.getProfilRemuneration());
		this.setGrade(remunerationEmploye.getGrade());
	}

	private void setProfilRemuneration(ProfilRemuneration profilRemuneration) {
		// TODO Auto-generated method stub

	}
}
