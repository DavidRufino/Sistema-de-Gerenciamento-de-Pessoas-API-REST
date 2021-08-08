package one.digitalinnovation.personapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Person {

    /*
     * Entidade Person com atributos: Id, firstName, lastName, cpf, birthDate e *phones
     * Com builder, getter, setter, constructor (com e sem assinatura) pelo Lombok
     * com as anotacoes: @Data @Builder @AllArgsConstructor @NoArgsConstructor
     * */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    //  Atributo ID com auto increment

    @Column(nullable = false)
    private String firstName;   //  Atributo First_Name com NOT NULL

    @Column(nullable = false)
    private String lastName;    //  Atributo Last_Name com NOT NULL

    @Column(nullable = false, unique = true)
    private String cpf; //  Atributo CPF como unico e com NOT NULL

    private LocalDate birthDate;    //  Atributo Birth_Date com NOT NULL

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<Phone> phones; //  Atributo Phones com NOT NULL
}
