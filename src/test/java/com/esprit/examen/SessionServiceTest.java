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
import java.util.Optional;

import org.junit.Test;
import org.junit.Assert;
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
	
	private static final Logger l = LogManager.getLogger(SessionServiceTest.class);
	
	@Test
	public void addSessionTest() {
		l.info("Commencer addSession test");
        Session newSession = new Session(2l,"description");
        Long id = sessionService.addSession(newSession);
        l.info("test ajout session id : " + id);
        Assert.assertNotEquals(Optional.ofNullable(id), 0);
	}
	
	@Test
    public void UpdateSessionTest() {
		l.info("Commencer updateSession test");
		Session newSession = new Session(2l,"description");
        Long id = sessionService.addSession(newSession);
        newSession.setDescription("new description");
        Long newId = sessionService.modifierSession(newSession);
        Assert.assertNotEquals(Optional.ofNullable(newId), 0);
        Assert.assertEquals(id,newId);
    }
	
	@Test
    public void DeleteSessionTest() {
		l.info("Commencer deleteSession test");
		Session newSession = new Session(2l,"description");
        Long  id = sessionService.addSession(newSession);
        sessionService.supprimerSession(id);
        Optional<Session> op = sessionService.getById(id);
        if (op.isPresent())
            l.error("test echec du suppression id = "+ id);
        Assert.assertFalse(op.isPresent());

    }
	
}
