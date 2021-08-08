package one.digitalinnovation.personapi.service;

import one.digitalinnovation.personapi.dto.request.PersonDTO;
import one.digitalinnovation.personapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.personapi.entity.Person;
import one.digitalinnovation.personapi.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static one.digitalinnovation.personapi.utils.PersonUtils.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    /*
     *  Teste Unitario da class Service: Person (PersonService)
     *  [*]é importante criar no mesmo nivel de pacote da propria class
     * */

    @Mock
    private PersonRepository personRepository;

    /*
     *  Atravez da anotação: @AllArgsConstructor(onConstructor = @__(@Autowired))
     *  que esta no service: PersonService.java
     *
     *  Ele vai Injetar o Mock dentro do personRepository de PersonService.java
     */

    @InjectMocks
    private PersonService personService;

    @Test
    void testGivenPersonDTOThenReturnSavedMessage() {
        PersonDTO personDTO = createFakeDTO();
        Person expectedSavedPerson = createFakeEntity();

        //  Quando for chamar um method save dentro da class PersonService.java
        //  Passando o objeto esperado 'expectedSavedPerson'
        //  Me retorne a mensagem (mensagem criada com sucesso ou nao)
        //when(personRepository.save(expectedSavedPerson)).thenReturn(expectedSavedPerson);
        when(personRepository.save(any(Person.class))).thenReturn(expectedSavedPerson);

        MessageResponseDTO expectedSucessMessage = createdExpectedMessageResponse("Created Person with ID: ", expectedSavedPerson.getId());
        MessageResponseDTO succesMessage = personService.createPerson(personDTO);

        assertEquals(expectedSucessMessage, succesMessage);
    }

    public MessageResponseDTO createdExpectedMessageResponse(String Message, Long idPeople) {
        return MessageResponseDTO
                .builder()
                .message(Message + idPeople)
                .build();
    }
}
