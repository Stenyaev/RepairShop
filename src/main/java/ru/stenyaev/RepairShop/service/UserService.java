package ru.stenyaev.RepairShop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.stenyaev.RepairShop.entity.User;
import ru.stenyaev.RepairShop.exceptions.RoleNotFoundException;
import ru.stenyaev.RepairShop.exceptions.UserAlreadyExistsException;
import ru.stenyaev.RepairShop.repo.UserRepo;
import ru.stenyaev.RepairShop.repo.RoleRepo;
import ru.stenyaev.RepairShop.types.ErrorMessageType;
import ru.stenyaev.RepairShop.types.RoleType;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private RoleRepo roleRepo;


    public Optional<User> findByUsername(String username) {
        return userRepo.findByUsername(username);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException(
                        String.format(
                                ErrorMessageType.USER_NOT_FOUND_SF.getText(), username)
                ));

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                user.getRoles().stream()
                        .map(role -> new SimpleGrantedAuthority(
                                role.getName()))
                        .toList()
        );
    }

    public User createNewUser(User user) throws UserAlreadyExistsException, RoleNotFoundException {
        if (findByUsername(user.getUsername()).isPresent()) {
            throw new UserAlreadyExistsException(
                    String.format(
                            ErrorMessageType.USER_ALREADY_EXIST_SF.getText(),
                            user.getUsername()
                    ));
        }

        user.setRoles(List.of(
                roleRepo.findByName(RoleType.USER_ROLE.toString())
                        .orElseThrow(() -> new RoleNotFoundException(
                                String.format(
                                        ErrorMessageType.ROLE_NOT_FOUND_SF.getText(),
                                        RoleType.USER_ROLE)
                        ))
        ));

        return userRepo.save(user);
    }
}
