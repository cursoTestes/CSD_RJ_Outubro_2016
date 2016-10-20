package br.com.k21.modelo;

public class Venda {

	  public Venda(int id, int vendedor, int mes, int ano, float valorVenda)
      {
          idVenda = id;
          idVendedor = vendedor;
          mesVenda = mes;
          anoVenda = ano;
          valor = valorVenda;
      }

      private  int idVenda ;
      private  int idVendedor; 
      private  int mesVenda ;
      private  int anoVenda ;
      private  float valor ;
	
      
    public int getIdVenda() {
		return idVenda;
	}
	public void setIdVenda(int idVenda) {
		this.idVenda = idVenda;
	}
	public int getIdVendedor() {
		return idVendedor;
	}
	public void setIdVendedor(int idVendedor) {
		this.idVendedor = idVendedor;
	}
	public int getMesVenda() {
		return mesVenda;
	}
	public void setMesVenda(int mesVenda) {
		this.mesVenda = mesVenda;
	}
	public int getAnoVenda() {
		return anoVenda;
	}
	public void setAnoVenda(int anoVenda) {
		this.anoVenda = anoVenda;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
    
      
}
