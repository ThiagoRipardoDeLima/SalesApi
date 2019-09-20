package com.thiagoripardo.cursomc.domain.enums;

public enum TipoCliente {
	
	PESSOAFISICA(1, "Pessoa Física"),
	PESSOAJURIDICA(2, "Pessoa Jurídica");
	
	private int codigo;
	private String descricao;
	
	private TipoCliente(int codigo, String descricao){
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public int getCodigo() {
		return this.codigo;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	public static TipoCliente toEnum(Integer cod) {
		if (cod == null)
			return null;
		
		for (TipoCliente cliente : TipoCliente.values()) {
			if (cod.equals(cliente.getCodigo())){
				return cliente;
			}
		}
		
		throw new IllegalArgumentException("Codigo inválido: " + cod);
		
	}
	
}
