package com.fatec.projetoIntegrador4.repository;

import com.fatec.projetoIntegrador4.models.Schedule;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long>{
    
}
