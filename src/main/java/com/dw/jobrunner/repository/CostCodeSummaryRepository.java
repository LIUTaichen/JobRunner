package com.dw.jobrunner.repository;

import com.dw.jobrunner.model.CostCodeSummary;
import com.dw.jobrunner.model.CostCodeSummaryId;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CostCodeSummaryRepository extends CrudRepository<CostCodeSummary, CostCodeSummaryId> {

    public List<CostCodeSummary> findAll();
}
