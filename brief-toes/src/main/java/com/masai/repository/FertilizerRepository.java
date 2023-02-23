package com.masai.repository;

import com.masai.model.Fertilizer;
import com.masai.model.FertilizerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FertilizerRepository extends JpaRepository<Fertilizer,Integer> {

    public List<Fertilizer> findByCommonName(String commonName);

}
