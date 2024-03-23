package com.br.BackendJavaJr.model;


public class Cliente {
	
	private String cpf;
	private double saldo;
	private String email;
	
	public Cliente() {
		
	}
	
	public Cliente(String cpf, double saldo) {
		this.cpf = cpf;
		this.saldo = saldo;
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
	

}
