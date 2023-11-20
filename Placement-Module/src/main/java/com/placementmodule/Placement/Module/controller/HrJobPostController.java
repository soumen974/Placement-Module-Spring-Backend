package com.placementmodule.Placement.Module.controller;

import com.placementmodule.Placement.Module.model.HrJobPost;
import com.placementmodule.Placement.Module.repository.HrJobPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:3000")
public class HrJobPostController {

    @Autowired
    private HrJobPostRepository hrJobPostRepository;

    @PostMapping("/hr/jobpost")
    HrJobPost newHrJobPost(@RequestBody HrJobPost newHrJobPost){

        return hrJobPostRepository.save(newHrJobPost);
    }

    @GetMapping("/hr/jobpost")
    List<HrJobPost>getAllHrJobPost(){
        return hrJobPostRepository.findAll();
    }

    @GetMapping("/hr/jobpost/{id}")
    public ResponseEntity<HrJobPost> getHrJobPostById(@PathVariable Long id) {
        Optional<HrJobPost> hrJobPost = hrJobPostRepository.findById(id);

        if (hrJobPost.isPresent()) {
            return ResponseEntity.ok(hrJobPost.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/hr/jobpost/{id}")
    public ResponseEntity<HrJobPost> updateHrJobPost(
            @PathVariable Long id,
            @RequestBody HrJobPost updatedHrJobPost) {
        Optional<HrJobPost> optionalHrJobPost = hrJobPostRepository.findById(id);
        if (optionalHrJobPost.isPresent()) {
            HrJobPost existingHrJobPost = optionalHrJobPost.get();
            // Update the existingHrJobPost with the new data
            existingHrJobPost.setTitle(updatedHrJobPost.getTitle());
            existingHrJobPost.setDescription(updatedHrJobPost.getDescription());
            // Update other fields similarly

            HrJobPost savedHrJobPost = hrJobPostRepository.save(existingHrJobPost);
            return ResponseEntity.ok(savedHrJobPost);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/hr/jobpost/{id}")
    public ResponseEntity<String> deleteHrJobPost(@PathVariable Long id) {
        Optional<HrJobPost> hrJobPost = hrJobPostRepository.findById(id);
        if (hrJobPost.isPresent()) {
            hrJobPostRepository.deleteById(id);
            return ResponseEntity.ok("Deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
