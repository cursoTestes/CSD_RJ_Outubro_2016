package br.com.k21;

import java.util.List;

import br.com.k21.dao.VendaRepository;
import br.com.k21.modelo.Venda;

public class CalculadoraRoyalties {

	private static final float PERCENTUAL = 0.2f;
	private CalculadoraComissao calculadoraComissao = new CalculadoraComissao();
	private VendaRepository vendaRep = new VendaRepository();

	public CalculadoraComissao getCalculadoraComissao() {
		return calculadoraComissao;
	}

	public void setCalculadoraComissao(CalculadoraComissao calculadoraComissao) {
		this.calculadoraComissao = calculadoraComissao;
	}

	public VendaRepository getVendaRep() {
		return vendaRep;
	}

	public void setVendaRep(VendaRepository vendaRep) {
		this.vendaRep = vendaRep;
	}

	public float calcular(int mes, int ano) {

		List<Venda> vendas = vendaRep.obterVendasPorMesEAno(mes, ano);

		float totalComissao = 0;
		float totalVenda = 0;
		for (Venda venda : vendas) {
			//totalComissao += calculadoraComissao.calculaComissao(venda.getValor());
			totalVenda += venda.getValor();
		}
		return (totalVenda - totalComissao) * PERCENTUAL;
	}

}
