package com.example.samuraitravel.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.example.samuraitravel.entity.House;
import com.example.samuraitravel.repository.HouseRepository;

@Controller
public class HomeController {
    private final HouseRepository houseRepository;        
    
    public HomeController(HouseRepository houseRepository) {
        this.houseRepository = houseRepository;            
    }    
    

    public String index(Model model) {
        List<House> newHouses = houseRepository.findTop10ByOrderByCreatedAtDesc();
        model.addAttribute("newHouses", newHouses);        
        
        return "index";
    }   
}