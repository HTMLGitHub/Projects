package com.revature.service;

import com.revature.model.Speaker;
import com.revature.repository.HibernateSpeakerRepositoryImpl;
import com.revature.repository.SpeakerRepository;

import java.util.List;

public class SpeakerServiceImpl implements SpeakerService
{
    private SpeakerRepository repository = new HibernateSpeakerRepositoryImpl();

    @Override
    public List<Speaker> findAll()
    {
        return repository.findAll();
    }
}
