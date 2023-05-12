package com.codegym.controller;

import com.codegym.dto.request.AvatarDto;
import com.codegym.dto.request.SignInForm;
import com.codegym.dto.request.SignUpForm;
import com.codegym.dto.request.UpdateProfileDto;
import com.codegym.dto.response.JwtResponse;
import com.codegym.dto.response.ResponseMessage;
import com.codegym.model.product.Product;
import com.codegym.model.user.Role;
import com.codegym.model.user.User;
import com.codegym.security.jwt.JwtProvider;
import com.codegym.security.userPrintcipcal.UserPrinciple;
import com.codegym.service.IRoleService;
import com.codegym.service.IUserService;
import com.codegym.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@RequestMapping("/api/auth")
@RestController
@CrossOrigin("*")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtProvider jwtProvider;
    @Autowired
    private IUserService iUserService;
    @Autowired
    private IRoleService iRoleService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    public ResponseEntity<?> register(@Valid @RequestBody SignUpForm signUpForm, BindingResult bindingResult) {
        new SignUpForm().validate(iUserService.findAll(), signUpForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.BAD_REQUEST);
        }
        if (iUserService.existsByUsername(signUpForm.getUsername())) {
            return new ResponseEntity<>(new ResponseMessage("Tên đăng " + signUpForm.getUsername() + " nhập đã được sử dụng, vui lòng chọn tên khác"), HttpStatus.BAD_REQUEST);
        }
        if (iUserService.existsByEmail(signUpForm.getEmail())) {
            return new ResponseEntity<>(new ResponseMessage("Email " + signUpForm.getEmail() + " đã được sử dụng"), HttpStatus.BAD_REQUEST);
        }
        User user = new User(signUpForm.getName(), signUpForm.getUsername(), passwordEncoder.encode(signUpForm.getPassword()), signUpForm.getEmail());
        Set<String> strRoles = signUpForm.getRoles();
        Set<Role> roles = new HashSet<>();
        strRoles.forEach(role -> {
            switch (role) {
                case "admin":
                    Role roleAdmin = iRoleService.roleAdmin().orElseThrow(() -> new RuntimeException("Role not found 1"));
                    roles.add(roleAdmin);
                    break;
                case "employee":
                    Role roleEmployee = iRoleService.roleEmployee().orElseThrow(() -> new RuntimeException("Role not found 2"));
                    roles.add(roleEmployee);
                    break;
                default:
                    Role roleCustomer = iRoleService.roleCustomer().orElseThrow(() -> new RuntimeException("Role not found 3"));
                    roles.add(roleCustomer);
            }
        });
        user.setRoles(roles);
        iUserService.save(user);
        return new ResponseEntity<>(new ResponseMessage("Đăng kí thành công"), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody SignInForm signInForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.BAD_REQUEST);
        }
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInForm.getUsername(), signInForm.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtProvider.createToken(authentication);
        UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal();
        return ResponseEntity.ok(new JwtResponse(token, userPrinciple.getName(), userPrinciple.getId(), userPrinciple.getUsername(), userPrinciple.getEmail(), userPrinciple.getPassword(), userPrinciple.getAvatar()
                , userPrinciple.getPhoneNumber(),
                userPrinciple.getAddress(),
                userPrinciple.getGender(),
                userPrinciple.getDateOfBirth()
                , userPrinciple.getAuthorities()));
    }

    @PreAuthorize("hasAnyRole('ADMIN','EMPLOYEE','CUSTOMER')")
    @GetMapping("/profile/{id}")
    public ResponseEntity<?> profile(@PathVariable("id") int id) {
        return new ResponseEntity<>(iUserService.findById(id), HttpStatus.ACCEPTED);
    }

    @PreAuthorize("hasAnyRole('ADMIN','EMPLOYEE','CUSTOMER')")
    @PostMapping("/avatar")
    public ResponseEntity<?> changeAvatar(@RequestBody AvatarDto avatarDto) {
        User user = iUserService.findById(avatarDto.getId());
        assert user != null;
        user.setAvatar(avatarDto.getAvatar());
        iUserService.save(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

        @PreAuthorize("hasAnyRole('ADMIN','EMPLOYEE','CUSTOMER')")
    @PostMapping("/update")
    public ResponseEntity<?> updateProfile(@Valid @RequestBody UpdateProfileDto profileDto, BindingResult bindingResult) {
        new UpdateProfileDto().validate(iUserService.findAll(),profileDto,bindingResult);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.BAD_REQUEST);
        }
        User user = iUserService.findById(profileDto.getId());
            assert user != null;
            user.setId(profileDto.getId());
            user.setAddress(profileDto.getAddress());
            user.setName(profileDto.getName());
            user.setEmail(profileDto.getEmail());
            user.setPhoneNumber(profileDto.getPhoneNumber());
            user.setDateOfBirth(profileDto.getDateOfBirth());
            user.setGender(profileDto.getGender());
            iUserService.save(user);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
