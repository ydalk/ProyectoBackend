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
    public DataLoader(IUserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public void run(ApplicationArguments args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode("caro123");
        BCryptPasswordEncoder passwordEncoder1 = new BCryptPasswordEncoder();
        String hashedPassword1 = passwordEncoder1.encode("admin123");
        userRepository.save( new AppUser("carolina", "caro", "carol@clinicaodonto.com", hashedPassword, AppUserRole.USER ));
        userRepository.save(new AppUser("Administrador", "admin", "admin@clinicaodonto.com",hashedPassword1, AppUserRole.ADMIN));
    }
}
