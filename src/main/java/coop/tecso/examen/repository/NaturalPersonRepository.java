package coop.tecso.examen.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import coop.tecso.examen.model.NaturalPerson;

public interface NaturalPersonRepository extends JpaRepository<NaturalPerson, Long>
{
    
    Optional<NaturalPerson> findByDni(Long dni);
    
    
    
    
}
