package com.tisp.job_application.job;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;

public interface JobRepository extends JpaRepository<Job,Long> {

}
