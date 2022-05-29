package com.esprit.examen.services;

import java.util.List;
import java.util.Optional;

import com.esprit.examen.entities.Formateur;
import com.esprit.examen.entities.TypeCours;

public interface IFormateurService {
	Long addFormateur(Formateur formateur);

	Long modifierFormateur(Formateur formateur);

	void supprimerFormateur(Long formateurId);
	
	Long nombreFormateursImpliquesDansUnCours(TypeCours typeCours);
		
	List<Formateur> listFormateurs();
	Optional<Formateur> get(Long id);
	int nombreCoursParFormateur(Long formateurId);
}
