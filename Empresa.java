/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.empresa;

/**
 *
 * @author guilh
 */
import java.util.Scanner;

public class Empresa {

    public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);

Funcionario[] funcionarios = new Funcionario[100];
int totalFuncionarios = 3;

// Funcionários iniciais
funcionarios[0] = new Funcionario("Ana", "Analista", 3000);
funcionarios[1] = new Funcionario("Bruno", "Gerente", 5000);
funcionarios[2] = new Funcionario("Carlos", "Técnico", 2500);

int opcao;

do {
System.out.println("\nMENU:");
System.out.println("1 - Cadastrar funcionário");
System.out.println("2 - Listar funcionários");
System.out.println("3 - Alterar cargo");
System.out.println("4 - Aumentar salário");
System.out.println("5 - Desativar funcionário");
System.out.println("0 - Sair");
System.out.print("Escolha uma opção: ");
opcao = scanner.nextInt();
scanner.nextLine(); 

switch (opcao) {
case 1:
    if (totalFuncionarios >= funcionarios.length) {
    System.out.println("Limite de funcionários atingido!");
    break;
    }
    System.out.print("Nome: ");
    String nome = scanner.nextLine();
    System.out.print("Cargo: ");
    String cargo = scanner.nextLine();
    System.out.print("Salário: ");
    double salario = scanner.nextDouble();
    scanner.nextLine();
    funcionarios[totalFuncionarios] = new Funcionario(nome, cargo, salario);
    totalFuncionarios++;
    System.out.println("Funcionário cadastrado com sucesso.");
    break;

case 2:
    System.out.println("\n--- Lista de Funcionários ---");
     for (int i = 0; i < totalFuncionarios; i++) {
    funcionarios[i].exibirDados();
    }
    break;

case 3:
    System.out.print("Digite o nome do funcionário: ");
    String nomeBusca = scanner.nextLine();
    boolean encontradoCargo = false;
    for (int i = 0; i < totalFuncionarios; i++) {
    if (funcionarios[i].getNome().equalsIgnoreCase(nomeBusca)) {
    System.out.print("Novo cargo: ");
    String novoCargo = scanner.nextLine();
    funcionarios[i].setCargo(novoCargo);
    System.out.println("Cargo atualizado.");
    encontradoCargo = true;
    break;
     }
    }
    if (!encontradoCargo) {
    System.out.println("Funcionário não encontrado.");
    }
    break;

case 4:
    System.out.print("Nome do funcionário: ");
    String nomeAumento = scanner.nextLine();
    boolean encontradoSalario = false;
    for (int i = 0; i < totalFuncionarios; i++) {
    if (funcionarios[i].getNome().equalsIgnoreCase(nomeAumento)) {
    System.out.print("Percentual de aumento: ");
    double perc = scanner.nextDouble();
    scanner.nextLine(); 
    funcionarios[i].aumentarSalario(perc);
    System.out.println("Salário atualizado.");
    encontradoSalario = true;fr
    break;
    }
    }
    if (!encontradoSalario) {
    System.out.println("Funcionário não encontrado.");
    }
    break;
case 5:
    System.out.print("Nome do funcionário: ");
    String nomeDesativar = scanner.nextLine();
    boolean encontradoDesativar = false;
    for (int i = 0; i < totalFuncionarios; i++) {
    if (funcionarios[i].getNome().equalsIgnoreCase(nomeDesativar)) {
    funcionarios[i].setAtivo(false);
    System.out.println("Funcionário desativado.");
    encontradoDesativar = true;
    break;
    }
    }
    if (!encontradoDesativar) {
    System.out.println("Funcionário não encontrado.");
    }
    break;
case 0:
    System.out.println("Encerrando o programa...");
    break;
    default:
    System.out.println("Opção inválida.");
    }
    } while (opcao != 0);
    scanner.close();
    }
}

// Classe Funcionario
class Funcionario {
    private String nome;
    private String cargo;
    private double salario;
    private boolean ativo;

    public Funcionario(String nome, String cargo, double salario) {
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
        this.ativo = true;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }

    public double getSalario() { return salario; }
    public void setSalario(double salario) { this.salario = salario; }

    public boolean isAtivo() { return ativo; }
    public void setAtivo(boolean ativo) { this.ativo = ativo; }

    public void exibirDados() {
        System.out.println("Nome: " + nome);
        System.out.println("Cargo: " + cargo);
        System.out.println("Salário: R$ " + salario);
        System.out.println("Status: " + (ativo ? "Ativo" : "Inativo"));
        System.out.println("--------------------------");
    }

    public void aumentarSalario(double percentual) {
        this.salario += this.salario * (percentual / 100);
    }
}

