package com.example.ProyectoClinic.service;

import com.example.ProyectoClinic.modelo.AppUser;
import com.example.ProyectoClinic.modelo.AppUserRole;
import com.example.ProyectoClinic.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private IUserRepository userRepository;

    @Autowired
    public DataLoader(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(ApplicationArguments args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode("caro123");
        BCryptPasswordEncoder passwordEncoder1 = new BCryptPasswordEncoder();
        String hashedPassword1 = passwordEncoder1.encode("admin123");

        AppUser user = new AppUser("Carolina", "caro", "carol@clinicaodonto.com", hashedPassword, AppUserRole.USER);
        AppUser admin = new AppUser("Administrador", "admin", "admin@clinicaodonto.com", hashedPassword1, AppUserRole.ADMIN);

        if(!userRepository.findByEmail(user.getEmail()).isPresent()){
            userRepository.save(user);
            userRepository.save(admin);
        }
    }
}
