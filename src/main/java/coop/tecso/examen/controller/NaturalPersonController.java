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
@RequestMapping("/person/natural")
public class NaturalPersonController {

	@Autowired
	private NaturalPersonServiceImpl personService;
	
	@GetMapping
	public List<NaturalPersonDto> index()
	{
		return personService.list();
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<NaturalPersonDto> getPerson (@PathVariable(value = "id") @Min(1) Long id) throws NotFoundException  
	{
		 Optional<NaturalPersonDto> person = personService.findById(id);
		 return new ResponseEntity<NaturalPersonDto>(person.get(), HttpStatus.OK);
	}
	
	 @PostMapping
	 public ResponseEntity<NaturalPersonDto> create(@Valid @RequestBody NaturalPersonDto newPerson) 
	 {
		 NaturalPerson person = personService.addPerson(newPerson);
		 
		 URI location = buildURI(person.getId());
		 
		 return ResponseEntity.created(location).build();
	 }
	 
	 @PutMapping(path = "/{id}")
	 public ResponseEntity<Void> edit (@Min(1) @PathVariable Long id, @RequestBody UpdateNaturalPersonDto personDto)
	 {
		 NaturalPerson person = personService.editPerson(id, personDto);

		 URI location = buildURI(person.getId());
		 
		 return ResponseEntity.created(location).build();
	 }
	 
	 @DeleteMapping(path = "/{id}")
	 public ResponseEntity<String> delete(@PathVariable(value = "id") @Min(1) Long id) throws NotFoundException 
	 {
		 personService.remove(id);
		 
		 return new ResponseEntity<String>("Person removed", HttpStatus.OK);
	 }
	 
	 private URI buildURI(Long id)
	 {
		 return ServletUriComponentsBuilder.fromCurrentRequest()
				 .replacePath("/{id}")
				 .buildAndExpand(id.toString())
				 .toUri();
	 }
	
}
