package com.busmate.ticketing_service.repository;

import com.busmate.ticketing_service.entity.Tickets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepo extends JpaRepository<Tickets, Integer> {

}
