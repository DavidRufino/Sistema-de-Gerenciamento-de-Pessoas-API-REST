package one.digitalinnovation.personapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PhoneType {

    /*
    *  Enum Telefone com três valores: Home, Mobile e Commercial
    * */

    HOME("Home"),
    MOBILE("Mobile"),
    COMMERCIAL("Commercial");

    private final String description;
}
