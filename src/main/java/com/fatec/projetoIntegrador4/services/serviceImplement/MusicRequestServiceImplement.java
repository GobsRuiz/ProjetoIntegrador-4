package com.fatec.projetoIntegrador4.services.serviceImplement;

import java.util.List;

import com.fatec.projetoIntegrador4.models.MusicRequest;
import com.fatec.projetoIntegrador4.repository.MusicRequestRepository;
import com.fatec.projetoIntegrador4.services.MusicRequestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MusicRequestServiceImplement implements MusicRequestService{
    
    @Autowired
    private MusicRequestRepository repository;

    @Override
    public List<MusicRequest> findAll() {
        
        return repository.findAll();
    }

    @Override
    public MusicRequest findById(Long id) {
        
        return repository.findById(id).get();
    }

    @Override
    public MusicRequest save(MusicRequest musicRequest) {
        
        return repository.save(musicRequest);
    }

    @Override
    public void delete(Long id) {
		repository.deleteById(id);
	}
}
