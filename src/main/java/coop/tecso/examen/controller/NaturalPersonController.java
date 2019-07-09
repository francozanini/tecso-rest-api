package coop.tecso.examen.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import coop.tecso.examen.dto.NaturalPersonDto;
import coop.tecso.examen.dto.UpdateNaturalPersonDto;
import coop.tecso.examen.model.NaturalPerson;
import coop.tecso.examen.service.impl.NaturalPersonServiceImpl;
import javassist.NotFoundException;

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
	public ResponseEntity<NaturalPersonDto> getPerson (@PathVariable("id") @Min(1) Long id) throws NotFoundException  
	{
		 Optional<NaturalPersonDto> person = personService.findById(id);
		 return new ResponseEntity<NaturalPersonDto>(person.get(), HttpStatus.OK);
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
	 
	 @PutMapping(path = "/{id}")
	 public ResponseEntity<Void> edit (@PathVariable @Min(1) final Long id, @RequestBody UpdateNaturalPersonDto personDto)
	 {
		 NaturalPerson person = personService.editPerson(id, personDto);

		 URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				 .path("/{id}")
				 .buildAndExpand(person.getId().toString())
				 .toUri();
		 
		 return ResponseEntity.created(location).build();
	 }
	 
	 @DeleteMapping(path = "/{id}")
	 public ResponseEntity<Void> delete(@PathVariable @Min(1) Long id) throws NotFoundException 
	 {
		 personService.remove(id);
		 
		 return ResponseEntity.status(HttpStatus.OK).build();
	 }
	
}
