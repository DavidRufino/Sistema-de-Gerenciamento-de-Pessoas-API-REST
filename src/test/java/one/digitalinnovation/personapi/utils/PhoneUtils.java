package one.digitalinnovation.personapi.utils;

import one.digitalinnovation.personapi.dto.request.PhoneDTO;
import one.digitalinnovation.personapi.entity.Phone;
import one.digitalinnovation.personapi.enums.PhoneType;

public class PhoneUtils {

    /*
     *   Utils Serve para facilitar na hora que for feito o teste Unitario
     *   Aqui sera criado um 'formulario' pre-configurado pronto da entidade: Phone
     * */

    private static final String PHONE_NUMBER = "(21)99999999";
    private static final PhoneType PHONE_TYPE = PhoneType.MOBILE;
    private static final long PHONE_ID = 1L;

    //  Method para Criar um Fake Phone DTO
    public static PhoneDTO createFakeDTO() {
        return PhoneDTO.builder()
                .number(PHONE_NUMBER)
                .type(PHONE_TYPE)
                .build();
    }

    //  Method para Criar um Fake Phone Entity
    public static Phone createFakeEntity() {
        return Phone.builder()
                .id(PHONE_ID)
                .number(PHONE_NUMBER)
                .type(PHONE_TYPE)
                .build();
    }
}
