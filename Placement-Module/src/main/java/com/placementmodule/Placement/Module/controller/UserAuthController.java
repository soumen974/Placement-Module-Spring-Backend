package com.placementmodule.Placement.Module.controller;

import com.placementmodule.Placement.Module.model.UserAuth;
import com.placementmodule.Placement.Module.repository.UserAuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserAuthController {

    @Autowired
    private UserAuthRepository userAuthRepository;

    @PostMapping("/userentry")
    UserAuth newUserAuth(@RequestBody UserAuth newUserAuth){
        return userAuthRepository.save(newUserAuth);
    }

    @GetMapping("/userentry123")
    List<UserAuth>getAllUserAuth(){
        return userAuthRepository.findAll();
    }

}
