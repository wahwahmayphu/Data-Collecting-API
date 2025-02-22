package org.example.jobstreet_data_collecting_api.com.jobcollect.repository;

import org.example.jobstreet_data_collecting_api.com.jobcollect.model.JobData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<JobData, Long> {
}
