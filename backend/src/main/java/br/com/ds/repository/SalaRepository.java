package br.com.ds.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ds.model.Sale;

public interface SalaRepository extends JpaRepository<Sale, Integer>{

}
