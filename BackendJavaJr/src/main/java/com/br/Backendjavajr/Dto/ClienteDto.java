package com.br.BackendJavaJr.Dto;

import com.br.BackendJavaJr.model.Cliente;

public class ClienteDto {
	
	private String cpf;
	private double saldo;
	private String email;
	
	public ClienteDto(Cliente cliente) {
		this.cpf = cliente.getCpf();
		this.saldo = cliente.getSaldo();
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "cliente criado com sucesso:[(Saldo inicial de: " + saldo + 
				")(cpf: " + cpf + ")]";	
	}
	

	public String StatusAtuais() {
		return "Status do Cliente:[(" +
				"(Saldo atual: " + saldo + 
				")(cpf: " + cpf + ")]";	
	}
}
