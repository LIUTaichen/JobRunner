package com.dw.jobrunner.service;

import com.dw.jobrunner.model.ActionLog;
import com.dw.jobrunner.model.CostCodeSummary;
import com.dw.jobrunner.model.ProjectCostArchive;
import com.dw.jobrunner.repository.ActionLogRepository;
import com.dw.jobrunner.repository.CostCodeSummaryRepository;
import com.dw.jobrunner.repository.ProjectCostArchiveRepository;
import com.dw.jobrunner.util.DateTimeUtil;
import com.dw.jobrunner.util.UnitsUsedUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ProjectCostArchiveService {
    private static final Logger log = LoggerFactory.getLogger(ProjectCostArchiveService.class);

    @Autowired
    private ActionLogRepository actionLogRepository;

    @Autowired
    private ProjectCostArchiveRepository projectCostArchiveRepository;

    @Autowired
    private CostCodeSummaryRepository costCodeSummaryRepository;

    @Autowired
    private EmailService emailService;

    private static final String PROJECT_COST_ARCHIVE_ACTION = "projectCostArchive";

    @Transactional
    public void performArchive(Date targetDate){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        String entityString = sdf.format(targetDate);
        List<ActionLog> logs = actionLogRepository.findByEntityAndAction(entityString,PROJECT_COST_ARCHIVE_ACTION);
        log.info("number of logs for target date found  " + logs.size());
        Date dateCreated = new Date();
        if(!logs.isEmpty()){
            log.info("Action log found for target date " + targetDate + " , no more archival will be performed");
        }else{
            log.info("No action log found for target date " + targetDate + " , archival will be performed");
            List<CostCodeSummary> costCodes = costCodeSummaryRepository.findAll();
            log.info("Number of cost code entries found  " + costCodes.size());


            List<ProjectCostArchive> archiveEntries = new ArrayList<>();
            for(CostCodeSummary costCode : costCodes){
                ProjectCostArchive archiveEntry = new ProjectCostArchive();
                archiveEntry.setReportDate(targetDate);
                archiveEntry.setCostCodeFk(costCode.getCostCodePk());
                archiveEntry.setPlantFk(costCode.getPlantPk());
                archiveEntry.setUnitCost(costCode.getUnitCost());
                archiveEntry.setUnits(costCode.getUnits());
                archiveEntry.setActive(true);
                archiveEntry.setDateCreated(dateCreated);
                archiveEntry.setReportingWeek(DateTimeUtil.getEndOfWeekDate(targetDate));
                archiveEntry.setUnitsUsed(UnitsUsedUtil.getUnitsUsed(targetDate));
                archiveEntry.setProjectId(costCode.getProjectPk());

                archiveEntries.add(archiveEntry);
            }

            log.info("Number of archival entries to be inserted: " + archiveEntries.size());
            projectCostArchiveRepository.save(archiveEntries);

            ActionLog actionlog = new ActionLog();
            actionlog.setAction(PROJECT_COST_ARCHIVE_ACTION);
            actionlog.setRunDate(dateCreated);
            actionlog.setEntity(entityString);
            actionlog.setDateCreated(new Date());

            log.info("inserting action log " + actionlog.toString());
            actionLogRepository.save(actionlog);
            emailService.sendDailyArchivalEmail();
        }
    }



}
