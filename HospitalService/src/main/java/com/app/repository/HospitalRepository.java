package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.Hospital;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Long>{

}
