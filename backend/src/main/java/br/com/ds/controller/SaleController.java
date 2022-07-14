package br.com.ds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.ds.config.Mapper;
import br.com.ds.dto.SalaDto;
import br.com.ds.model.Sale;
import br.com.ds.service.SalaService;

@RestController
@RequestMapping("/sale")
public class SaleController {
	
	@Autowired Mapper mapper;
	@Autowired SalaService salaService;
	
	@GetMapping("/{id}")
	public ResponseEntity<SalaDto> findyById(@PathVariable Integer id){
		return ResponseEntity.ok().body(mapper.mp().map(salaService.findyById(id), SalaDto.class));
	}
	
	@GetMapping
	public Page<Sale> findyAll(@RequestParam(value = "minDate", defaultValue = "") String minDate,
			@RequestParam(value = "maxDate", defaultValue = "") String maxDate,	Pageable pageable){		
		return salaService.findySales(minDate, maxDate, pageable);
	}
	
	@GetMapping("/{id}/notification")
	public void notifySms(@PathVariable Integer id) {
		salaService.sendSms(id);
	}
}
