package com.revature.repository;

import com.revature.model.Speaker;

import java.util.List;

public interface SpeakerRepository
{
    public List<Speaker> findAll();
}
