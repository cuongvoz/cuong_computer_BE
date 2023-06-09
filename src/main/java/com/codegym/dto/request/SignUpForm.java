package com.codegym.dto.request;

import com.codegym.model.user.User;
import org.springframework.validation.Errors;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class SignUpForm {
    @NotBlank(message = "Hãy nhập họ và tên.")
    private String name;
    @NotBlank(message = "Hãy nhập tên đăng nhập.")
    private String username;
    @NotBlank(message = "Hãy nhập email.")
    private String email;
    @NotBlank(message = "Hãy nhập mật khẩu.")
    private String password;
    @NotBlank(message = "Hãy nhập mật khẩu xác nhận.")
    private String confirmPassword;
    private Set<String> roles;

    public SignUpForm() {
    }

    public SignUpForm(String name, String username, String email, String password, Set<String> roles) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }
    public void validate(List<User> list, SignUpForm signInForm, Errors errors){
        for (User user : list) {
            if (Objects.equals(user.getUsername(), signInForm.getUsername())) {
                errors.rejectValue("username", "username", "Tên đăng nhập đã tồn tại");
            }
            if (Objects.equals(user.getEmail(), signInForm.getEmail())) {
                errors.rejectValue("email", "email", "Email đã được sử dụng");
            }
        }
        if (!Objects.equals(signInForm.getPassword(), signInForm.getConfirmPassword())) {
            errors.rejectValue("confirmPassword", "confirmPassword", "Mật khẩu xác nhận sai ");

        }
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }
}
