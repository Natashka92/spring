package com.common.dto.user;


import com.common.dto.IInputDTO;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="user")
public class UserInputDTO implements IInputDTO{

    @NotEmpty(message="valid.err.user.title.login.required")
    @Length(min=1, max=12, message="valid.err.user.title.login.range")
    private String login;

    @NotEmpty(message="valid.err.user.title.password.required")
    @Length(min=6, message="valid.err.user.title.password.range")
    private String password;

    @NotEmpty(message="valid.err.user.title.confirmPassword.required")
    private String confirmPassword;

    @NotEmpty(message="valid.err.user.title.firstName.required")
    @Length(min=1, max=20, message="valid.err.user.title.firstName.range")
    private String firstName;

    @NotEmpty(message = "valid.err.user.title.lastName.required")
    @Length(min=1, max=20, message="valid.err.user.title.lastName.range")
    private String lastName;

    @NotEmpty(message = "valid.err.user.address.required")
    @Length(min=1, max=45, message="valid.err.user.address.range")
    private String address;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
