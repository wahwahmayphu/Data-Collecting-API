package org.example.jobstreet_data_collecting_api.com.jobcollect.service;

import org.example.jobstreet_data_collecting_api.com.jobcollect.model.JobData;
import org.example.jobstreet_data_collecting_api.com.jobcollect.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    public List<JobData> getAllJobs() {
        return jobRepository.findAll();
    }

    public JobData saveJob(JobData jobData) {
        return jobRepository.save(jobData);
    }
}
