package de.cynapsys.services;

import java.util.List;

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
	
	@RequestMapping(value = "/utilisateur", method = RequestMethod.POST)
	public Utilisateur saveUtilisateur (@RequestBody Utilisateur u) {
		
		return utilisateurMetier.saveUtilisateur(u);
	}
	
	@RequestMapping(value = "/utilisateur/{id}", method = RequestMethod.PUT)
	public Utilisateur updateUtilisateur(@RequestBody Utilisateur u, @PathVariable Long id) {
		
		u.setId(id);
		return utilisateurMetier.updateUtilisateur(u, id);
	}

	@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
	public void deleteUtilisateur(@PathVariable("id") Long id) {
		utilisateurMetier.deleteUtilisateur(id);
	}
}
