package controller;

import model.CalculoHorasExtrasModel;
import util.Utils;
import view.CalculoHorasExtrasView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

public class CalculoHorasExtrasController {
    private CalculoHorasExtrasModel model;
    private final CalculoHorasExtrasView view;

    public CalculoHorasExtrasController(CalculoHorasExtrasModel model, CalculoHorasExtrasView view) {
        this.model = model;
        this.view = view;
        initController();
    }

    private void initController() {
        // Listener para o cálculo de quantidade de horas extras (primeira aba)
        view.getBtnCalcular().addActionListener(e -> {
            try {
                // Obtém os valores da primeira aba
                double salarioBruto = Utils.parseStringToDouble(view.getSalarioBruto());
                double horasExtrasValor = Utils.parseStringToDouble(view.getHorasExtras());
                double jornadaMensal = Utils.parseStringToDouble(view.getJornadaMensal());

                // Verifica se o usuário escolheu 50% ou 100%
                double percentual;
                if (view.isPercentual50()) {
                    percentual = 50;
                } else if (view.isPercentual100()) {
                    percentual = 100;
                } else {
                    view.setResultado("Selecione o percentual de horas extras.");
                    return;
                }

                // Atualiza o model com os valores da primeira aba
                model = new CalculoHorasExtrasModel(salarioBruto, horasExtrasValor, jornadaMensal, percentual);

                // Calcula o número de horas extras
                double resultadoHorasExtras = model.calcularHorasExtras();
                view.setResultado(String.format("%.2f", resultadoHorasExtras) + " horas");
            } catch (ParseException ex) {
                view.setResultado("Erro no formato dos números");
            }
        });

        // Listener para o cálculo do valor das horas extras (segunda aba)
        view.getBtnCalcularValorHorasExtras().addActionListener(e -> {
            try {
                // Obtém os valores da segunda aba
                double salarioBrutoNovo = Utils.parseStringToDouble(view.getSalarioBrutoNovo());
                double jornadaMensalNovo = Utils.parseStringToDouble(view.getJornadaMensalNovo());
                double horasTrabalhadasNovo = Utils.parseStringToDouble(view.getHorasTrabalhadasNovo());

                // Verifica se o usuário escolheu 50% ou 100% na segunda aba
                double percentual;
                if (view.isPercentual50Novo()) {
                    percentual = 0.5; // 50%
                } else if (view.isPercentual100Novo()) {
                    percentual = 1.0; // 100%
                } else {
                    view.setResultadoNovo("Selecione o percentual de horas extras.");
                    return;
                }

                // Cálculo do valor da hora
                double valorHora = salarioBrutoNovo / jornadaMensalNovo;

                // Cálculo do valor das horas extras
                double valorHoraExtra = valorHora * (1 + percentual);

                // Multiplica pelo número de horas extras trabalhadas
                double totalValorHorasExtras = valorHoraExtra * horasTrabalhadasNovo;

                // Exibe o resultado na segunda aba
                view.setResultadoNovo(String.format("R$ %.2f", totalValorHorasExtras));
            } catch (ParseException ex) {
                view.setResultadoNovo("Erro no formato dos números.");
            }
        });
    }
}
