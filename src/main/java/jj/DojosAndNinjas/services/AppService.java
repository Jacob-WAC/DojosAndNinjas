package jj.DojosAndNinjas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import jj.DojosAndNinjas.Repositiories.DojoRepository;
import jj.DojosAndNinjas.Repositiories.NinjaRepository;
import jj.DojosAndNinjas.models.Dojo;
import jj.DojosAndNinjas.models.Ninja;

@Service
public class AppService {
		private final DojoRepository dojoRepository;
		private final NinjaRepository ninjaRepository;
		
		public AppService(DojoRepository dojoRepository, NinjaRepository ninjaRepository) {
			this.dojoRepository = dojoRepository;
			this.ninjaRepository = ninjaRepository;
		}
	
		public List<Dojo> findAllDojos(){
			return (List<Dojo>)this.dojoRepository.findAll();
		}
		
		public Dojo createDojo(Dojo dojo) {
			return this.dojoRepository.save(dojo);
		}
		public Ninja createNinja(Ninja ninja) {
			return this.ninjaRepository.save(ninja);
		}
		
		public Dojo getDojoById(Long id) {
			return this.dojoRepository.findById(id).orElse(null);
		}
		
		
		
	
}
