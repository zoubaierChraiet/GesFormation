package com.esprit.examen.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.esprit.examen.entities.Formateur;
import com.esprit.examen.entities.Poste;
import com.esprit.examen.entities.TypeCours;


@Repository
public interface FormateurRepository extends JpaRepository<Formateur, Long>{

	
	@Query("select count(f) from Formateur f inner join f.sessions s "
			+ "inner join s.cours c  where c.typeCours=:typeCours")
	public Long nombreFormateursImpliquesDansUnCours(@Param("typeCours")TypeCours typeCours);
	
	
	




		@Query(value = "SELECT COUNT(*) FROM formateur " +
				"INNER JOIN session ON formateur_id = formateur.id  " +
				"INNER JOIN session_cours ON session_cours.sessions_id = session.id   " +
				"INNER JOIN cours ON session_cours.cours_id = cours.id   " +
				"where formateur.id=:id   "  , nativeQuery = true)
		public int nombreCoursParFormateur(@Param("id")Long id);

	

}
