package com.radek.migration.security;

import com.radek.migration.entity.User;
import com.radek.migration.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Nie ma takiego użytkownika"));

        return new CustomUserDetails(user);
    }

    //dodac rejestracje uzytkownikow
    // domyslnie uzytkownik ma miec role user przy rejestracji
    // zrobic andpoint rejestracja(publiczna /activate/{activation_hash}) i aktywacja konta()
}
