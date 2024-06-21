package entities;

import java.time.LocalDate;

public class Pessoa {
    private String name;
    private LocalDate dataNasc;

    public Pessoa() {
    }
    public Pessoa(String name, LocalDate dataNasc) {
        this.name = name;
        this.dataNasc = dataNasc;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "name='" + name + '\'' +
                ", dataNasc=" + dataNasc +
                '}';
    }
}
