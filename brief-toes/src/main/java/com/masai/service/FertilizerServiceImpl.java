package com.masai.service;

import com.masai.exceptions.FertilizerNotFoundException;
import com.masai.model.Fertilizer;
import com.masai.model.FertilizerType;
import com.masai.repository.FertilizerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FertilizerServiceImpl implements FertilizerService {

    @Autowired
    private FertilizerRepository fRepo;

    @Override
    public Fertilizer addFertilizer(Fertilizer fertilizer) throws FertilizerNotFoundException {
        if(fRepo.findById(fertilizer.getFertilizerId()).isPresent()){
            throw new FertilizerNotFoundException("Fertilizer already exists with this Id");
        }else{
            Fertilizer fertilizer1=fRepo.save(fertilizer);
            return fertilizer1;
        }
    }

    @Override
    public Fertilizer updateFertilizer(Fertilizer fertilizer) throws FertilizerNotFoundException {
        Optional<Fertilizer> optional=fRepo.findById(fertilizer.getFertilizerId());
        if(optional.isPresent()){
            return fRepo.save(fertilizer);
        }else{
            throw new FertilizerNotFoundException("No Fertilizer found with this Id");
        }
    }

    @Override
    public Fertilizer deleteFertilizerById(Integer fertilizerId) throws FertilizerNotFoundException {
        Optional<Fertilizer> optional=fRepo.findById(fertilizerId);
        if(optional.isPresent()){
            Fertilizer fertilizer=optional.get();
            fRepo.delete(fertilizer);
            return fertilizer;
        }else{
            throw new FertilizerNotFoundException("No Fertilizer found with this Id");
        }
    }

    @Override
    public Fertilizer changePriceOfFertilizer(Integer fertilizerId, Integer newPrice) throws FertilizerNotFoundException {
        Optional<Fertilizer> optional=fRepo.findById(fertilizerId);
        if(optional.isPresent()){
            Fertilizer fertilizer=optional.get();
            fertilizer.setFertilizerCost(newPrice);
            fRepo.save(fertilizer);
            return fertilizer;
        }else{
            throw new FertilizerNotFoundException("No Fertilizer found with this Id");
        }
    }

    @Override
    public Fertilizer viewFertilizerById(Integer fertilizerId) throws FertilizerNotFoundException {
        Optional<Fertilizer> optional=fRepo.findById(fertilizerId);
        if(optional.isPresent()){
            return optional.get();
        }else{
            throw new FertilizerNotFoundException("No Fertilizer found with this Id");
        }
    }

    @Override
    public List<Fertilizer> viewAllFertilizer() throws FertilizerNotFoundException {
        List<Fertilizer> list=fRepo.findAll();
        if(list.isEmpty()){
            throw new FertilizerNotFoundException("No Fertilizer found....");
        }else {
            return list;
        }
    }

    @Override
    public List<Fertilizer> viewFertilizerByName(String name) throws FertilizerNotFoundException {
        List<Fertilizer> list=fRepo.findByCommonName(name);
        if(list.isEmpty()){
            throw new FertilizerNotFoundException("No such Fertilizer exists");
        }else {
            return list;
        }
    }

    @Override
    public List<Fertilizer> viewFertilizerByType(FertilizerType fertilizerType) throws FertilizerNotFoundException {
        List<Fertilizer> list=fRepo.findByFertilizerType(fertilizerType);
        if(list.isEmpty()){
            throw new FertilizerNotFoundException("No such Fertilizer exists");
        }else {
            return list;
        }
    }
}
