package com.devcambo.springbootthymeleaf.provider;

import com.devcambo.springbootthymeleaf.model.Role;
import com.devcambo.springbootthymeleaf.model.User;
import com.devcambo.springbootthymeleaf.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AuthProviderImpl implements AuthenticationProvider {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email = authentication.getName();
        String pwd = authentication.getCredentials().toString();
        User user = userRepo.readByEmail(email);
        if (user != null && user.getUserId() > 0 && encoder.matches(pwd, user.getPassword())){
            return new UsernamePasswordAuthenticationToken(email, null, getGrantedAuthorities(user.getRole()));
        }else {
            throw new BadCredentialsException("Invalid credentials!");
        }
    }

    private List<GrantedAuthority> getGrantedAuthorities(Role roles) {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + roles.getRoleName()));
        return grantedAuthorities;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}
