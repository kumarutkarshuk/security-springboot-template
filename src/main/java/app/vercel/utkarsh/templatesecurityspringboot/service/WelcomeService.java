package app.vercel.utkarsh.templatesecurityspringboot.service;

import app.vercel.utkarsh.templatesecurityspringboot.model.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class WelcomeService {
    public ResponseEntity<ResponseDTO<String>> welcome() {
        ResponseDTO<String> dto = new ResponseDTO<>(null, null);
        try{
            dto.setBody("welcome");
            dto.setMessage("success");
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }catch (Exception e){
            dto.setMessage(e.getMessage());
            return new ResponseEntity<>(dto, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
