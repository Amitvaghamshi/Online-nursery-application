package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.masai.model.UserSession;

@Repository
public interface SessionRepository extends JpaRepository<UserSession, Integer>{

//	public  UserSession  findByUuid(String uuid);
	
	@Query("from UserSession where uuid=:uu")
	public  UserSession  findByuuid(@Param("uu") String uuid);
}
