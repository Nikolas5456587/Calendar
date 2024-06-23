package com.example.calendar.service;


import com.example.calendar.entities.Member;
import com.example.calendar.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@Service
public class SecurityService {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public SecurityService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public String encodePassword(String plainPassword) {
        return passwordEncoder.encode(plainPassword);
    }

    public boolean passwordsMatch(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
    public void register(String name, String password) {
        Member member = new Member();
        member.setUsername(name);
        member.setPassword(passwordEncoder.encode(password));
        member.saveMember(name);
    }
}