package br.com.confidencecambio.javabasico.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.lang.Nullable;

public class LogicaNome {
	
	private static final String valorPadrao = "Entre com um nome:";
	
	public static void main(String[] args) {
		
		String name = "Nicolas Moreira de Souza";
		name = name.trim();
		primeiroNome(name);
		nomeMeio(name);
		nomeMaiusculo(name);
		nomeReduzido(name);
	
	}

	public static void primeiroNome(@Nullable String name) {
		
		if(!verificaNomeValido(name)) 
			return ;
		
		Stream<String> nameCompleted = Stream.of(name.split(" ")); 
		Optional<String> optionalFirstName = nameCompleted.findFirst();
		if(optionalFirstName.isPresent())
		System.out.println(optionalFirstName.get());
		
		
	}

	public static void nomeMeio(String name) {
		
		if(!verificaNomeValido(name)) 
			return ;
		
		List<String> list = Arrays.asList(name.split(" "));
		
		for(int i = 1; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
			
		}
		System.out.println();
	}

	public static void nomeMaiusculo(String name) {
		
		if(!verificaNomeValido(name)) 
			return ;
		
		System.out.println(name.toUpperCase());
	}
	
	//metodo não finalizado
	public static void nomeReduzido(String name) {
		String nome = name;
		
		if(!verificaNomeValido(name)) 
			return ;
		

		
}
	
	private static boolean verificaNomeValido(String name) {
		Optional<String> optionalName = Optional.ofNullable(name);
		
		if(!optionalName.isPresent() ) {
			System.out.println(valorPadrao);
			return false;
			
		}
		
		if(optionalName.get().isBlank()) {
			System.out.println(valorPadrao);
			return false;
		}
		
		return true;
	}
}
