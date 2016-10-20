package br.com.k21;

public class CalculadoraComissao {

	private static final int LIMITE_FAIXAS = 10000;
	private static final float FAIXA_COMISSAO_1 = 0.05f;
	private static final float FAIXA_COMISSAO_2 = 0.06f;

	public float calculaComissao(float valorVenda) {
		
		if(valorVenda <= LIMITE_FAIXAS ) {
			return valorVenda*FAIXA_COMISSAO_1;
		}
		else {
			return valorVenda*FAIXA_COMISSAO_2;
		}
	}


}
