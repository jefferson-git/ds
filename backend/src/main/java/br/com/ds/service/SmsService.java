package br.com.ds.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import br.com.ds.model.Sale;
import br.com.ds.repository.SalaRepository;

@Service
public class SmsService {	
	@Autowired SalaRepository salaRepository;

	@Value("${twilio.sid}")
	private String twilioSid;

	@Value("${twilio.key}")
	private String twilioKey;

	@Value("${twilio.phone.from}")
	private String twilioPhoneFrom;

	@Value("${twilio.phone.to}")
	private String twilioPhoneTo;

	public void sendSms(Integer id) {
		
		Sale sale = salaRepository.findById(id).get();
		
		Twilio.init(twilioSid, twilioKey);
		PhoneNumber to = new PhoneNumber(twilioPhoneTo);
		PhoneNumber from = new PhoneNumber(twilioPhoneFrom);
		Message message = Message.creator(to, from, "Teste").create();
		System.out.println(message.getSid());
	}
}