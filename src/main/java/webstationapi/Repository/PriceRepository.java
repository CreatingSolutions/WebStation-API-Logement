package webstationapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import webstationapi.Entity.Price;

public interface PriceRepository extends JpaRepository<Price, Long[]> {
    @Query("SELECT p FROM Price p WHERE p.id_period = :idPeriod AND p.id_flat = :idFlat")
    Price computePrice(@Param("idPeriod") Long idPeriod, @Param("idFlat") Long idFlat);
}
