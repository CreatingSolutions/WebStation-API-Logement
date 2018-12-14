package webstationapi.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import webstationapi.Entity.Flat;
import webstationapi.Exception.WebStationException;
import webstationapi.Repository.FlatRepository;

@Service
public class FlatService {

	@Autowired
    private FlatRepository flatRepository;

    @Transactional
    public List<Flat> getFlats() {
        return this.flatRepository.findAll();
    }
    
    @Transactional
    public Flat findById(long id) {
    	return flatRepository.findById(id).orElseThrow(() -> new WebStationException("[LOGEMENT] Aucun appartement trouvé avec cet identifiant."));
    }
}
