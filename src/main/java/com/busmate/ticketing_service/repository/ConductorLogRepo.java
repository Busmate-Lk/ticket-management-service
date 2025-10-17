package com.busmate.ticketing_service.repository;

import com.busmate.ticketing_service.entity.Conductor_log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConductorLogRepo extends JpaRepository<Conductor_log, Integer> {
}
