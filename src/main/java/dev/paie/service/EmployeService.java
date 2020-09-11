package dev.paie.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import dev.paie.entite.Employe;
import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.exception.PaieException;
import dev.paie.repository.EmployeRepository;
import dev.paie.repository.EntrepriseRepository;
import dev.paie.repository.GradeRepository;
import dev.paie.repository.ProfilRemunerationRepository;

@Service
public class EmployeService {

	private EmployeRepository EmployeRepository;
	private EntrepriseRepository entrepriseService;
	private ProfilRemuneration profilRemunerationService;
	private GradeRepository gradeRepository;
	private EntrepriseRepository EntrepriseRepository;
	private ProfilRemunerationRepository profilRemunerationRepository;

	/**
	 * @param employeRepository
	 * @param entrepriseService
	 * @param profilRemunerationService
	 * @param gradeRepository
	 */

	public EmployeService(EmployeRepository employeRepository, EntrepriseRepository entrepriseRepository,
			ProfilRemunerationRepository profilRemunerationRepository, GradeRepository gradeRepository) {
		// EmployeService.remunerationEmployeRepository = employeRepository;
		this.EmployeRepository = employeRepository;
		this.EntrepriseRepository = entrepriseRepository;
		this.profilRemunerationRepository = profilRemunerationRepository;
		this.gradeRepository = gradeRepository;
	}

	@Transactional
	public Employe creerEmploye(Integer matricule, Integer entrepriseId, Integer profilId, Integer gradeId) {
		List<String> messagesErreurs = new ArrayList<>();

		Optional<Entreprise> opEntreprise = EntrepriseRepository.findById(entrepriseId);
		Optional<ProfilRemuneration> opProfilRem = profilRemunerationRepository.findById(profilId);
		Optional<Grade> opGrade = gradeRepository.findById(gradeId);

		if (!EmployeRepository.findByMatricule(matricule).isEmpty()) {
			messagesErreurs.add("La matricule est déjà asignée à une autre employé");
		}

		if (opEntreprise.isEmpty()) {
			messagesErreurs.add("L'id" + entrepriseId + " ne correspond à aucune Entreprise");
		}

		if (opProfilRem.isEmpty()) {
			messagesErreurs.add("L'id" + profilId + " ne correspond à aucun Profil de remuneration");
		}
		if (opGrade.isEmpty()) {
			messagesErreurs.add("L'id" + gradeId + " ne correspond à aucun Grade");
		}

		if (!messagesErreurs.isEmpty()) {
			throw new PaieException(messagesErreurs);
		}

		Employe emp = new Employe();
		emp.setMatricule(matricule);
		emp.setEntreprise(opEntreprise.get());
		emp.setProfilRemuneration(opProfilRem.get());
		emp.setGrade(opGrade.get());

		return EmployeRepository.save(emp);
	}

	public ProfilRemuneration getProfilRemunerationService() {
		return profilRemunerationService;
	}

	public void setProfilRemunerationService(ProfilRemuneration profilRemunerationService) {
		this.profilRemunerationService = profilRemunerationService;
	}

	public EntrepriseRepository getEntrepriseService() {
		return entrepriseService;
	}

	public void setEntrepriseService(EntrepriseRepository entrepriseService) {
		this.entrepriseService = entrepriseService;
	}

}
