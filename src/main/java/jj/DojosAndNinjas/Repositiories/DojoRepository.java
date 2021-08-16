package jj.DojosAndNinjas.Repositiories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import jj.DojosAndNinjas.models.Dojo;

public interface DojoRepository extends CrudRepository<Dojo, Long>{
		
	List<Dojo> findAll();
	
	
	
	
}
