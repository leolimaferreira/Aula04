package com.example.aula04.model;

public class ProfessorHorista extends Professor {
    private int horasTrabalhadas;
    private double valorHora;

    public ProfessorHorista() {
        super();
    }

    @Override
    public double calcSalario(int horasTrabalhadas, double valorHora) {
        return horasTrabalhadas * valorHora;
    }

    public int getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(int horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }
}