package com.example.aula04.model;

public class ProfessorTitular extends Professor {
    private int anosInstituicao;
    private double salario;

    public ProfessorTitular() {
        super();
    }

    @Override
    public double calcSalario(int horasTrabalhadas, double valorHora) {
        return ((horasTrabalhadas * valorHora) * (1 + ((0.05 * (int) anosInstituicao / 5))));
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getAnosInstituicao() {
        return anosInstituicao;
    }

    public void setAnosInstituicao(int anosInstituicao) {
        this.anosInstituicao = anosInstituicao;
    }
}