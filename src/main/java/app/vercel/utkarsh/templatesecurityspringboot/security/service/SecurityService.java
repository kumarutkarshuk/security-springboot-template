package app.vercel.utkarsh.templatesecurityspringboot.security.service;

import app.vercel.utkarsh.templatesecurityspringboot.model.User;
import app.vercel.utkarsh.templatesecurityspringboot.model.dto.ResponseDTO;
import app.vercel.utkarsh.templatesecurityspringboot.model.dto.UserDTO;
import app.vercel.utkarsh.templatesecurityspringboot.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SecurityService {
    private final UserRepo userRepo;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JWTService jwtService;

    public ResponseEntity<ResponseDTO<Void>> registerUser(UserDTO userDTO){
        ResponseDTO<Void> dto = new ResponseDTO<>(null, null);
        try{
            User user = User.builder()
                    .username(userDTO.getUsername())
                    .password(bCryptPasswordEncoder.encode(userDTO.getPassword()))
                    .accountNonExpired(true)
                    .accountNonLocked(true)
                    .credentialsNonExpired(true)
                    .enabled(true)
                    .build();

            userRepo.save(user);
            dto.setMessage("user registered successfully");
            return new ResponseEntity<>(dto, HttpStatus.CREATED);
        } catch (Exception e) {
            dto.setMessage(e.getMessage());
            return new ResponseEntity<>(dto, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<ResponseDTO<String>> loginUser(User user){
        ResponseDTO<String> dto = new ResponseDTO<>(null, null);
        try{
            Authentication authenticate = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            user.getUsername(), user.getPassword()
                    )
            );

            if(authenticate.isAuthenticated()){
                dto.setBody(jwtService.generateToken(user));
                dto.setMessage("user logged in successfully");
                return new ResponseEntity<>(dto, HttpStatus.OK);
            }

            dto.setMessage("unable to login user");
            return new ResponseEntity<>(dto, HttpStatus.UNAUTHORIZED);

        } catch (Exception e) {
            dto.setMessage(e.getMessage());
            return new ResponseEntity<>(dto, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
