package webstationapi.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import webstationapi.Entity.Flt_Flat;
import webstationapi.Repository.FlatRepository;

import java.util.List;

@Service
public class FlatService {


    private final FlatRepository flatRepository;

    public FlatService(FlatRepository flatRepository) {
        super();
        this.flatRepository = flatRepository;
    }

    @Transactional
    public List<Flt_Flat> getFlats() {
        return this.flatRepository.findAll();
    }
}
