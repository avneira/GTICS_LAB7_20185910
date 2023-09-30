package com.example.gtics_lab7_20185910.Repository;


import com.example.gtics_lab7_20185910.entity.Technician;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnicianRepository extends JpaRepository<Technician,Integer> {
}