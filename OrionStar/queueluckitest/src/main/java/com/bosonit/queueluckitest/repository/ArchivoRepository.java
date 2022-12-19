package com.bosonit.queueluckitest.repository;

import com.bosonit.queueluckitest.model.Archivo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArchivoRepository extends JpaRepository<Archivo, Integer> {
}
