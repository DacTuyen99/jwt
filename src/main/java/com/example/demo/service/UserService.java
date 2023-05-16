package com.example.demo.service;

import com.example.demo.dto.ChangePassword;
import com.example.demo.dto.RegisterUserDTO;
import com.example.demo.exception.BaseException;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;

    public User saveUser(RegisterUserDTO registerUserDTO){
        validateAccount(registerUserDTO);
        User user = new User();
        user.setPassword(passwordEncoder.encode(registerUserDTO.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.findRoleByName("ROLE_USER"));
        user.setRoles(roles);
        user.setUser_name(registerUserDTO.getUser_name());
        user.setFull_name(registerUserDTO.getFull_name());
        user.setEmail(registerUserDTO.getEmail());
        return userRepository.save(user);
    }

    public Role saveRole(Role role){
        return roleRepository.save(role);
    }

    public void addToUser(String username, String roleName){
        User user = userRepository.findUserByEmail(username).get();
        Role role = roleRepository.findRoleByName(roleName);
        user.getRoles().add(role);
    }

    public void validateAccount(RegisterUserDTO registerUserDTO){
        if (ObjectUtils.isEmpty(registerUserDTO)){
            throw new BaseException(String.valueOf(HttpStatus.BAD_REQUEST.value()),"Data  must not empty");
        }
        User user = userRepository.findUserByEmail(registerUserDTO.getEmail()).get();
        if (!ObjectUtils.isEmpty(user)){
            throw new BaseException(String.valueOf(HttpStatus.BAD_REQUEST.value()),"Username had existed");
        }
    }

    public User getEmailByAuthentication(Authentication authentication){
        User user = (User) authentication.getPrincipal();
        return user;
    }

    public void changePassword(ChangePassword changePassword, Authentication authentication){
        Optional<User> user = userRepository.findUserByEmail(changePassword.getEmail());
        if (user.isPresent() && user.get().getEmail().equals(getEmailByAuthentication(authentication).getEmail())){
            if (passwordEncoder.matches(changePassword.getOldPassword(), user.get().getPassword()) &&
                    changePassword.getNewPassword().equals(changePassword.getConfirmPassword())){
                user.get().setPassword(passwordEncoder.encode(changePassword.getNewPassword()));
                userRepository.save(user.get());
            }else {
                throw new BaseException(String.valueOf(HttpStatus.BAD_REQUEST.value()),"sai password");
            }
        }else {
            throw new BaseException(String.valueOf(HttpStatus.BAD_REQUEST.value()),"email sai");
        }
    }
}
