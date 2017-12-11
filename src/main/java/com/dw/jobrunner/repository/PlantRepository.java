package com.dw.jobrunner.repository;

import com.dw.jobrunner.model.Plant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.RepositoryDefinition;


public interface PlantRepository extends CrudRepository<Plant, Integer> {

    @Query(value = "USE [db_a2c66089_8166_48a5_9693_418e00323176]; DECLARE @DaysDiff int = -1 -- -1 is yesterday, 0 is today; DECLARE @dateToArchive date = dateadd(day,@DaysDiff,getdate()); SELECT @dateToArchive as [report_date]          ,[cost_code_pk]          ,[plant_pk]          ,[Unit_Cost]          ,[Units]          ,getdate() as [date_created]          ,cast(DateAdd(Day,Choose(DatePart(Weekday,@dateToArchive),0,6,5,4,3,2,1),@dateToArchive) as date) as [reporting_week]          ,iif (DatePart(Weekday,@dateToArchive)=7, 0.5,iif (DatePart(Weekday,@dateToArchive)=1, 0,1)) as [units_used]          ,[project_pk]   FROM [Access].[qCostCodeSummary];", nativeQuery = true)
    public void archiveProjectCost();
    
}
