package modelo;

public abstract class Aberturas {
	
	protected String descricao;
	protected int estado;
	
	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public String getDescricao() {
		return descricao;
	}
		
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
