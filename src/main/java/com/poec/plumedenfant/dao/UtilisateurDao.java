package com.poec.plumedenfant.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.poec.plumedenfant.dao.model.Histoire;
import com.poec.plumedenfant.dao.model.Utilisateur;

public interface UtilisateurDao extends CrudRepository<Utilisateur, Integer> {
	
	@Modifying
	@Transactional
	@Query("UPDATE Utilisateur u set u.email =:email WHERE u.id =:idUtilisateur")
	public void updateEmail(int idUtilisateur, String email);
	
	@Modifying
	@Transactional
	@Query("UPDATE Utilisateur u set u.mdp =:mdp WHERE u.id =:idUtilisateur")
	public void updateMdp(int idUtilisateur, String mdp);
	
	@Modifying
	@Transactional
	@Query("UPDATE Utilisateur u set u.listeFavori =:listHistoire WHERE u.id =:idUtilisateur")
	public void updateListFavori(int idUtilisateur, List<Histoire> listHistoire);
	
	@Modifying
	@Transactional
	@Query("UPDATE Utilisateur u set u.listeVue =:listeVue WHERE u.id =:idUtilisateur")
	public void updateListVue(int idUtilisateur, List<Histoire> listeVue);

}
