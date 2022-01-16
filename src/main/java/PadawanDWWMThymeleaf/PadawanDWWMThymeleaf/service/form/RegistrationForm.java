package PadawanDWWMThymeleaf.PadawanDWWMThymeleaf.service.form;

import lombok.Data;

@Data
public class RegistrationForm {
    private String firstName;
    private String lastName;
    private String useName;
    private String address;
    private String email;
    private String password;
    private String confirmPassword;

}
