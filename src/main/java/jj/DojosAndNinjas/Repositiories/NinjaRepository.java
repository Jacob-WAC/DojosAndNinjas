package jj.DojosAndNinjas.Repositiories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import jj.DojosAndNinjas.models.Ninja;



public interface NinjaRepository extends CrudRepository<Ninja, Long> {
	
List<Ninja> findAll();

}
