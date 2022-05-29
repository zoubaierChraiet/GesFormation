package com.esprit.examen;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.esprit.examen.entities.Session;
import com.esprit.examen.services.ICoursService;
import com.esprit.examen.services.IFormateurService;
import com.esprit.examen.services.ISessionService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SessionServiceTest {
	
	@Autowired
	private ISessionService sessionService;
	@Autowired
    ICoursService coursService;
	@Autowired
    IFormateurService formateurService;
	
	@Test
	public void addSessionTest() {
//		l.info("*************** Start add cours test");
//        Cours cours = new Cours("cours devops", TypeCours.Informatique, "Devops");
//
//        Long id = coursService.addCours(cours);
//        l.info("test  ajout  cours  id : " + id);
        
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		Session newSession = new Session();
//		newSession.se
	}
	
}
