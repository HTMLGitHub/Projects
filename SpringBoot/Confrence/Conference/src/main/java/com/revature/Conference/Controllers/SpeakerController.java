package com.revature.Conference.Controllers;

import com.revature.Conference.Models.Speakers;
import com.revature.Conference.Repositories.SpeakerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/speakers")
public class SpeakerController
{
    @Autowired
    private SpeakerRepository speakerRepository;

    @GetMapping
    public List<Speakers> list()
    {
        return speakerRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Speakers get(@PathVariable Long id)
    {
        return speakerRepository.getOne(id);
    }

    @PostMapping
    //@ResponseStatus(HttpStatus.CREATED)
    public Speakers create(@RequestBody final Speakers speaker)
    {
        return speakerRepository.saveAndFlush(speaker);
    }

    @RequestMapping(value="{id}", method= RequestMethod.DELETE)
    public void delete(@PathVariable Long id)
    {
        //Also need to check for children records before deleting.
        speakerRepository.deleteById(id);
    }

    @RequestMapping(value="{id}", method=RequestMethod.PUT)
    public Speakers update(@PathVariable Long id, @RequestBody Speakers speaker)
    {
        //because this is a PUT, we expect all attributes to be passed in. (A 'PATCH' would only need what is being updated)
        //TODO..Add validation that all attributes are passed in, otherwise return a 400 bad payload
        Speakers existingSpeaker = speakerRepository.getOne(id);
        BeanUtils.copyProperties(speaker, existingSpeaker, "speaker_id");
        return speakerRepository.saveAndFlush(existingSpeaker);
    }

}
