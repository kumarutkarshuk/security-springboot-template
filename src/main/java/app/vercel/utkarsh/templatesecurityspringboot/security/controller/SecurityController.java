package app.vercel.utkarsh.templatesecurityspringboot.security.controller;

import app.vercel.utkarsh.templatesecurityspringboot.model.User;
import app.vercel.utkarsh.templatesecurityspringboot.model.dto.ResponseDTO;
import app.vercel.utkarsh.templatesecurityspringboot.model.dto.UserDTO;
import app.vercel.utkarsh.templatesecurityspringboot.security.service.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SecurityController {
    private final SecurityService securityService;

    @PostMapping("/register")
    public ResponseEntity<ResponseDTO<Void>> registerUser(@RequestBody UserDTO userDTO){
        return securityService.registerUser(userDTO);
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseDTO<String>> loginUser(@RequestBody User user){
        return securityService.loginUser(user);
    }
}
