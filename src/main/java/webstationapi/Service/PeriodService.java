package webstationapi.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import webstationapi.Entity.Period;
import webstationapi.Repository.PeriodRepository;

import java.util.List;
import java.util.Optional;


public class PeriodService {
	
	@Autowired
    private PeriodRepository periodRepository;

    @Transactional
    public List<Period> getPeriods() {
        return this.periodRepository.findAll();
    }
    
    @Transactional
    public Optional<Period> findById(long id) {
    	return periodRepository.findById(id);
    }

}
