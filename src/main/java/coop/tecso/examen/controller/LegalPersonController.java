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

import coop.tecso.examen.dto.LegalPersonDto;
import coop.tecso.examen.dto.UpdateLegalPersonDto;
import coop.tecso.examen.model.LegalPerson;
import coop.tecso.examen.service.impl.LegalPersonServiceImpl;
import javassist.NotFoundException;

@RestController
@RequestMapping("/person/legal")
public class LegalPersonController {

	@Autowired
	private LegalPersonServiceImpl personService;
	
	@GetMapping(headers = "Accept=application/json")
	public List<LegalPersonDto> index()
	{
		return personService.list();
	}
	
	@GetMapping(value = "/{id}", headers = "Accept=application/json")
	public ResponseEntity<LegalPersonDto> getUser (@PathVariable("id") @Min(1) Long id) throws NotFoundException  
	{
		 Optional<LegalPersonDto> person = personService.findById(id);
		 return new ResponseEntity<LegalPersonDto>(person.get(), HttpStatus.OK);
	}
	
	 @PostMapping(headers = "Accept=application/json")
	 public ResponseEntity<Void> create(@Valid @RequestBody LegalPersonDto newPersonDto) 
	 {
		 LegalPerson person = personService.addPerson(newPersonDto);
		 
		 URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				 .path("/{id}")
				 .buildAndExpand(person.getId().toString())
				 .toUri();
		 
		 return ResponseEntity.created(location).build();
	 }
	 
	 @PutMapping(path = "/{id}", headers = "Accept=application/json")
	 public ResponseEntity<Void> edit (@PathVariable("id") final long id, @Valid @RequestBody UpdateLegalPersonDto newPersonDto) throws NotFoundException
	 {
		 LegalPerson person = personService.editPerson(id, newPersonDto);

		 URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				 .path("/{id}")
				 .buildAndExpand(person.getId().toString())
				 .toUri();
		 
		 return ResponseEntity.created(location).build();
	 }
	 
	 @DeleteMapping(path = "/{id}")
	 public ResponseEntity<Void> delete(@PathVariable @Min(1) final Long id) throws NotFoundException 
	 {
		 personService.remove(id);
		 return ResponseEntity.status(HttpStatus.OK).build();
	 }
	
}