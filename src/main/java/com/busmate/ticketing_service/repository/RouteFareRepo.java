package com.busmate.ticketing_service.repository;


import com.busmate.ticketing_service.entity.RouteFare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@EnableJpaRepositories
@Repository
public interface RouteFareRepo extends JpaRepository<RouteFare, UUID> {

    boolean existsBySectionIdAndSectionName(int sectionId, String sectionName);
}
