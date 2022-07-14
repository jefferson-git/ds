package br.com.ds.contract;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.ds.dto.SalaDto;
import br.com.ds.model.Sale;

public interface SaleContract{
	
	public Sale findyById(Integer id);
	public Page<Sale> findySales(String minDate, String maxDate, Pageable pageable);
	public Sale create(SalaDto dto);
	public Sale update(Integer id, SalaDto dto);
	public Sale delete(Integer id);
	public void sendSms(Integer id);
}
