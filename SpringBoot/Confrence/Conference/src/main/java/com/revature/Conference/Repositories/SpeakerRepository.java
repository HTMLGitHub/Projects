package com.revature.Conference.Repositories;

import com.revature.Conference.Models.Speakers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeakerRepository extends JpaRepository<Speakers, Long>{}
