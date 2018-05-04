package de.cynapsys.metier;

import java.util.List;

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
	public Utilisateur getUtilisateur(Long id) {
		
		return utilisateurRepository.getOne(id);
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

}
