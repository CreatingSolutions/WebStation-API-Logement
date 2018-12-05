package webstationapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import webstationapi.Entity.Period;

public interface PeriodRepository extends JpaRepository<Period, Long> {

}
