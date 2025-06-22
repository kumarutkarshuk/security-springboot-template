package app.vercel.utkarsh.templatesecurityspringboot.security.service;

import app.vercel.utkarsh.templatesecurityspringboot.model.User;
import app.vercel.utkarsh.templatesecurityspringboot.repo.UserRepo;
import app.vercel.utkarsh.templatesecurityspringboot.security.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Objects;

@RequiredArgsConstructor
@Component
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);

        if (Objects.isNull(user)) {
            throw new UsernameNotFoundException(String.format("username: %s not found", username));
        }

        return new CustomUserDetails(user);
    }
}
