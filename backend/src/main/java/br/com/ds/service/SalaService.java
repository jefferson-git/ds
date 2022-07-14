package br.com.ds.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ds.contract.SaleContract;
import br.com.ds.dto.SalaDto;
import br.com.ds.model.Sale;
import br.com.ds.repository.SalaRepository;
import br.com.ds.service.exception.ObjectNotFoundException;

@SuppressWarnings("serial")
@Service
public class SalaService implements Serializable, SaleContract{

	@Autowired SalaRepository salaRepository;
	
	@Override
	public Sale findyById(Integer id) {		
		return salaRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Sala com id,"+id+" não encontrado"));

	}

	@Override
	public List<Sale> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Sale create(SalaDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Sale update(Integer id, SalaDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Sale delete(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
