package com.busmate.ticketing_service.controller;

import com.busmate.ticketing_service.service.BaseFareService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/baseFare")
@CrossOrigin
public class BaseFareController {

    private final BaseFareService baseFareService;

    public BaseFareController(BaseFareService baseFareService) {
        this.baseFareService = baseFareService;
    }

    @GetMapping(path = "/get-by-sectionAnd-type", params = "section")
    public String getBaseFareBySectionAndType(String section, String type) {
        return baseFareService.getBaseFareBySection(section, type);
    }
}