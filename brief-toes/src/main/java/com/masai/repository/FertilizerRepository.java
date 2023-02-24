package com.masai.repository;

import com.masai.model.Fertilizer;
import com.masai.model.FertilizerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FertilizerRepository extends JpaRepository<Fertilizer,Integer> {

      public List<Fertilizer> findByCommonName(String commonName);

    public List<Fertilizer> findByFertilizerType(FertilizerType fertilizerType);

}
