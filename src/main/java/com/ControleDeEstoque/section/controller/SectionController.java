package com.ControleDeEstoque.section.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ControleDeEstoque.model.entity.section.Section;
import com.ControleDeEstoque.section.DTO.SectionDTO;
import com.ControleDeEstoque.section.service.SectionService;
import com.google.gson.Gson;

@Controller
@RequestMapping("/section")
public class SectionController {

	@Autowired
	SectionService sectionService;
	
	@GetMapping
	public ResponseEntity<String> findAll() {
	    String json = new Gson().toJson(sectionService.findAll());	    
		return ResponseEntity.status(HttpStatus.OK).body(json);
	}
	
	@GetMapping("/{idSection}")
	public ResponseEntity<String> findById(@PathVariable Long idSection){
		String json = new Gson().toJson(sectionService.findById(idSection));		
		return ResponseEntity.status(HttpStatus.OK).body(json);
	}
	
	@GetMapping("/inventory/{idInventory}")
	public ResponseEntity<String> findByInventory(@PathVariable Long idInventory){
		String json = new Gson().toJson(sectionService.findByInventory(idInventory));
		
		return ResponseEntity.status(HttpStatus.OK).body(json);
	}
	
	@PostMapping
	public ResponseEntity<Section> save (@RequestBody SectionDTO sectionDTO){
		return ResponseEntity.status(HttpStatus.OK).body(sectionService.save(sectionDTO));
	}
	
	@DeleteMapping("/{idSection}")
	public ResponseEntity<Section> delete (@PathVariable Long idSection) {
		return ResponseEntity.status(HttpStatus.OK).body(sectionService.delete(idSection));
	}
}
