package com.br.BackendJavaJr.Dto;

import com.br.BackendJavaJr.model.Empresa;

public class EmpresaDto {
	
	private String cnpj;
	private double saldo;
	private double taxaSaque;
	private double taxadeposito;
	
	
	public EmpresaDto(Empresa empresa) {
		this.cnpj = empresa.getCnpj();
		this.saldo = empresa.getSaldo();
		this.taxaSaque = empresa.getTaxaSaque();
		this.taxadeposito = empresa.getTaxadeposito();
	}

	public void ClienteDeposita(ClienteDto clienteDto, double valorDepositar) {
		if (clienteDto.getSaldo() >= valorDepositar + (clienteDto.getSaldo() * this.taxadeposito)) {
			
			this.saldo = this.saldo + valorDepositar * (this.taxadeposito + 1);
			var valor = (clienteDto.getSaldo() - (clienteDto.getSaldo() * this.taxadeposito)) - valorDepositar;
			clienteDto.setSaldo(valor);
			
		} else {
			System.out.println("o valor inserido é maior do que seu saldo atual");
		}
	}
	
	public void ClienteSaca() {
		
	}
	

	public String getCnpj() {
		return cnpj;
	}


	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}


	public double getSaldo() {
		return saldo;
	}


	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}


	public double getTaxaSaque() {
		return taxaSaque;
	}


	public void setTaxaSaque(double taxaSaque) {
		this.taxaSaque = taxaSaque;
	}


	public double getTaxadeposito() {
		return taxadeposito;
	}


	public void setTaxadeposito(double taxadeposito) {
		this.taxadeposito = taxadeposito;
	}
	
	@Override
	public String toString() {
		return "Empresa criado com sucesso. "
				+"Saldo inicial: " + saldo + 
				" cnpj: " + cnpj +
				" taxa de saque: " + taxaSaque +
				" taxa de deposito: "+ taxadeposito;
	}
	

	public String StatusAtuais() {
		return "Status da empresa."+
				" Saldo atual: " + saldo + 
				" cnpj: " + cnpj +
				" taxa de saque: " + taxaSaque +
				" taxa de deposito: "+ taxadeposito;
	}
	
}
