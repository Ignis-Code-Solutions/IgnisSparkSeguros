package com.generation.ignisspark.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.ignisspark.model.Apolice;

@Repository
public interface ApoliceRepository extends JpaRepository <Apolice, Long> {

}
