package com.example.obspringdatajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Esta anotación hace que Spring haga un bean de esta interfaz
@Repository
public interface CocheRepository extends JpaRepository<Coche, Long> {

}
