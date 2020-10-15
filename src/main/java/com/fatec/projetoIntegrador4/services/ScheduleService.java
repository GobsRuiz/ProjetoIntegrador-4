package com.fatec.projetoIntegrador4.services;

import java.util.List;

import com.fatec.projetoIntegrador4.models.Schedule;

public interface ScheduleService {
    
    // Get all data from the database
    List<Schedule> findAll();

    // Get the data from the table using the id field.
    Schedule findById(Long id);

    // Register
    Schedule save(Schedule schedule);

    // Delete
    void delete(Long id);
}
