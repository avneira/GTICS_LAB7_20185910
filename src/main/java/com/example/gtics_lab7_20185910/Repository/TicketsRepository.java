package com.example.gtics_lab7_20185910.Repository;

import com.example.gtics_lab7_20185910.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketsRepository extends JpaRepository<Ticket,Integer> {
}
