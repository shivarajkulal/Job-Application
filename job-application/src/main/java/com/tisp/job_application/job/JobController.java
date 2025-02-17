package com.tisp.job_application.job;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/jobs")
public class  JobController {

    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }
    // GET /jobs: Get all jobs
    //@GetMapping("/jobs")
    @GetMapping
    public ResponseEntity<List<Job>> findAll(){
        //return new ResponseEntity<>(jobService.findAll(),HttpStatus.OK);
        return ResponseEntity.ok(jobService.findAll());
    }

    //POST /jobs: Create new job (request body should contain job details)
    //@PostMapping("/jobs")
    @PostMapping
    public ResponseEntity<String> CreateJob(@RequestBody Job job){
        jobService.createJob(job);
        return new ResponseEntity<>("Job created successfully",HttpStatus.CREATED);
    }

    //GET /jobs/{id}: Get a specific job by ID
    //@GetMapping("/jobs/{id}")
    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id){
        Job job = jobService.getJobById(id);
        if(job!=null){
            return new ResponseEntity<>(job,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //DELETE /jobs/{id}: Delete a specific job by ID
    //@DeleteMapping("/jobs/{id}")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable Long id){
        boolean deleted = jobService.deleteJobById(id);
        if(deleted)
            return new ResponseEntity<>("Job deleted successfully",HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //PUT /jobs/{id}: Update a specific job by ID (Request body should contains updated job details)
    //@PutMapping("/jobs/{id}")
    @PutMapping("/{id}")
    //Alternative approach
    //@RequestMapping(value="/jobs/{id}", method=RequestMethod.PUT)
    public ResponseEntity<String> updateJob(@PathVariable Long id,
                                            @RequestBody Job updatedJob){
        boolean updated = jobService.updateJob (id,updatedJob);
        if(updated)
            return new ResponseEntity<>("Job updated successfully", HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
