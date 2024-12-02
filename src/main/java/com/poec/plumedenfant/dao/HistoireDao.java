package com.poec.plumedenfant.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.poec.plumedenfant.dao.model.Histoire;

public interface HistoireDao extends CrudRepository<Histoire, Integer> {
	
	@Modifying
	@Transactional
	@Query("UPDATE Histoire h set h.corps = :corps WHERE h.id =:idHistoire")
	public void updateCorps(int idHistoire, String corps);
	
	@Modifying
	@Transactional
	@Query("UPDATE Histoire h set h.nbLike = :nbLike WHERE h.id =:idHistoire")
	public void updateNbLike(int idHistoire, int nbLike);
	
	@Modifying
	@Transactional
	@Query("UPDATE Histoire h set h.titre = :titre WHERE h.id =:idHistoire")
	public void updateTitre(int idHistoire, String titre);
	
	@Modifying
	@Transactional
	@Query("UPDATE Histoire h set h.imageB64Json = :imageB64Json WHERE h.id =:idHistoire")
	public void updateUrlImage(int idHistoire, String imageB64Json);
	
	@Query("SELECT h FROM Histoire h ORDER BY h.nbLike DESC")
	public List<Histoire> findAllHistoiresSortedByLike();

}
