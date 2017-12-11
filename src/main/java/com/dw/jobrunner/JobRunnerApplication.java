package com.dw.jobrunner;

import com.dw.jobrunner.service.ProjectCostArchiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Date;

@SpringBootApplication
public class JobRunnerApplication implements CommandLineRunner {

	@Autowired
	private ProjectCostArchiveService archiveService;

	public static void main(String[] args) {
		SpringApplication.run(JobRunnerApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		archiveService.performArchive(new Date());
	}
}
