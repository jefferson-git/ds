package br.com.ds.dto;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@SuppressWarnings("serial")
@NoArgsConstructor @Getter
@AllArgsConstructor @Setter
public class SalaDto implements Serializable{

	private Long id;
	private String sellerName;
	private Integer visited;
	private String deals;
	private Double amount;
	private LocalDate date;
}
