package PadawanDWWMThymeleaf.PadawanDWWMThymeleaf.service;




import PadawanDWWMThymeleaf.PadawanDWWMThymeleaf.model.User;

import PadawanDWWMThymeleaf.PadawanDWWMThymeleaf.repository.UserRepository;
import PadawanDWWMThymeleaf.PadawanDWWMThymeleaf.service.form.RegistrationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service("UserService")
public class UserService {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registration(final RegistrationForm form) {
        User user = new User();
        user.setFirstName(form.getFirstName());
        user.setLastName(form.getLastName());
        user.setUseName(form.getUseName());
        user.setAddress(form.getAddress());
        user.setEmail(form.getEmail());

        user.setPassword(passwordEncoder.encode(form.getPassword()));

        return userRepository.save(user);
    }

    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }

    public User findAccount(){
        org.springframework.security.core.userdetails.User springUser = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userRepository.findUserByEmail(springUser.getUsername())
                .orElseThrow(() -> new RuntimeException("user with email  not found"));


    }



}