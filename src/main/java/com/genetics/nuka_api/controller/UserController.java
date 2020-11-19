package com.genetics.nuka_api.controller;

import com.genetics.nuka_api.model.User;
import com.genetics.nuka_api.payload.JWTLoginSuccessResponse;
import com.genetics.nuka_api.payload.LoginRequest;
import com.genetics.nuka_api.repositiry.UserRepository;
import com.genetics.nuka_api.security.JWTTokenProvider;
import com.genetics.nuka_api.service.MapValidationServiceError;
import com.genetics.nuka_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.genetics.nuka_api.security.SecurityConstant.TOKEN_PREFIX;

@RequestMapping("api/v1/users")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    MapValidationServiceError mapValidationServiceError;

    @Autowired
    JWTTokenProvider tokenProvider;

    @Autowired
    AuthenticationManager authenticationManager;


    @GetMapping(path = "/getUsers")
    public Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }


    @PostMapping(path = "/createUser")
    public ResponseEntity<?> createNewUser(@Valid @RequestBody User user, BindingResult result){

        ResponseEntity<?> errorMap = mapValidationServiceError.MapValidationService(result);
        if(errorMap!= null) return errorMap;
        User user1 = userService.createUser(user);
        return new ResponseEntity<User>(user1, HttpStatus.CREATED);
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest, BindingResult result){
        ResponseEntity<?> errorMap = mapValidationServiceError.MapValidationService(result);
        if(errorMap != null) return errorMap;

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = TOKEN_PREFIX + tokenProvider.generateToken(authentication);

        return ResponseEntity.ok(new JWTLoginSuccessResponse(true, jwt));
    }
}