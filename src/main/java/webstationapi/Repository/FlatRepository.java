package webstationapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import webstationapi.Entity.Flat;

public interface FlatRepository extends JpaRepository<Flat, Long> {

}
