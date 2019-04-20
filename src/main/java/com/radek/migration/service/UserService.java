package com.radek.migration.service;

import com.radek.migration.entity.ActivationToken;
import com.radek.migration.entity.Role;
import com.radek.migration.entity.User;
import com.radek.migration.repository.ActivationTokenRepository;
import com.radek.migration.repository.RoleRepository;
import com.radek.migration.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    private ActivationTokenRepository activationTokenRepository;

    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository,
                       PasswordEncoder passwordEncoder, ActivationTokenRepository activationTokenRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.activationTokenRepository = activationTokenRepository;
    }



    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("Nie ma użytkownika o podanym id"));
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User findUserbyActivationHash(String activationHash) {
        return userRepository.findByActivationToken_Value(activationHash).orElseThrow(() -> new RuntimeException("nie ma takiego"));
    }


    public User register(User user) {
        Role role = roleRepository.findByName("ROLE_USER").orElseThrow(() -> new RuntimeException("dua"));
        user.setRoles(Set.of(role));
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        //ActivationToken activationToken = activationTokenRepository.save(new ActivationToken());

        ActivationToken activationToken = new ActivationToken();
        user.setActivationToken(activationToken);

        return userRepository.save(user);
    }
}
