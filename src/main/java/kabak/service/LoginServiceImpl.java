package kabak.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

public class LoginServiceImpl implements AuthenticationProvider
{
    private BCryptPasswordEncoder passwordEncoder;
    private final static GrantedAuthority GRANTED_AUTHORITY_USER = new SimpleGrantedAuthority("ROLE_USER");
    private final static GrantedAuthority GRANTED_AUTHORITY_ADMIN = new SimpleGrantedAuthority("ROLE_ADMIN");
    private final static GrantedAuthority GRANTED_AUTHORITY_GUEST = new SimpleGrantedAuthority("ROLE_GUEST");

    @Autowired
    private UserService userService;

    public void setPasswordEncoder(BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public BCryptPasswordEncoder getPasswordEncoder() {
        return passwordEncoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UsernamePasswordAuthenticationToken token = null;
        UserDetails userDetails;
        kabak.Entity.User user = null;
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        String userLastName = authentication.getPrincipal().toString();
        String userPassword = authentication.getCredentials().toString();

        try {
            user = userService.findByLastName(userLastName);
            if (user != null) {
//          if (!passwordEncoder.matches(userPassword, student.getPassword())) {
                if (!userPassword.equals(user.getPasswordUser())) {
                    throw new BadCredentialsException("Invalid Password");
                } else {
                    switch (user.getUserRole().getRole()) {
                        case "admin":
                            grantedAuthorities.add(GRANTED_AUTHORITY_ADMIN);
                            break;
                        case "guest":
                            grantedAuthorities.add(GRANTED_AUTHORITY_GUEST);
                            break;
                        case "user":
                            grantedAuthorities.add(GRANTED_AUTHORITY_USER);
                            break;
                        default:
                            grantedAuthorities.add(GRANTED_AUTHORITY_GUEST);
                            break;
                    }
                    userDetails = new User(userLastName, userPassword, true, true, true, true, grantedAuthorities);
                    token = new UsernamePasswordAuthenticationToken(userDetails, userPassword, grantedAuthorities);
                    token.setDetails(user);
                }
            } else {
                throw new UsernameNotFoundException("Student does not registered");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return token;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
