package app;

import entities.Funcionario;
import entities.Pessoa;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Funcionario> funcionarios = new ArrayList<Funcionario>();

        funcionarios.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal(2009.44).setScale(2, RoundingMode.HALF_EVEN), "Operador"));
        funcionarios.add(new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal(2284.38).setScale(2, RoundingMode.HALF_EVEN), "Operador"));
        funcionarios.add(new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal(9836.14).setScale(2, RoundingMode.HALF_EVEN), "Coordenador"));
        funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal(19119.88).setScale(2, RoundingMode.HALF_EVEN), "Diretor"));
        funcionarios.add(new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal(2234.68).setScale(2, RoundingMode.HALF_EVEN), "Recepcionista"));
        funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal(1582.72).setScale(2, RoundingMode.HALF_EVEN), "Operador"));
        funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal(4071.84).setScale(2, RoundingMode.HALF_EVEN), "Contador"));
        funcionarios.add(new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal(3017.45).setScale(2, RoundingMode.HALF_EVEN), "Gerente"));
        funcionarios.add(new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal(1606.85).setScale(2, RoundingMode.HALF_EVEN), "Eletricista"));
        funcionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal(2799.93).setScale(2, RoundingMode.HALF_EVEN), "Gerente"));

        System.out.println("Lista Funcionarios:");
        for (Funcionario f : funcionarios) {
            System.out.println("Nome:" + f.getName() + "," + " Data de Nascimento:" + f.getDataNasc() + "," +  " Salario:" + f.getSalario() + "," + " Função:" + f.getFuncao());
        }

        System.out.println();
        System.out.println("Remover João da lista de Funcionarios :");
        funcionarios.removeIf(x -> x.getName() == "João");
        for (Funcionario f : funcionarios) {
            System.out.println("Nome:" + f.getName() + "," + " Data de Nascimento:" + f.getDataNasc() + "," + " Salario:" + f.getSalario() + "," + " Função:" + f.getFuncao());
        }

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DecimalFormat df = new DecimalFormat("#,###.00");

        System.out.println();
        System.out.println("Lista Funcionarios com a Data e Salarios Formatados:");
        for (Funcionario f : funcionarios) {
            System.out.println("Nome:" + f.getName() + "," + " Data de Nascimento:" + f.getDataNasc().format(fmt) + "," +  " Salario:" + df.format(f.getSalario()) + "," + " Função:" + f.getFuncao());
        }

        System.out.println();
        System.out.println("Lista Funcionarios com Salarios aumentados em 10%:");
        for (Funcionario f : funcionarios) {
            BigDecimal salario = (f.getSalario());
            BigDecimal porcetagem = salario.multiply(new BigDecimal("0.10"));
            f.setSalario(salario.add(porcetagem));
            System.out.println("Nome:" + f.getName() + "," + " Data de Nascimento:" + f.getDataNasc().format(fmt) + "," +  " Salario:" + df.format(f.getSalario()) + "," + " Função:" + f.getFuncao());
        }

        System.out.println();

        Map<String, List<Funcionario>> mapFuncionarios = new HashMap<>();

        for (Funcionario funcionario : funcionarios) {
            String funcao = funcionario.getFuncao();

            mapFuncionarios.computeIfAbsent(funcao, k -> new ArrayList<>()).add(funcionario);
        }

        for (Map.Entry<String , List<Funcionario>> entry : mapFuncionarios.entrySet()) {
            String funcao = entry.getKey();
            List<Funcionario> funcaoDoFuncionario = entry.getValue();

            System.out.println("Função: " + funcao);

            for (Funcionario funcionario : funcaoDoFuncionario) {
                System.out.println(" -" + funcionario);
            }
        }

        System.out.println();
        System.out.println("Funcionarios que fazem aniversario entre o mês 10 e 12:");
        for (Map.Entry<String , List<Funcionario>> entry : mapFuncionarios.entrySet()) {
            String funcao = entry.getKey();
            List<Funcionario> funcaoDoFuncionario = entry.getValue();

            System.out.println("Função: " + funcao);

            for (Funcionario funcionario : funcaoDoFuncionario) {
                var dataAniversario = funcionario.getDataNasc();
                var mesAniveario = dataAniversario.getMonth().getValue();
                if (mesAniveario >= 10 && mesAniveario <= 12 ) {
                    System.out.println(" -" + funcionario);
                }
            }
        }

        System.out.println();
        System.out.println("Funcionario com a maior idade:");
        var nomeFuncionario = "";
        var anoNascimento = 2024;
        var idadeFuncionario = 0;

        for (Map.Entry<String , List<Funcionario>> entry : mapFuncionarios.entrySet()) {
            List<Funcionario> funcaoDoFuncionario = entry.getValue();

            for (Funcionario funcionario : funcaoDoFuncionario) {
                if (funcionario.getDataNasc().getYear() < anoNascimento) {
                    nomeFuncionario = funcionario.getName();
                    anoNascimento = funcionario.getDataNasc().getYear();
                    idadeFuncionario = 2024 - anoNascimento;
                }
            }
        }
        System.out.println(nomeFuncionario + ", idade: " +  idadeFuncionario);

        System.out.println();
        System.out.println("Lista Funcionarios Em ordem Alfabetica:");
        funcionarios.sort(Comparator.comparing(Funcionario::getName));
        System.out.println(funcionarios);
        }
}