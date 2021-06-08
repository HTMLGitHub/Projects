package com.revature.Conference.Repositories;

import com.revature.Conference.Models.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long>{}
