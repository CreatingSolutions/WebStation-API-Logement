package webstationapi.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import webstationapi.Entity.Period;
import webstationapi.Exception.WebStationException;
import webstationapi.Repository.PeriodRepository;

import java.util.List;

@Service
public class PeriodService {
	
	@Autowired
    private PeriodRepository periodRepository;

    @Transactional
    public List<Period> getPeriods() {
        return this.periodRepository.findAll();
    }
    
    @Transactional
    public Period findById(long id) {
    	return periodRepository.findById(id).orElseThrow(() -> new WebStationException("[LOGEMENT] Aucune période trouvée pour l'identifiant"));
    }

}
