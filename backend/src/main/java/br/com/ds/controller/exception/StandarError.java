package br.com.ds.controller.exception;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@SuppressWarnings("serial")
public class StandarError implements Serializable{
	
	private Long timestamp;
	private Integer status;
	private String mensage;
}
