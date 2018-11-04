package webstationapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;
import webstationapi.Entity.Flt_Flat;


public interface FlatRepository extends JpaRepository<Flt_Flat, Long> {


}
