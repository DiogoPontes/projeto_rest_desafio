package br.com.diogo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.diogo.model.Colaborador;
import br.com.diogo.repository.ColaboradorRepository;

@RestController
@RequestMapping("colaboradores")
public class ColaboradorController {
	
	@Autowired
	ColaboradorRepository colaboradorRepository;
 
    @RequestMapping(method= RequestMethod.GET)
    public List<Colaborador> list() {
        return colaboradorRepository.findAll();
    }
    
    @RequestMapping(value="/setor", method= RequestMethod.GET)
    public List<Colaborador> listGroupBy() {
    	return colaboradorRepository.findGroupBySetor();
    }
    
 
    @RequestMapping(value="{id}", method= RequestMethod.GET)
    public Colaborador findById( @PathVariable("id") Long colaboradorId ) {
        return colaboradorRepository.findOne(colaboradorId);
    }
    
    @RequestMapping(method= RequestMethod.POST)
	//@ResponseStatus(HttpStatus.CREATED)
	public Colaborador insert(@Valid @RequestBody Colaborador colaborador) {
	    return colaboradorRepository.save(colaborador);
	}
    
    @RequestMapping(value="{id}", method= RequestMethod.DELETE)
    public ResponseEntity<Void> remover( @PathVariable("id") Long colaboradorId) {
    	Colaborador colaborador = colaboradorRepository.findOne(colaboradorId);
    	
    	if(colaborador == null) {
    		return ResponseEntity.notFound().build();
    	}
    	
    	colaboradorRepository.delete(colaborador);
		
    	return ResponseEntity.noContent().build();
    	
    }
}