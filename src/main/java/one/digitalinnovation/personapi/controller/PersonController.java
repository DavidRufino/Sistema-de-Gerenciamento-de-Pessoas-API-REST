package one.digitalinnovation.personapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    /*
    *   Person Controller
    *   Recebera as requisições do tipo: POST, GET e DELETE
    *   e encaminhara para seus respetivos methods e 'Service'
    *
    *   Caminho principal para acessar esse Controler: http://localhost:8080/api/v1/people
    * */

    @GetMapping
    public String getBook(){
        return "API Test";
    }
}
