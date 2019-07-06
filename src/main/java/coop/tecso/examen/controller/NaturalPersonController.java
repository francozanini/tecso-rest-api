package coop.tecso.examen.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import coop.tecso.examen.dto.NaturalPersonDto;
import coop.tecso.examen.model.NaturalPerson;
import coop.tecso.examen.responses.ErrorResponse;
import coop.tecso.examen.service.impl.NaturalPersonServiceImpl;
import javassist.NotFoundException;

import javax.validation.constraints.Min;
import javax.validation.Valid;

@RestController
@RequestMapping("/persons/natural")
public class NaturalPersonController {

	@Autowired
	private NaturalPersonServiceImpl personService;
	
	@GetMapping
	public List<NaturalPersonDto> index()
	{
		return personService.list();
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Object> getUser (@PathVariable("id") @Min(1) Long id) throws NotFoundException  
	{
		 Optional<NaturalPersonDto> person = personService.findById(id);
		 
		 return person.map(p -> new ResponseEntity<Object>(p, HttpStatus.OK))
				 .orElseGet(() -> new ResponseEntity<Object>(new ErrorResponse("Not Found"), HttpStatus.NOT_FOUND));
	}
	
	 @PostMapping
	 public ResponseEntity<Void> create(@Valid @RequestBody NaturalPersonDto newPerson) 
	 {
		 NaturalPerson person = personService.addPerson(newPerson);
		 
		 URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				 .path("/{id}")
				 .buildAndExpand(person.getId().toString())
				 .toUri();
		 
		 
		 return ResponseEntity.created(location).build();
	 }
	 
	 @DeleteMapping(path = "{id}")
	 public ResponseEntity<Void> delete(@PathVariable @Min(1) Long id) 
	 {
		 personService.remove(id);
		 return ResponseEntity.status(HttpStatus.OK).build();
	 }
	
}
