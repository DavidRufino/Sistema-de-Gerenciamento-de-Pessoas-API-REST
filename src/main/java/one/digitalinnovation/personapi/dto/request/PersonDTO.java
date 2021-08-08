package one.digitalinnovation.personapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.digitalinnovation.personapi.entity.Phone;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {

    private Long id;    //  Atributo ID

    @NotEmpty
    @Size(min = 2, max = 100)
    private String firstName;   //  Atributo First_Name

    @NotEmpty
    @Size(min = 2, max = 100)
    private String lastName;    //  Atributo Last_Name

    @NotEmpty
    @CPF
    private String cpf; //  Atributo CPF

    private String birthDate;    //  Atributo Birth_Date

    @Valid
    @NotEmpty
    private List<PhoneDTO> phones; //  Atributo Phones
}
