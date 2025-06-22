package app.vercel.utkarsh.templatesecurityspringboot.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseDTO <T>{
    private T body;

    String message;
}
