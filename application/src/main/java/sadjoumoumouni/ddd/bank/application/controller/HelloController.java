package sadjoumoumouni.ddd.bank.application.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping("/home")
    public ResponseEntity<String> hello() {
        return new ResponseEntity<>("hello world !", HttpStatus.OK);
    }
}
