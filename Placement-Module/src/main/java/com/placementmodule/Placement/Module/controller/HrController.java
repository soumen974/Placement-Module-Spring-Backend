package com.placementmodule.Placement.Module.controller;


import com.placementmodule.Placement.Module.model.HR;
import com.placementmodule.Placement.Module.repository.HRrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class HrController {

    @Autowired
    private HRrepository hRrepository;

    @PostMapping("/hr")
    HR newHR(@RequestBody HR newHR){
        return hRrepository.save(newHR);
    }

    @GetMapping("/hr")
    List<HR> getAllHR(){
        return hRrepository.findAll();
    }



//    @DeleteMapping("/usersdetails/{id}")
//    String deleteUser(@PathVariable Long id){
//        if(!userRepository.existsById(id)){
//            throw new UserNotFoundException(id);
//        }
//        userRepository.deleteById(id);
//        return "User with id "+id+"has been deleted sucessfully";
//
//    }
}
