package com.dw.jobrunner.repository;

import com.dw.jobrunner.model.ProjectCostArchive;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProjectCostArchiveRepository extends CrudRepository<ProjectCostArchive, Integer> {
    //public List<ProjectCostArchive> listAll();
}
