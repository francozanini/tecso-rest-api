package coop.tecso.examen.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.constraints.Min;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import coop.tecso.examen.dto.NaturalPersonDto;
import coop.tecso.examen.model.NaturalPerson;
import coop.tecso.examen.repository.NaturalPersonRepository;
import coop.tecso.examen.service.NaturalPersonService;
import javassist.NotFoundException;

@Service
public class NaturalPersonServiceImpl implements NaturalPersonService{

	@Autowired
	private NaturalPersonRepository personRepository;
	
	
	@Autowired
	private ModelMapper modelMapper;
	
	public NaturalPerson addPerson(NaturalPersonDto newPersonDto) {
		NaturalPerson newPerson = modelMapper.map(newPersonDto, NaturalPerson.class);
		
		return personRepository.save(newPerson);		
	}

	public List<NaturalPersonDto> list() {
		List<NaturalPerson> people = personRepository.findAll();
		
		return people.stream()
				.map(person -> modelMapper.map(person, NaturalPersonDto.class))
				.collect(Collectors.toList());
	}
	
	public List<NaturalPerson> list(Direction direction) {
		return personRepository.findAll(sortByLastName(direction));
	}
	
	private Sort sortByLastName(Direction direction)
	{
		return new Sort(direction, "lastName");
	}

	public Optional<NaturalPersonDto> findById(Long id) throws NotFoundException{
		Optional<NaturalPerson> person = personRepository.findById(id);
		
		if (person.isPresent())
		{
			Optional<NaturalPersonDto> personDto = Optional.of(modelMapper.map(person.get(), NaturalPersonDto.class));			
			return personDto;
		}
		else throw new NotFoundException(String.format("Person %d not found", id));
		
	}
			
	public void remove(@Min(1) Long id) 
	{
		personRepository.deleteById(id);
	}

}
