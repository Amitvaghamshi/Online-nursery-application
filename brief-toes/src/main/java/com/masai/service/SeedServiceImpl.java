package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.SeedException;
import com.masai.model.Seed;
import com.masai.repository.SeedRepository;


@Service
public class SeedServiceImpl implements SeedService {

	@Autowired
	private SeedRepository seedRepo;
	
	@Override
	public Seed addSeed(Seed seed) throws SeedException {
		
		 Seed savedSeed = seedRepo.save(seed);
		
		 if(savedSeed==null) throw new SeedException("Can't add this seed");
			
		 else return savedSeed;
		
	}
	
	
	@Override
	public Seed updateSeed(Seed seed) throws SeedException {
		
		Integer seedId = seed.getSeedId();
		
		Optional<Seed> found = seedRepo.findById(seedId);		
		
		if(found.isPresent()) {
			return seedRepo.save(seed);
		}
		else
			throw  new SeedException("Cannot Update, No such Seed present ");		
	}
	
	
	
	@Override
	public Seed deleteSeed(Integer seedId) throws SeedException {
		
		Optional<Seed> found = seedRepo.findById(seedId);		
		
		if(found.isPresent()) {
			Seed seedfound = found.get();
			seedRepo.delete(seedfound);
			return seedfound;
		}
		else
			throw  new SeedException("Cannot Delete this seed, No such Seed present ");
	}
	
	
	@Override
	public Seed viewSeed(int seedId) throws SeedException {
		
		
		Optional<Seed> found = seedRepo.findById(seedId);		
		
		return found.orElseThrow( ()-> new SeedException(
		"Unable to find Seed with id "+seedId));
	}
	
	
	
	@Override
	public List<Seed> viewSeed(String commonName) throws SeedException {
		List<Seed> seedListByCommonName;
		
		seedListByCommonName = seedRepo.findByCommonName(commonName);
		
		if(seedListByCommonName.size()!=0)
		return seedListByCommonName;
		else
		throw  new SeedException("Cannot find any seed by this common name ");
		
	}
	@Override
	public List<Seed> viewAllSeeds() throws SeedException {
		List<Seed> allSeeds;
		
		allSeeds = seedRepo.findAll();
		
		if(allSeeds.size()!=0)
		return allSeeds;
		else
		throw  new SeedException("We don't have any seeds in the database ");
	}
	@Override
	public List<Seed> viewAllSeeds(String typeOfSeed) throws SeedException {
		
		List<Seed> allSeedsByOneType;
		
		allSeedsByOneType = seedRepo.findByTypeOfSeeds(typeOfSeed);
		
		if(allSeedsByOneType.size()!=0)
		return allSeedsByOneType;
		else
		throw  new SeedException("We don't have this type of"+typeOfSeed+" in the database ");
		
	}
	

}
