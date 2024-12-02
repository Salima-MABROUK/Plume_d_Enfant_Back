package com.poec.plumedenfant.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.poec.plumedenfant.dao.model.Role;

public interface RoleDao extends CrudRepository<Role, Integer> {
	
	Optional<Role> findByName(String name);

}
