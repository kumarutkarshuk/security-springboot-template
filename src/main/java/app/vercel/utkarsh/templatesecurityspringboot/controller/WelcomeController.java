package app.vercel.utkarsh.templatesecurityspringboot.controller;

import app.vercel.utkarsh.templatesecurityspringboot.model.dto.ResponseDTO;
import app.vercel.utkarsh.templatesecurityspringboot.service.WelcomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WelcomeController {
    private final WelcomeService welcomeService;

    @GetMapping("")
    public ResponseEntity<ResponseDTO<String>> welcome(){
        return welcomeService.welcome();
    }
}
