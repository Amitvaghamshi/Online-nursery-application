package com.masai.service;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.PlantException;
import com.masai.exceptions.PlanterException;
import com.masai.exceptions.SeedException;
import com.masai.model.Plant;
import com.masai.model.Planter;
import com.masai.model.Seed;
import com.masai.repository.PlantRepository;
import com.masai.repository.PlanterRepository;
import com.masai.repository.SeedRepository;



@Service
public class CustomerServiceImpl implements CustomerService{
	

	@Autowired
	private PlanterRepository planterRepository;
	
	@Autowired
	private SeedRepository seedRepository;
	
	@Autowired
	private PlantRepository planRrepository;
	

	@Override
	public List<Plant> getAllPlants() throws PlantException {
		List<Plant> plants=planRrepository.findAll();
		
		if(plants.isEmpty()) {
			throw new PlantException("plant Not found");
		}
		return plants;
	}

	@Override
	public List<Seed> getAllSeeds() throws SeedException {
        List<Seed> plants=seedRepository.findAll();
		if(plants.isEmpty()) {
			throw new SeedException("Seeds Not found");
		}
		return plants;
	}

	@Override
	public List<Planter> getAllPlanters() throws PlanterException {
        List<Planter> plants=planterRepository.findAll();
		if(plants.isEmpty()) {
			throw new PlanterException("plant Not found");
		}
		return plants;
	}
	
	//   ==>  1)  getSortedPlantByHeightOrWidth   start
	
	                  
	public Comparator<Plant> byheight=new Comparator<Plant>(){
		@Override
		public int compare(Plant o1, Plant o2) {
			 if(o1.getPlantHeight()>o2.getPlantHeight()){
				 return 1;
			 }else {
				 return -1;
			 }
		}
		
	};
	
	
		public Comparator<Plant> bywidth=new Comparator<Plant>(){

			@Override
			public int compare(Plant o1, Plant o2) {
				 if(o1.getPlantSpread().compareTo(o2.getPlantSpread())>1){
					 return 1;
				 }else {
					 return -1;
				 }
			}
		};
		




	@Override
	public List<Plant> getSortedPlantByHeightOrWidth( Integer pagesize, Integer pageNo, String sortby) throws PlantException {
		
		List<Plant> lis=new ArrayList<>();
        List<Plant> all=planRrepository.findAll();
		
		//    Sortin algo      ==>>>>>>>.
		
		Comparator<Plant> comp=null;
		if(sortby.equals("byheight")) {
			comp=byheight;
		}else if(sortby.equals("bywidth")) {
			comp=bywidth;
		}else {
			throw new PlantException("Wrong sort by parameter");
		}
		
		Collections.sort(all,comp);
		// =====>     <=========
		
		Integer totalpage=(int)(Math.ceil((float)all.size()/pagesize));
		
		System.out.println(totalpage);
		if(totalpage<pageNo) {
			throw new PlantException("plant Not found at page "+pageNo);
		}
		
		int start =pagesize*(pageNo-1);
		int end =pagesize*(pageNo-1)+pagesize;
		
		
		for(int i=start;i<end;i++) {
			
			if(i>=all.size()) {
				break;
			}
			lis.add(all.get(i));
		}
		
		System.out.println(start+" "+end);
		
		return lis;
	}

	
	
	//   2)   getSortedPlanterByHeightOrCapacity
	
	
	public Comparator<Planter> planterbyheight=new Comparator<Planter>(){
		@Override
		public int compare(Planter o1, Planter o2) {
			 if(o1.getPlanterHeight()>o2.getPlanterHeight()){
				 return 1;
			 }else {
				 return -1;
			 }
		}
		
	};
	
	
		public Comparator<Planter> planterbycapacity=new Comparator<Planter>(){

			@Override
			public int compare(Planter o1, Planter o2) {
				 if(o1.getPlanterCapacity()>o2.getPlanterCapacity()){
					 return 1;
				 }else {
					 return -1;
				 }
			}
		};
	
	@Override
	public List<Planter> getSortedPlanterByHeightOrCapacity(Integer pagesize, Integer pageNo, String sortby)
			throws PlanterException {
		
		List<Planter> lis=new ArrayList<>();
        List<Planter> all=planterRepository.findAll();
		
		//    Sortin algo      ==>>>>>>>.
		
		Comparator<Planter> comp=null;
		if(sortby.equals("byheight")) {
			comp=planterbyheight;
		}else if(sortby.equals("bycapacity")) {
			comp=planterbycapacity;
		}else {
			throw new PlanterException("Wrong sort by parameter");
		}
		
		Collections.sort(all,comp);
		// =====>     <=========
		
		Integer totalpage=(int)(Math.ceil((float)all.size()/pagesize));
		
		System.out.println(totalpage);
		if(totalpage<pageNo) {
			throw new PlanterException("planter Not found at page "+pageNo);
		}
		
		int start =pagesize*(pageNo-1);
		int end =pagesize*(pageNo-1)+pagesize;
		
		
		for(int i=start;i<end;i++) {
			
			if(i>=all.size()) {
				break;
			}
			lis.add(all.get(i));
		}
		
		System.out.println(start+" "+end);
		
		return lis;
	}
	
	
	//   3)     getSortedSeedByBloomOrWater
	
	public Comparator<Seed> seedBloom=new Comparator<Seed>(){
		@Override
		public int compare(Seed o1, Seed o2) {
			 if(o1.getBloomTime().compareTo(o2.getBloomTime())>1){
				 return 1;
			 }else {
				 return -1;
			 }
		}
		
	};
	
	
		public Comparator<Seed> seedWater=new Comparator<Seed>(){

			@Override
			public int compare(Seed o1, Seed o2) {
				 if(o1.getWatering().compareTo(o2.getWatering())>1){
					 return 1;
				 }else {
					 return -1;
				 }
			}
		};
	

	@Override
	public List<Seed> getSortedSeedByBloomOrWater(Integer pagesize, Integer pageNo, String sortby)
			throws SeedException {
		List<Seed> lis=new ArrayList<>();
        List<Seed> all=seedRepository.findAll();
		
		//    Sortin algo      ==>>>>>>>.
		
		Comparator<Seed> comp=null;
		if(sortby.equals("bybloom")) {
			comp=seedBloom;
		}else if(sortby.equals("bywater")) {
			comp=seedWater;
		}else {
			throw new SeedException("Wrong sort by parameter");
		}
		
		Collections.sort(all,comp);
		// =====>     <=========
		
		Integer totalpage=(int)(Math.ceil((float)all.size()/pagesize));
		
		System.out.println(totalpage);
		if(totalpage<pageNo) {
			throw new SeedException("Seed Not found at page "+pageNo);
		}
		
		int start =pagesize*(pageNo-1);
		int end =pagesize*(pageNo-1)+pagesize;
		
		
		for(int i=start;i<end;i++) {
			
			if(i>=all.size()) {
				break;
			}
			lis.add(all.get(i));
		}
		
		System.out.println(start+" "+end);
		
		return lis;
	}
	
	

	
}