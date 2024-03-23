package com.br.BackendJavaJr.Dto;

import com.br.BackendJavaJr.model.Empresa;

public class EmpresaDto {

	private String cnpj;
	private double saldo;
	private double taxadeposito;
	private String email;


	public EmpresaDto(Empresa empresa) {
		this.cnpj = empresa.getCnpj();
		this.saldo = empresa.getSaldo();
		this.taxadeposito = empresa.getTaxadeposito();
		this.email = empresa.getEmail();
	}

	
	
	public void ClienteDeposita(ClienteDto clienteDto, double valorDepositar) {
		if (clienteDto.getSaldo() >= valorDepositar + (clienteDto.getSaldo() * this.taxadeposito)) {

			this.saldo = this.saldo + valorDepositar * (this.taxadeposito + 1);
			var valor = (clienteDto.getSaldo() - (clienteDto.getSaldo() * this.taxadeposito)) - valorDepositar;
			clienteDto.setSaldo(valor);

		} else {
			System.out.println("o valor inserido é maior do que seu saldo atual, nao e possivel fazer esse deposito");
		}
	}

	
	
	public void ClienteSaca(ClienteDto clienteDto, double valorSacar) {
		if (valorSacar <= this.saldo) {

			this.saldo = this.saldo - valorSacar;
			var valor = clienteDto.getSaldo() + valorSacar ;
			clienteDto.setSaldo(valor);

		} else {
			System.out.println("o valor inserido é maior do que saldo atual da empresa, nao e possivel fazer esse saque");
		}
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

	public double getTaxadeposito() {
		return taxadeposito;
	}

	public void setTaxadeposito(double taxadeposito) {
		this.taxadeposito = taxadeposito;
	}

	@Override
	public String toString() {
		return "Empresa criado com sucesso:[" + "(Saldo inicial: " + saldo + ")(cnpj: " + cnpj + 
				")(taxa de deposito: " + taxadeposito + ")(email:" + email + ")]";
	}

	public String StatusAtuais() {
		return "Status da empresa:[" + "(Saldo atual: " + saldo + ")(cnpj: " + cnpj + 
				")(taxa de deposito: " + taxadeposito + ")(email:" + email + ")]";
	}

}
