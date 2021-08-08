package one.digitalinnovation.personapi.utils;

import one.digitalinnovation.personapi.dto.request.PersonDTO;
import one.digitalinnovation.personapi.entity.Person;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;

public class PersonUtils {

    /*
    *   Utils Serve para facilitar na hora que for feito o teste Unitario
    *   Aqui sera criado um 'formulario' pre-configurado pronto da entidade: Person
    * */

    private static final String FIRST_NAME = "Rodrigo";
    private static final String LAST_NAME = "Peleias";
    private static final String CPF_NUMBER = "369.333.879-79";
    private static final long PERSON_ID = 1L;
    public static final LocalDate BIRTH_DATE = LocalDate.of(2019,11,11);

    //  Method para Criar um Fake PersonDTO
    public static PersonDTO createFakeDTO() {
        return PersonDTO.builder()
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF_NUMBER)
                .birthDate(BIRTH_DATE.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")))
                .phones(Collections.singletonList(PhoneUtils.createFakeDTO()))
                .build();
    }

    //  Method para Criar um Fake Person Entity
    public static Person createFakeEntity() {
        return Person.builder()
                .id(PERSON_ID)
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF_NUMBER)
                .birthDate(BIRTH_DATE)
                .phones(Collections.singletonList(PhoneUtils.createFakeEntity()))
                .build();
    }

}
