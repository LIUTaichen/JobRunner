package com.dw.jobrunner.service;

import com.dw.jobrunner.repository.PlantRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

@Service

public class SchedulerService {

    private static final Logger log = LoggerFactory.getLogger(SchedulerService.class);

    @Autowired
    private ProjectCostArchiveService archiveService;

    /*@Scheduled(cron="0 * * *  * MON-FRI", zone="NZ")
    public void generateDailyLoadCountReport() {
        log.info("running scheduled synchronization");
        //plantRepository.archiveProjectCost();
        log.info("scheduled synchronization finished");
    }*/
    @Scheduled(cron="0 0 1 *  * *", zone="NZ")
    public void scheduledArchival() {
        log.info("running scheduled archival");
        archiveService.performArchive(new Date());
        log.info("scheduled archival finished");


    }



}
