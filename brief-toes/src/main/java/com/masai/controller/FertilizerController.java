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

    @PostMapping("/add")
    public ResponseEntity<Fertilizer> saveNewFertilizer(@Valid @RequestBody Fertilizer fertilizer)throws AdminException, FertilizerNotFoundException {
        Fertilizer savedFertilizer = null;
       
            savedFertilizer = fertilizerService.addFertilizer(fertilizer);
      

        return new ResponseEntity<Fertilizer>(savedFertilizer, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Fertilizer> updateFertilizer(@Valid @RequestBody Fertilizer fertilizer) throws AdminException, FertilizerNotFoundException {
        Fertilizer updatedFertilizer = null;
    
            updatedFertilizer = fertilizerService.updateFertilizer(fertilizer);
      
        return new ResponseEntity<Fertilizer>(updatedFertilizer, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{fertilizerId}")
    public ResponseEntity<Fertilizer> deleteFertilizer(@PathVariable Integer fertilizerId) throws AdminException,FertilizerNotFoundException{

        Fertilizer deletedFertilizer = null;

            deletedFertilizer = fertilizerService.deleteFertilizerById(fertilizerId);
     
        return new ResponseEntity<Fertilizer>(deletedFertilizer, HttpStatus.OK);
    }

    @PutMapping("admin/setFertilizerPrice/{id}/{price}")
    public ResponseEntity<Fertilizer> setFertilizerPriceByFertilizerIdHandler(@PathVariable Integer fertilizerId, @PathVariable Integer newPrice) throws AdminException,FertilizerNotFoundException {
        Fertilizer fertilizerPrice = null;

            fertilizerPrice = fertilizerService.changePriceOfFertilizer(fertilizerId,newPrice);
     
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
