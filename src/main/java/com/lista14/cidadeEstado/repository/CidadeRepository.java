package com.lista14.cidadeEstado.repository;

import com.lista14.cidadeEstado.model.CidadeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<CidadeModel, Long> {
}
