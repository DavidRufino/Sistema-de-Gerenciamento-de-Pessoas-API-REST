package one.digitalinnovation.personapi.service;

import one.digitalinnovation.personapi.dto.request.PersonDTO;
import one.digitalinnovation.personapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.personapi.entity.Person;
import one.digitalinnovation.personapi.exception.PersonNotFoundException;
import one.digitalinnovation.personapi.mapper.PersonMapper;
import one.digitalinnovation.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {

    /*
     *   Person Service
     *   Possui a regra de criação de Person
     * */

    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(PersonDTO personDTO) {
        Person personToSave = personMapper.toModel(personDTO);

        Person savedPerson = personRepository.save(personToSave);
        return createMessageResponse("Created Person with ID:", savedPerson.getId());
    }

    public List<PersonDTO> listAll() {
        List<Person> allPeople = personRepository.findAll();

        return allPeople.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PersonDTO findById(Long idPeople) throws PersonNotFoundException {
        Person person = verifyIfExists(idPeople);

        return personMapper.toDTO(person);
    }

    public MessageResponseDTO updateById(Long idPeople, PersonDTO personDTO) throws PersonNotFoundException {
        verifyIfExists(idPeople);
        Person personToUpdate = personMapper.toModel(personDTO);

        personRepository.save(personToUpdate);
        return createMessageResponse("Updated Person with ID: ", idPeople);
    }

    public void delete(Long idPeople) throws PersonNotFoundException {
        verifyIfExists(idPeople);

        personRepository.deleteById(idPeople);
    }

    //  Private Methods

    private Person verifyIfExists(Long idPeople) throws PersonNotFoundException {
        return personRepository.findById(idPeople)
                .orElseThrow(() -> new PersonNotFoundException(idPeople));
    }

    private MessageResponseDTO createMessageResponse(String msg, Long idPeople) {
        return MessageResponseDTO
                .builder()
                .message(msg + idPeople)
                .build();
    }
}
