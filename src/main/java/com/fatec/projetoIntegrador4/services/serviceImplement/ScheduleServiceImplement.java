package com.fatec.projetoIntegrador4.services.serviceImplement;

import java.util.List;

import com.fatec.projetoIntegrador4.models.Schedule;
import com.fatec.projetoIntegrador4.repository.ScheduleRepository;
import com.fatec.projetoIntegrador4.services.ScheduleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleServiceImplement implements ScheduleService{
    
    @Autowired
    private ScheduleRepository repository;

    @Override
    public List<Schedule> findAll() {
        
        return repository.findAll();
    }

    @Override
    public Schedule findById(Long id) {
        
        return repository.findById(id).get();
    }

    @Override
    public Schedule save(Schedule schedule) {
        
        return repository.save(schedule);
    }

    @Override
    public void delete(Long id) {
		repository.deleteById(id);
	}
}
