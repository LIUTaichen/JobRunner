package com.dw.jobrunner.repository;

import com.dw.jobrunner.model.ActionLog;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ActionLogRepository extends CrudRepository<ActionLog, Integer> {
    public List<ActionLog> findAll();

    public List<ActionLog> findByEntity(String entityString);

    public List<ActionLog> findByEntityAndAction(String entityString, String action);
}
