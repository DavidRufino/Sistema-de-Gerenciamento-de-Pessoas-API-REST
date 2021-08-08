package one.digitalinnovation.personapi.controller;

import lombok.AllArgsConstructor;
import one.digitalinnovation.personapi.dto.request.PersonDTO;
import one.digitalinnovation.personapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.personapi.entity.Person;
import one.digitalinnovation.personapi.exception.PersonNotFoundException;
import one.digitalinnovation.personapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/people")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonController {

    /*
    *   Person Controller
    *   Recebera as requisições do tipo: POST, GET, PUT e DELETE
    *   e encaminhara para seus respetivos methods e 'Service'
    *
    *   Caminho principal para acessar esse Controler: http://localhost:8080/api/v1/people
    *
    * */

    private PersonService personService;    //  Construtor já esta sendo gerado, por conta do Lombok: @AllArgsConstructor(onConstructor = @__(@Autowired))

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson (@RequestBody @Valid PersonDTO person) {
        return personService.createPerson(person);
    }

    @GetMapping
    public List<PersonDTO> listAll() {
        return personService.listAll();
    }

    @GetMapping("/{IdPeople}")
    public PersonDTO findById(@PathVariable Long IdPeople) throws PersonNotFoundException {
        return personService.findById(IdPeople);
    }

    @PutMapping("/{IdPeople}")
    public MessageResponseDTO updateById(@PathVariable Long IdPeople, @RequestBody @Valid PersonDTO personDTO) throws PersonNotFoundException {
        return personService.updateById(IdPeople, personDTO);
    }

    @DeleteMapping("/{IdPeople}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long IdPeople) throws PersonNotFoundException {
        personService.delete(IdPeople);
    }
}
