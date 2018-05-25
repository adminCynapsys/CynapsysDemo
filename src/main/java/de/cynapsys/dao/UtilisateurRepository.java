package de.cynapsys.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import de.cynapsys.entities.Utilisateur;
@Repository
@EnableJpaRepositories
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
	List<Utilisateur> findByEmailAndMdp (String email, String mdp);

}
