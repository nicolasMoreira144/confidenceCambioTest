package br.com.confidencecambio.javabasico.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class IMCTest {
	
	private IMCService service;
	
	@Before
    public void init(){
         service = new IMCService();
    }


    @Test
    public void calculandoIMC(){
        var imc = "23.82";
        String valorValido = service.retornaValorValido(86.0, 1.90);
        assertEquals(imc, valorValido);
    }

    @Test
    public void quandoPassarNuloQueroOPadrao(){

        String valorValido = service.retornaValorValido(null, null);
        assertEquals("23.82", valorValido);
    }

}
