package br.com.k21;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestCalculadoraComissao {
	@Test
	public void testeValorComissao10mil() {
		int valorVenda = 10000;
		float valorEsperado = 500f;
		
		CalculadoraComissao calculadora = new CalculadoraComissao();
		float resultado = calculadora.calculaComissao(valorVenda);
		
		assertEquals(valorEsperado, resultado, 0);
	}
	
	@Test
	public void testeValorComissao10mileum() {
		int valorVenda = 10001;
		float valorEsperado = 600.06f;
		
		CalculadoraComissao calculadora = new CalculadoraComissao();
		float resultado = calculadora.calculaComissao(valorVenda);
		
		assertEquals(valorEsperado, resultado, 0);
	}
	
	@Test
	public void testeValorComissaoAcima10mil() {
		int valorVenda = 200000;
		int valorEsperado = 12000;
		
		CalculadoraComissao calculadora = new CalculadoraComissao();
		float resultado = calculadora.calculaComissao(valorVenda);
		
		assertEquals(valorEsperado, resultado, 0);
	}

	@Test
	public void testeValorComissaoAcima10milFracionado() {
		float valorVenda = 10000.44f;
		float valorEsperado = 600.0264f;
		
		CalculadoraComissao calculadora = new CalculadoraComissao();
		float resultado = calculadora.calculaComissao(valorVenda);
		
		assertEquals(valorEsperado, resultado, 0);
	}
	
}
