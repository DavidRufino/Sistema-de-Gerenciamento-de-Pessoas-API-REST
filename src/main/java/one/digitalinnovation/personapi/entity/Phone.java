package one.digitalinnovation.personapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.digitalinnovation.personapi.enums.PhoneType;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Phone {

    /*
    * Entidade Phone com atributos: Id, type e number
    * Com builder, getter, setter, constructor (com e sem assinatura) pelo Lombok
    * com as anotacoes: @Data @Builder @AllArgsConstructor @NoArgsConstructor
    * */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    //  atributo ID com auto increment

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PhoneType type; //  atributo TYPE com NOT NULL

    @Column(nullable = false)
    private String number;  //  atributo NUMBER com NOT NULL
}