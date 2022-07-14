package br.com.ds.model;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@SuppressWarnings("serial")
@Entity(name = "TB_SALES") @Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Sale implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String sellerName;
	private Integer visited;
	private String deals;
	private Double amount;
	private LocalDate date;
}
