package de.cynapsys.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.cynapsys.entities.Utilisateur;
import de.cynapsys.metier.UtilisateurMetier;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/utilisateur")
public class UtilisateurService {
	@Autowired
	private UtilisateurMetier utilisateurMetier;

	@RequestMapping(value = "/utilisateur", method = RequestMethod.GET)
	public List<Utilisateur> listUtilisateur() {
		return utilisateurMetier.listUtilisateurs();
	}
	
	@RequestMapping(value = "/utilisateur/{id}", method = RequestMethod.GET)
	public Optional<Utilisateur> getUtilisateur(@PathVariable Long id) {
		
		return utilisateurMetier.getUtilisateur(id);
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Utilisateur login(@RequestBody Utilisateur u) {
		
		return utilisateurMetier.login(u);
	}
	
	@RequestMapping(value = "/utilisateur", method = RequestMethod.POST)
	public Utilisateur saveUtilisateur (@RequestBody Utilisateur u) {
		
		return utilisateurMetier.saveUtilisateur(u);
	}
	
	@RequestMapping(value = "/utilisateur/{id}", method = RequestMethod.PUT)
	public Utilisateur updateUtilisateur(@RequestBody Utilisateur u, @PathVariable Long id) {
		
		u.setId(id);
		return utilisateurMetier.updateUtilisateur(u, id);
	}

	@RequestMapping(value = "/utilisateur/{id}", method = RequestMethod.DELETE)
	public void deleteUtilisateur(@PathVariable("id") Long id) {
		utilisateurMetier.deleteUtilisateur(id);
	}
}
