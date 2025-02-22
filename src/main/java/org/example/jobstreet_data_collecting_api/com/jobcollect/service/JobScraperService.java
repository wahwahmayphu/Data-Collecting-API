package org.example.jobstreet_data_collecting_api.com.jobcollect.service;

import org.example.jobstreet_data_collecting_api.com.jobcollect.model.JobData;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class JobScraperService {
    public List<JobData> scrapeJobs() {
        String jobStreetUrl = "https://www.jobstreet.com"; // Replace with actual URL
        List<JobData> jobs = new ArrayList<>();

        Document document = null;
        try {
            document = Jsoup.connect(jobStreetUrl).get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Elements jobElements = document.select(".job-card"); // Adjust based on actual JobStreet structure

        for (Element jobElement : jobElements) {
            String companyName = jobElement.select(".company-name").text();
            String industrySector = jobElement.select(".industry-sector").text();
            String careerPageUrl = jobElement.select("a").attr("href");
            String email = "not_available@example.com"; // Email might not be available

            jobs.add(new JobData(null, companyName, industrySector, careerPageUrl, email));
        }

        return jobs;
    }
}
