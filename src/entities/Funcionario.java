package entities;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Funcionario extends Pessoa{
    private BigDecimal salario;
    private String funcao;

    public Funcionario(String name, LocalDate dataNasc, BigDecimal salario, String funcao) {
        super(name, dataNasc);
        this.salario = salario;
        this.funcao = funcao;
    }

    public Funcionario() {
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
}
