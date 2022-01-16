package PadawanDWWMThymeleaf.PadawanDWWMThymeleaf.service;



import PadawanDWWMThymeleaf.PadawanDWWMThymeleaf.model.Account;
import PadawanDWWMThymeleaf.PadawanDWWMThymeleaf.model.User;
import PadawanDWWMThymeleaf.PadawanDWWMThymeleaf.repository.AccountRepository;
import PadawanDWWMThymeleaf.PadawanDWWMThymeleaf.repository.UserRepository;
import PadawanDWWMThymeleaf.PadawanDWWMThymeleaf.service.form.RegistrationForm;
import org.springframework.beans.factory.annotation.Autowired;
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
        Account account = new Account();
        account.setAmount(0.0);
        user.setAccount(account);
        user.setPassword(passwordEncoder.encode(form.getPassword()));

        return userRepository.save(user);
    }

    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }





}