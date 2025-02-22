package org.example.jobstreet_data_collecting_api.com.jobcollect.Controller;

import org.example.jobstreet_data_collecting_api.com.jobcollect.model.JobData;
import org.example.jobstreet_data_collecting_api.com.jobcollect.service.JobScraperService;
import org.example.jobstreet_data_collecting_api.com.jobcollect.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/jobs")
public class JobController {

    @Autowired
    private JobService jobService;

    @Autowired
    private JobScraperService jobScraperService;

    // Display all jobs
    @GetMapping
    public String getAllJobs(Model model) {
        List<JobData> jobList = jobService.getAllJobs();
        model.addAttribute("jobs", jobList);
        return "jobs"; // Renders jobs.html
    }

    // Fetch jobs from JobStreet and save
    @GetMapping("/fetch")
    public String fetchJobs() {
        List<JobData> jobDataList = jobScraperService.scrapeJobs();
        for (JobData jobData : jobDataList) {
            jobService.saveJob(jobData);
        }
        return "redirect:/jobs";
    }
}
