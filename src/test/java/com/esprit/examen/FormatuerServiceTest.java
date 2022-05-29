package com.esprit.examen;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.esprit.examen.entities.Contrat;
import com.esprit.examen.entities.Formateur;
import com.esprit.examen.entities.Poste;
import com.esprit.examen.entities.TypeCours;
import com.esprit.examen.services.IFormateurService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)

public class FormatuerServiceTest {
	private static final Logger l = LogManager.getLogger(FormateurServiceTest.class);
	
	
	@Autowired
	private IFormateurService formateurService;

	@Test
	public void addFormateur() {
		Formateur formateur = new Formateur("salma", "mezn", Poste.Docteur, Contrat.CIVP,
				"meznsalma@gmail.com", "123");	

		Long id = formateurService.addFormateur(formateur);
		
		assertThat(id).isNotEqualTo(0);

	}

	@Test
	public void listFormateurs() {

		List<Formateur> formateurs = formateurService.listFormateurs();
		assertThat(formateurs).size().isNotNull();

	}

	@Test
	public void nbrFormateur() {
		Long number = formateurService.nombreFormateursImpliquesDansUnCours(TypeCours.Scrum);

		assertEquals(0, number);

	}

	

	@Test
	public void deleteFormateur() {
		
		Formateur formateur = new Formateur("mariem", "boussaada", Poste.Ingénieur, Contrat.EXPERT,
				"boussadamariemi@gmail.com", "123");	
		Long  id = formateurService.addFormateur(formateur);
		formateurService.supprimerFormateur(id);

		 

	}

}
