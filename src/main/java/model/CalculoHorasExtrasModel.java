package model;

public class CalculoHorasExtrasModel {
    private final double salarioBruto;
    private final double horasExtrasValor;
    private final double jornadaMensal;
    private final double percentual;

    public CalculoHorasExtrasModel(double salarioBruto, double horasExtrasValor, double jornadaMensal, double percentual) {
        this.salarioBruto = salarioBruto;
        this.horasExtrasValor = horasExtrasValor;
        this.jornadaMensal = jornadaMensal;
        this.percentual = percentual;
    }

    // Método para calcular o valor das horas extras em horas
    public double calcularHorasExtras() {
        // Calcula o valor da hora trabalhada
        double valorHoraTrabalhada = salarioBruto / jornadaMensal;

        // Calcula o valor da hora extra com o percentual (50% ou 100%)
        double valorHoraExtra = valorHoraTrabalhada * (1 + (percentual / 100));

        // Calcula a quantidade de horas extras
        return horasExtrasValor / valorHoraExtra;
    }
}
