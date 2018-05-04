package de.cynapsys.metier;

import java.util.List;

import de.cynapsys.entities.Utilisateur;

public interface UtilisateurMetier {
	public List<Utilisateur> listUtilisateurs();
	public Utilisateur getUtilisateur(Long id);
	public Utilisateur saveUtilisateur(Utilisateur u);
	public Utilisateur updateUtilisateur(Utilisateur u , Long id);
	public void deleteUtilisateur (Long id);
}
