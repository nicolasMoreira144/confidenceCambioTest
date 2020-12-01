package br.com.confidencecambio.javabasico.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.confidencecambio.javabasico.service.IMCService;

@RestController
@RequestMapping(value = "imc")

public class IMCResource {

	private IMCService imcService;

	public IMCResource(final IMCService imcService) {

		this.imcService = imcService;
	}

	@GetMapping
	public ResponseEntity<String> calculaIMC(@RequestParam(value = "peso", required = false) Double peso,
			@RequestParam(value = "altura", required = false) Double altura) {
		var retorno = imcService.retornaValorValido(peso, altura);
		return new ResponseEntity<>(retorno, HttpStatus.OK);
	}

}
