package com.revature.repository;
import com.revature.model.Speaker;
import java.util.ArrayList;
import java.util.List;

public class HibernateSpeakerRepositoryImpl implements SpeakerRepository
{
    public List<Speaker> findAll()
    {
       List<Speaker> speakers = new ArrayList<Speaker>();

        Speaker speaker  = new Speaker();

        speaker.setFirstName("Matthew");
        speaker.setLastName("Lee");

        speakers.add(speaker);

        return speakers;
    }
}
