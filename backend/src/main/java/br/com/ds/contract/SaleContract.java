package br.com.ds.contract;

import java.util.List;

import br.com.ds.dto.SalaDto;
import br.com.ds.model.Sale;

public interface SaleContract{
	
	public Sale findyById(Integer id);
	public List<Sale> findAll();
	public Sale create(SalaDto dto);
	public Sale update(Integer id, SalaDto dto);
	public Sale delete(Integer id);
}
