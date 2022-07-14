package br.com.ds.service;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import br.com.ds.contract.SaleContract;
import br.com.ds.dto.SalaDto;
import br.com.ds.model.Sale;
import br.com.ds.repository.SalaRepository;
import br.com.ds.service.exception.ObjectNotFoundException;

@SuppressWarnings("serial") @Service
public class SalaService implements Serializable, SaleContract{
	
	@Value("${twilio.sid}")
	private String twilioSid;

	@Value("${twilio.key}")
	private String twilioKey;

	@Value("${twilio.phone.from}")
	private String twilioPhoneFrom;

	@Value("${twilio.phone.to}")
	private String twilioPhoneTo;

	@Autowired SalaRepository salaRepository;
	
	@Override
	public Sale findyById(Integer id) {		
		return salaRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Sala com id,"+id+" não encontrado"));
	}
	
	@Override
	public Page<Sale> findySales(String minDate, String maxDate, Pageable pageable) {
		LocalDate today =  LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
		LocalDate min = minDate.equals("") ? today.minusYears(1) : LocalDate.parse(minDate);
		LocalDate max = maxDate.equals("") ? today : LocalDate.parse(maxDate);

		return salaRepository.findSales(min, max, pageable);
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

	@Override
	public void sendSms(Integer id) {
		
		Sale sale = findyById(id);
		String date = sale.getDate().getMonthValue()+ "/" +sale.getDate().getYear();
		String msg = "O vendedor, "+sale.getSellerName()+ " foi destaque no mês de " + date
				+"com total de:" + String.format("%.2f", sale.getAmount());
		
		Twilio.init(twilioSid, twilioKey);
		PhoneNumber to = new PhoneNumber(twilioPhoneTo);
		PhoneNumber from = new PhoneNumber(twilioPhoneFrom);
		Message.creator(to, from, msg).create();		
	}
}
