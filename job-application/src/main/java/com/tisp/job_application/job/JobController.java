package com.tisp.job_application.job;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class JobController {

    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }
    // GET /jobs: Get all jobs
    @GetMapping("/jobs")
    public List<Job> findAll(){
        return jobService.findAll();
    }

    //POST /jobs: Create new job (request body should contain job details)
    @PostMapping("/jobs")
    public String CreateJob(@RequestBody Job job){
        jobService.createJob(job);
        return "Job Added Successfully";
    }

//    //GET /jobs/{id}: Get a specific job by ID
//    public Job getJobById(){
//
//    }
}
