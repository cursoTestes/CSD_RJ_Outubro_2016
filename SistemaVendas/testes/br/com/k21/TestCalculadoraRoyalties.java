package br.com.k21;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import br.com.k21.dao.VendaRepository;
import br.com.k21.modelo.Venda;

public class TestCalculadoraRoyalties {
	
	private CalculadoraComissao calculadoraComissao;
	private VendaRepository vendaRep;

	@Before
	public void inicializa() {
		calculadoraComissao = Mockito.mock(CalculadoraComissao.class);
		vendaRep = Mockito.mock(VendaRepository.class);
	}
	
	@Test
	public void calcularMesSemVendas() {
		
		int mes =  1;
		int ano = 2016;
		float esperado = 0;
		
		float valorVenda = 100;
		Mockito.when(calculadoraComissao.calculaComissao(valorVenda)).thenReturn(0.0f);
		
		List<Venda> listaVendas = new ArrayList<Venda>();
		Mockito.when(vendaRep.obterVendasPorMesEAno(mes, ano)).thenReturn(listaVendas );
		
		// act
		CalculadoraRoyalties calculadoraRoyalties = new CalculadoraRoyalties();
		calculadoraRoyalties.setCalculadoraComissao(calculadoraComissao);
		calculadoraRoyalties.setVendaRep(vendaRep);
		
		float resultado = calculadoraRoyalties.calcular(mes,ano);

		
		assertEquals(esperado, resultado, 0);
	}
	
	@Test
	public void calcularMesComUmaVenda() {
		
		int mes =  2;
		int ano = 2016;
		float esperado = 19;
		
		float valorVenda = 100;
		Mockito.when(calculadoraComissao.calculaComissao(valorVenda)).thenReturn(5.0f);
		
		
		List<Venda> listaVendas = new ArrayList<Venda>();
		listaVendas.add(new Venda(1, 1, mes, ano, valorVenda ));
		Mockito.when(vendaRep.obterVendasPorMesEAno(mes, ano)).thenReturn(listaVendas );
		
		// act
		CalculadoraRoyalties calculadoraRoyalties = new CalculadoraRoyalties();
		calculadoraRoyalties.setCalculadoraComissao(calculadoraComissao);
		calculadoraRoyalties.setVendaRep(vendaRep);
		
		float resultado = calculadoraRoyalties.calcular(mes,ano);

		assertEquals(esperado, resultado, 0);
	}	
	
	@Test
	public void calcularMesComMaisDeUmaVenda() {
		
		int mes =  2;
		int ano = 2016;
		float esperado = 38;
			
		
		float valorVenda = 100;
		Mockito.when(calculadoraComissao.calculaComissao(valorVenda)).thenReturn(5.0f);
		
		List<Venda> listaVendas = new ArrayList<Venda>();
		listaVendas.add(new Venda(1, 1, mes, ano, valorVenda ));
		listaVendas.add(new Venda(1, 1, mes, ano, valorVenda ));
		Mockito.when(vendaRep.obterVendasPorMesEAno(mes, ano)).thenReturn(listaVendas );
		
		// act
		CalculadoraRoyalties calculadoraRoyalties = new CalculadoraRoyalties();
		calculadoraRoyalties.setCalculadoraComissao(calculadoraComissao);
		calculadoraRoyalties.setVendaRep(vendaRep);
		float resultado = calculadoraRoyalties.calcular(mes,ano);
		
		

		assertEquals(esperado, resultado, 0);
	}
	
}
