package com.masai.service;

import com.masai.exceptions.FertilizerNotFoundException;
import com.masai.model.Fertilizer;
import com.masai.model.FertilizerType;

import java.util.List;

public interface FertilizerService {
    public Fertilizer addFertilizer(Fertilizer fertilizer) throws FertilizerNotFoundException;

    public Fertilizer updateFertilizer(Fertilizer fertilizer) throws FertilizerNotFoundException;

    public Fertilizer deleteFertilizerById(Integer fertilizerId) throws FertilizerNotFoundException;

    public Fertilizer changePriceOfFertilizer(Integer fertilizerId,Integer newPrice) throws FertilizerNotFoundException;

    public Fertilizer viewFertilizerById(Integer fertilizerId) throws FertilizerNotFoundException;

    public List<Fertilizer> viewAllFertilizer() throws FertilizerNotFoundException;

    public List<Fertilizer> viewFertilizerByName(String name) throws FertilizerNotFoundException;

    public List<Fertilizer> viewFertilizerByType(FertilizerType fertilizerType) throws FertilizerNotFoundException;
}
