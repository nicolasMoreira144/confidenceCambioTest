package br.com.confidencecambio.javabasico.service;

import java.text.DecimalFormat;
import java.util.Optional;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class IMCService {

	private static final String valorPadrao = "Entre com o peso e altura";

	public String retornaValorValido(@Nullable Double peso, @Nullable Double altura) {
		String imc = calculaIMC(peso, altura);
		return Optional.ofNullable(imc).orElse(valorPadrao);
	}

	private String calculaIMC(Double peso, Double altura) {
		Double imc = peso / (altura * altura);
		
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(2);
		String imcString = df.format(imc);
		
		return imcString;
	}
	
}
