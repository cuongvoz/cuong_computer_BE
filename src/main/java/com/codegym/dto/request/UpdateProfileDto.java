package com.codegym.dto.request;

import com.codegym.model.user.User;
import org.springframework.validation.Errors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;
import java.util.Objects;

public class UpdateProfileDto {

    private Integer id;
    @NotBlank(message = "Vui lòng nhập họ và tên.")
    private String name;
    @NotBlank(message = "Vui lòng nhập email.")
    @Pattern(regexp = "^\\w+@gmail.com",message = "Email không đúng định dạng.")

    private String email;
    @NotBlank(message = "Vui lòng nhập địa chỉ.")
    private String address;
    @NotBlank(message = "Vui lòng nhập số điện thoại.")
    @Pattern(regexp = "^0[0-9]{9}$",message = "Số điện thoại không đúng định dạng")
    private String phoneNumber;
    @NotNull(message = "Vui lòng chọn giới tính.")
    private Boolean gender;
    @NotBlank(message = "Vui lòng nhập ngày sinh.")
    private String dateOfBirth;

    public UpdateProfileDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void validate(List<User> list, UpdateProfileDto updateProfileDto, Errors errors) {
        for (User user : list) {
            if (Objects.equals(user.getId(), updateProfileDto.id)) {
                continue;
            }
            if (Objects.equals(user.getEmail(), updateProfileDto.getEmail())) {
                errors.rejectValue("email", "email", "Email đã được sử dụng.");
            }
            if (Objects.equals(user.getPhoneNumber(), updateProfileDto.getPhoneNumber())) {
                errors.rejectValue("phoneNumber", "phoneNumber", "Số điện thoại tồn tại.");
            }
        }

    }
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
