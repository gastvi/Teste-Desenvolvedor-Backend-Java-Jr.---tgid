package com.br.BackendJavaJr;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.br.BackendJavaJr.infra.security.JavaMailApp;
import com.br.BackendJavaJr.infra.security.ValidadorCnpj;
import com.br.BackendJavaJr.infra.security.ValidadorCpf;
import com.br.BackendJavaJr.Dto.ClienteDto;
import com.br.BackendJavaJr.Dto.EmpresaDto;
import com.br.BackendJavaJr.model.Cliente;
import com.br.BackendJavaJr.model.Empresa;

@SpringBootApplication
public class Application implements CommandLineRunner {

	private final JavaMailApp javaMailApp;
	
	public Application(JavaMailApp javaMailApp) {
		this.javaMailApp = javaMailApp;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Scanner sc1 = new Scanner(System.in);
		boolean verificador = false;
		String pegarScanner;
		Cliente cliente = null;
		Empresa empresa = null;
		System.out.println("");
		System.out.println("");
		System.out.println("");
		
// aqui essa a criação do cliente onde será colocado o cpf e o saldo incial dele

		
		while (verificador == false) {

			System.out.println("digite um cpf pro cliente");
			if (ValidadorCpf.isCPF(pegarScanner = sc1.nextLine()) == true) {

				System.out.println(
						"digite agora um saldo inicial pro cliente, e utilize ponto pra fazer os centavo se quiser");
				var saldo = sc1.nextDouble();
				sc1.nextLine();
				System.out.println("digite um email para pode ser notificado sobre as transacoes");
				var email = sc1.nextLine();
				cliente = new Cliente(ValidadorCpf.imprimeCPF(pegarScanner), saldo, email);
				verificador = true;

			} else {

				System.out.println("cpf invalido, por favor digite um cpf valido");

			}
		}
		
		
		ClienteDto clienteDto = new ClienteDto(cliente);
		System.out.println(clienteDto);
		System.out.println("");

//-----------------------------------------------criando uma empresa------------------------------------------
		while (verificador == true) {

			System.out.println("digite um cnpj para a empresa");
			if (ValidadorCnpj.isCNPJ(pegarScanner = sc1.nextLine()) == true) {

				System.out.println("digite a taxa de deposito dessa empresa utilizando virgula como no Exemplo: 0,02");
				var taxadeposito = sc1.nextDouble();
				System.out.println("digite o saldo inical dessa empresa ");
				var saldo = sc1.nextDouble();
				sc1.nextLine();
				System.out.println("digite um email para pode ser notificado sobre todas transacoes dos clientes");
				var email = sc1.nextLine();
				empresa = new Empresa(ValidadorCnpj.imprimeCNPJ(pegarScanner), saldo, taxadeposito, email);
				verificador = false;

			} else {

				System.out.println("cnpj invalido, por favor digite um cnpj valido");

			}
		}
		
//-----------------------------------------------sacando ou depositando------------------------------------------

		EmpresaDto empresaDto = new EmpresaDto(empresa);
		System.out.println(empresaDto);
		System.out.println("");
		System.out.println("");
		
		System.out.println("qual das opcoes a seguir voce gostaria de fazer:");
		while (verificador == false) {
			System.out.println("digite 1 para sacar um valor");
			System.out.println("digite 2 para depositar um valor");
			System.out.println("digite 0 para sair");

			int a = sc1.nextInt();
			String continuar;
			switch (a) {
			case 0:
				verificador = true;
				
				System.out.println("obrigado por usar meu programa");
				break;
			case 1:
				sc1.nextLine();
				System.out.println("digite 's' pra sacar dinheiro da empresa ou digite qualquer coisa para cancelar");
				continuar = sc1.nextLine();
				if(continuar.equals("s")) {
					System.out.println("informe um valor para sacar da empresa");
					Double valorSacar = sc1.nextDouble();
					empresaDto.ClienteSaca(clienteDto, valorSacar);
					javaMailApp.sendNewMail(cliente.getEmail(), "Saque feito na empresa", "Você realizou um saque com sucesso recentimente no valor de " + valorSacar+ "R$");
					javaMailApp.sendNewMail(empresa.getEmail(), "Saque feito por um cliente", "Um cliente realizou um sace de " + valorSacar + "R$ com sucesso");
					System.out.println("");
					System.out.println("");
					System.out.println(empresaDto.StatusAtuais());
					System.out.println(clienteDto.StatusAtuais());

					break;
				}else{
					System.out.println("cancelando deposito");
					break;
				}
			case 2:
				sc1.nextLine();
				System.out.println("caso queria continuar, existe uma taxa de " + empresaDto.getTaxadeposito() +
						" que sera pega do seu saldo total, ainda deseja continuar, digite 's' pra sim ou digite qualquer coisa para cancelar");
				continuar = sc1.nextLine();
				if(continuar.equals("s")) {
					System.out.println("informe um valor pra depositar na empresa");
					Double valorDeposito = sc1.nextDouble();
					empresaDto.ClienteDeposita(clienteDto, valorDeposito);
					javaMailApp.sendNewMail(cliente.getEmail(), "Deposito feito na empresa", "Você realizou um deposito com sucesso recentimente no valor de " + valorDeposito + "R$");
					javaMailApp.sendNewMail(empresa.getEmail(), "Deposito feito por um cliente", "Um cliente realizou um deposito de " + valorDeposito + "R$ com sucesso");
					System.out.println("");
					System.out.println("");
					System.out.println(empresaDto.StatusAtuais());
					System.out.println(clienteDto.StatusAtuais());

					break;
				}else{
					System.out.println("cancelando deposito");
					break;
				}
				
			default:
				System.out.println("valor invalido, por favor digite um valor valido");
			}
			
		}

	}

}
