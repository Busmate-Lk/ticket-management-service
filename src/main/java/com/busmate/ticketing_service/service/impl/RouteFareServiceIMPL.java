package com.busmate.ticketing_service.service.impl;

import com.busmate.ticketing_service.dto.RouteFareDTO;
import com.busmate.ticketing_service.entity.RouteFare;
import com.busmate.ticketing_service.repository.RouteFareRepo;
import com.busmate.ticketing_service.service.RouteFareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RouteFareServiceIMPL implements RouteFareService {

    @Autowired
    private RouteFareRepo routeFareRepo;

    @Override
    public boolean saveRouteFare(RouteFareDTO routeFareDTO) {

        // Check if route fare already exists for same section ID and section name
        if (!routeFareRepo.existsBySectionIdAndSectionName(
                routeFareDTO.getSectionId(),
                routeFareDTO.getSectionName())) {

            RouteFare routeFare = new RouteFare();
            routeFare.setRouteId(routeFareDTO.getRouteId());
            routeFare.setSectionId(routeFareDTO.getSectionId());
            routeFare.setSectionName(routeFareDTO.getSectionName());
            routeFare.setDistanceFromStart(routeFareDTO.getDistanceFromStart());

            routeFareRepo.save(routeFare);
            return true;


        } else {
            return false;
        }
    }
}