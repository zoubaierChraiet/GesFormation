package com.esprit.examen;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import com.esprit.examen.entities.*;
import com.esprit.examen.services.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Assert;



@SpringBootTest
@RunWith(SpringRunner.class)
public class FormateurServiceTest {
	
private static final Logger l = LogManager.getLogger(FormateurServiceTest.class);
	
	
	@Autowired
	private IFormateurService formateurService;

	  @Autowired
	    ISessionService sessionService ;

	    @Autowired
	    ICoursService courService ;
	
	
	@Test
	public void addFormateur() {
		Formateur formateur = new Formateur("salma", "mezn", Poste.Docteur, Contrat.CIVP,
				"meznsalma@gmail.com", "123");	

		Long id = formateurService.addFormateur(formateur);
		
		 l.info("test  ajout  formateur  id : "+id);


	        Assert.assertFalse(id == 0);
	        
	        Formateur newF = formateurService.get(id).get();

	        Assert.assertTrue(newF.getPoste().equals(Poste.Docteur));
	        Assert.assertTrue(newF.getContrat().equals(Contrat.CIVP));



	        formateurService.supprimerFormateur(id);
	        
	          
	        

	}

	 @Test
	    public void testUpdateFormateur() {
	        Formateur f = new Formateur("mimi","bobo", Poste.Ingénieur, Contrat.EXPERT,"mbmb@gmail.com","ssssssss");
	        Long  id = formateurService.addFormateur(f);

	        f.setId(id);
	        f.setNom("mpmpmp");
	        f.setPassword("oooooooo");

	        Long newId = formateurService.modifierFormateur(f);

	        Assert.assertFalse(newId == 0);
	        Assert.assertEquals(id,newId);
	        
	        l.info("test update formateur  pour id = "+ newId);

	        
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
		
		Formateur f = new Formateur("mimi","bibi", Poste.Ingénieur, Contrat.EXPERT,"mimbii@gmail.com","aaaaaa");
        Long  id = formateurService.addFormateur(f);

        formateurService.supprimerFormateur(id);

        Optional<Formateur> op = formateurService.get(id);

        if (op.isPresent())
            l.error("test echec du suppression id = "+ id);

        Assert.assertFalse(op.isPresent());

		
		
		
		/*Formateur formateur = new Formateur("mariem", "boussaada", Poste.Ingénieur, Contrat.EXPERT,
				"boussadamariemi@gmail.com", "123");	
		Long  id = formateurService.addFormateur(formateur);
		formateurService.supprimerFormateur(id);*/

		 

	}
	
	
	@Test
    public void testnombreCoursParFormateur() {
        Formateur f = new Formateur("chiraz","demni", Poste.Ingénieur, Contrat.EXPERT,"chiraz@gmail.com","ssssssss");
        Long  idf = formateurService.addFormateur(f);

        Cours c = new Cours("description" , TypeCours.Informatique,"DevoOps");
        Long  idc = courService.addCours(c);

        Session s =new Session(5L,"session info");
        Long ids=sessionService.addSession(s);

        int n = formateurService.nombreCoursParFormateur(idf);
        sessionService.affecterFormateurASession(idf,ids);
        courService.affecterCoursASession(idc,ids);

        l.warn("test nombre initial cours = "+n +" nouveau nombre = "+formateurService.nombreCoursParFormateur(idf) );

       



       
        formateurService.supprimerFormateur(idf);


    }



}



