package com.br.BackendJavaJr.model;

public class Empresa {

	private String cnpj;
	private double saldo;
	private double taxaSaque;
	private double taxadeposito;

	public Empresa() {
	}

	public Empresa(String cnpj, double saldo, double taxaSaque, double taxadeposito) {
		this.cnpj = cnpj;
		this.saldo = saldo;
		this.taxaSaque = taxaSaque;
		this.taxadeposito = taxadeposito;
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

}
