package fr.jicay.tracking.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sessions")
public class SessionController {

    @GetMapping
    public String getSessions() {
        return "Hello world";
    }
}
