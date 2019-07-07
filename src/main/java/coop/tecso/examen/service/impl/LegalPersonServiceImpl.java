package coop.tecso.examen.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.constraints.Min;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coop.tecso.examen.dto.LegalPersonDto;
import coop.tecso.examen.model.LegalPerson;
import coop.tecso.examen.repository.LegalPersonRepository;
import coop.tecso.examen.service.LegalPersonService;
import javassist.NotFoundException;

@Service
public class LegalPersonServiceImpl implements LegalPersonService {

	@Autowired
	private LegalPersonRepository personRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public LegalPerson addPerson(LegalPersonDto newPersonDto) 
	{
		LegalPerson newPerson = modelMapper.map(newPersonDto, LegalPerson.class);
		
		return personRepository.save(newPerson);		
	}

	public List<LegalPersonDto> list() {
		List<LegalPerson>  people = personRepository.findAll();
		
		return people.stream()
				.map(person -> modelMapper.map(person, LegalPersonDto.class))
				.collect(Collectors.toList());
	}
	
	public Optional<LegalPersonDto> findById(Long id) throws NotFoundException{
		Optional<LegalPerson> person = personRepository.findById(id);
		
		if (person.isPresent())
		{
			Optional<LegalPersonDto> personDto = Optional.of(modelMapper.map(person.get(), LegalPersonDto.class));			
			return personDto;
		}
		else throw new NotFoundException(String.format("Person %d not found", id));
		
	}
	
	public LegalPerson editPerson(long id, LegalPersonDto LegalPersonDto) throws NotFoundException
	{
		Optional<LegalPerson> optionalPerson = personRepository.findById(id);
		
		LegalPerson person;
		
		if (optionalPerson.isPresent())
		{
			person = new LegalPerson(LegalPersonDto.getBusinessName(),
					LegalPersonDto.getCuit(),
					LegalPersonDto.getFirstYearOfBusiness());
			
		}
		else 
		{
			person = optionalPerson.get();
			
			person.setBusinessName(LegalPersonDto.getBusinessName());
			person.setCuit(LegalPersonDto.getCuit());
			person.setFirstYearOfBusiness(LegalPersonDto.getFirstYearOfBusiness());
		
		}
		return personRepository.save(person);
	}
			
	public void remove(@Min(1) Long id) throws NotFoundException 
	{
		if (personRepository.existsById(id)) {
			personRepository.deleteById(id);			
		}
		else throw new NotFoundException(String.format("Person of id %d was not found", id));
	}
}
