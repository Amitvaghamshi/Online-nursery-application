package com.masai.controller;

import com.masai.exceptions.AdminException;
import com.masai.exceptions.FertilizerNotFoundException;
import com.masai.model.Fertilizer;
import com.masai.model.FertilizerType;
import com.masai.service.FertilizerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fertilizer")
public class FertilizerController {

    @Autowired
    private FertilizerService fertilizerService;

    @PostMapping("/{adminID}/add")
    public ResponseEntity<Fertilizer> saveNewFertilizer(@Valid @RequestBody Fertilizer fertilizer, @PathVariable("adminID") Integer adminID)throws AdminException, FertilizerNotFoundException {
        Fertilizer savedFertilizer = null;
        if(adminID==1111||adminID==2222||adminID==3333||adminID==4444)
            savedFertilizer = fertilizerService.addFertilizer(fertilizer);
        else
            throw new AdminException("You are not an admin");

        return new ResponseEntity<Fertilizer>(savedFertilizer, HttpStatus.CREATED);
    }

    @PutMapping("/{adminID}/update")
    public ResponseEntity<Fertilizer> updateSeed(@Valid @RequestBody Fertilizer fertilizer, @PathVariable Integer adminID) throws AdminException, FertilizerNotFoundException {
        Fertilizer updatedFertilizer = null;
        if(adminID==1111||adminID==2222||adminID==3333||adminID==4444)
            updatedFertilizer = fertilizerService.updateFertilizer(fertilizer);
        else
            throw new AdminException("You are not an admin");
        return new ResponseEntity<Fertilizer>(updatedFertilizer, HttpStatus.CREATED);
    }

    @DeleteMapping("/{adminID}/delete/{fertilizerId}")
    public ResponseEntity<Fertilizer> deleteFertilizer(@PathVariable Integer fertilizerId, @PathVariable Integer adminID) throws AdminException,FertilizerNotFoundException{

        Fertilizer deletedFertilizer = null;

        if(adminID==1111||adminID==2222||adminID==3333||adminID==4444)
            deletedFertilizer = fertilizerService.deleteFertilizerById(fertilizerId);
        else
            throw new AdminException("You are not an admin");
        return new ResponseEntity<Fertilizer>(deletedFertilizer, HttpStatus.OK);
    }

    @PutMapping("admin/setFertilizerPrice/{id}/{price}/{adminId}")
    public ResponseEntity<Fertilizer> setFertilizerPriceByFertilizerIdHandler(@PathVariable Integer fertilizerId, @PathVariable Integer newPrice, @PathVariable Integer adminID) throws AdminException,FertilizerNotFoundException {
        Fertilizer fertilizerPrice = null;

        if(adminID==1111||adminID==2222||adminID==3333||adminID==4444)
            fertilizerPrice = fertilizerService.changePriceOfFertilizer(fertilizerId,newPrice);
        else
            throw new AdminException("You are not an admin");
        return new ResponseEntity<Fertilizer>(fertilizerPrice, HttpStatus.OK);
    }

    @GetMapping("/fertilizer/byID/{fertilizerId}")
    public ResponseEntity<Fertilizer> getSpecificFertilizer(@PathVariable Integer fertilizerId) throws FertilizerNotFoundException{

        Fertilizer specificFertilizer = fertilizerService.viewFertilizerById(fertilizerId);

        return new ResponseEntity<Fertilizer>(specificFertilizer, HttpStatus.OK);
    }

    @GetMapping("/fertilizer/{commonName}")
    public ResponseEntity<List<Fertilizer>> viewFertilizerByCommonName(@PathVariable String commonName) throws FertilizerNotFoundException{

        List<Fertilizer> fertilizerByCommonName = fertilizerService.viewFertilizerByName(commonName);

        return new ResponseEntity<List<Fertilizer>>(fertilizerByCommonName, HttpStatus.OK);
    }

    @GetMapping("/fertilizer/all")
    public ResponseEntity<List<Fertilizer>> viewAllFertilizer() throws FertilizerNotFoundException{

        List<Fertilizer> allFertilizer = fertilizerService.viewAllFertilizer();


        return new ResponseEntity<List<Fertilizer>>(allFertilizer, HttpStatus.OK);
    }

    @GetMapping("/fertilizer/all/{fertilizerType}")
    public ResponseEntity<List<Fertilizer>> viewAllFertilizerByTypeOfFertilizer(@PathVariable FertilizerType fertilizerType) throws FertilizerNotFoundException{
        List<Fertilizer> allFertilizer = fertilizerService.viewFertilizerByType(fertilizerType);

        return new ResponseEntity<List<Fertilizer>>(allFertilizer, HttpStatus.OK);
    }
}
