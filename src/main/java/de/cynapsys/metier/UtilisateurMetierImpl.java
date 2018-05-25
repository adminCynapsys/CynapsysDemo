package de.cynapsys.metier;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.cynapsys.dao.UtilisateurRepository;
import de.cynapsys.entities.Utilisateur;
@Service
public class UtilisateurMetierImpl implements UtilisateurMetier {
	@Autowired
	private UtilisateurRepository utilisateurRepository; 
	@Override
	public List<Utilisateur> listUtilisateurs() {
		
		return utilisateurRepository.findAll();
	}

	@Override
	public Optional<Utilisateur> getUtilisateur(Long id) {
		 
		return utilisateurRepository.findById(id);
	}

	@Override
	public Utilisateur saveUtilisateur(Utilisateur u) {
		
		return utilisateurRepository.save(u);
	}

	@Override
	public Utilisateur updateUtilisateur(Utilisateur u, Long id) {
		u.setId(id);
		return utilisateurRepository.saveAndFlush(u);
	}

	@Override
	public void deleteUtilisateur(Long id) {
		utilisateurRepository.deleteById(id);
	}

	@Override
	public Utilisateur login(Utilisateur utilisateur) {
		return utilisateurRepository.findByEmailAndMdp(utilisateur.getEmail() , utilisateur.getMdp()).get(0);
		
	}

}
