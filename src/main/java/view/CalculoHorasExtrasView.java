package view;

import javax.swing.*;
import java.awt.*;

public class CalculoHorasExtrasView extends JFrame {
    private JTextField txtSalarioBruto;
    private JTextField txtHorasExtras;
    private JTextField txtJornadaMensal;
    private JButton btnCalcular;
    private JLabel lblResultado;
    private JRadioButton radio50;
    private JRadioButton radio100;
    private ButtonGroup grupoPercentual;

    // Elementos da nova aba para cálculo de valor de horas extras
    private JTextField txtSalarioBrutoNovo;
    private JTextField txtJornadaMensalNovo;
    private JTextField txtHorasTrabalhadasNovo;
    private JButton btnCalcularValorHorasExtras;
    private JLabel lblResultadoNovo;
    private JRadioButton radio50Novo;
    private JRadioButton radio100Novo;
    private ButtonGroup grupoPercentualNovo;

    public CalculoHorasExtrasView() {
        setTitle("Parâmetros e Cálculos");
        setSize(475, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Definindo o ícone da janela
        ImageIcon imgIcon = new ImageIcon(getClass().getResource("/icons/logo.png"));
        setIconImage(imgIcon.getImage());

        // Criando o painel de abas
        JTabbedPane tabbedPane = new JTabbedPane();

        // Primeira aba (cálculo de quantidade de horas extras)
        JPanel panelParametros = new JPanel();
        panelParametros.setLayout(new GridLayout(6, 2));

        panelParametros.add(new JLabel("Salário Bruto:"));
        txtSalarioBruto = new JTextField();
        panelParametros.add(txtSalarioBruto);

        panelParametros.add(new JLabel("Valor Horas Extras:"));
        txtHorasExtras = new JTextField();
        panelParametros.add(txtHorasExtras);

        panelParametros.add(new JLabel("Jornada Mensal:"));
        txtJornadaMensal = new JTextField();
        panelParametros.add(txtJornadaMensal);

        panelParametros.add(new JLabel("Percentual Horas Extras:"));
        JPanel percentualPanel = new JPanel();
        radio50 = new JRadioButton("50%", true);
        radio100 = new JRadioButton("100%");
        grupoPercentual = new ButtonGroup();
        grupoPercentual.add(radio50);
        grupoPercentual.add(radio100);
        percentualPanel.add(radio50);
        percentualPanel.add(radio100);
        panelParametros.add(percentualPanel);

        btnCalcular = new JButton("Calcular");
        panelParametros.add(btnCalcular);

        lblResultado = new JLabel("Resultado:");
        panelParametros.add(lblResultado);

        tabbedPane.addTab("Cálculo Quantidade de Horas Extras", panelParametros);

        // Segunda aba (cálculo do valor das horas extras)
        JPanel panelValorHorasExtras = new JPanel();
        panelValorHorasExtras.setLayout(new GridLayout(6, 2));

        panelValorHorasExtras.add(new JLabel("Salário Bruto:"));
        txtSalarioBrutoNovo = new JTextField();
        panelValorHorasExtras.add(txtSalarioBrutoNovo);

        panelValorHorasExtras.add(new JLabel("Jornada Mensal:"));
        txtJornadaMensalNovo = new JTextField();
        panelValorHorasExtras.add(txtJornadaMensalNovo);

        panelValorHorasExtras.add(new JLabel("Horas Extras Trabalhadas:"));
        txtHorasTrabalhadasNovo = new JTextField();
        panelValorHorasExtras.add(txtHorasTrabalhadasNovo);

        panelValorHorasExtras.add(new JLabel("Percentual Horas Extras:"));
        JPanel percentualPanelNovo = new JPanel();
        radio50Novo = new JRadioButton("50%", true);
        radio100Novo = new JRadioButton("100%");
        grupoPercentualNovo = new ButtonGroup();
        grupoPercentualNovo.add(radio50Novo);
        grupoPercentualNovo.add(radio100Novo);
        percentualPanelNovo.add(radio50Novo);
        percentualPanelNovo.add(radio100Novo);
        panelValorHorasExtras.add(percentualPanelNovo);

        btnCalcularValorHorasExtras = new JButton("Calcular Valor Horas Extras");
        panelValorHorasExtras.add(btnCalcularValorHorasExtras);

        lblResultadoNovo = new JLabel("Resultado:");
        panelValorHorasExtras.add(lblResultadoNovo);

        // Adicionando a nova aba
        tabbedPane.addTab("Cálculo Valor de Horas Extras", panelValorHorasExtras);

        // Adicionando o tabbedPane ao JFrame
        add(tabbedPane);
    }

    // Métodos para a primeira aba (cálculo da quantidade de horas extras)
    public String getSalarioBruto() {
        return txtSalarioBruto.getText();
    }

    public String getHorasExtras() {
        return txtHorasExtras.getText();
    }

    public String getJornadaMensal() {
        return txtJornadaMensal.getText();
    }

    public boolean isPercentual50() {
        return radio50.isSelected();
    }

    public boolean isPercentual100() {
        return radio100.isSelected();
    }

    public void setResultado(String resultado) {
        lblResultado.setText("Resultado: " + resultado);
    }
    public JButton getBtnCalcular() {
        return btnCalcular;
    }

    // Métodos da nova aba
    public String getSalarioBrutoNovo() {
        return txtSalarioBrutoNovo.getText();
    }

    public String getJornadaMensalNovo() {
        return txtJornadaMensalNovo.getText();
    }

    public String getHorasTrabalhadasNovo() {
        return txtHorasTrabalhadasNovo.getText();
    }

    public boolean isPercentual50Novo() {
        return radio50Novo.isSelected();
    }

    public boolean isPercentual100Novo() {
        return radio100Novo.isSelected();
    }

    public JButton getBtnCalcularValorHorasExtras() {
        return btnCalcularValorHorasExtras;
    }

    public void setResultadoNovo(String resultado) {
        lblResultadoNovo.setText("Resultado: " + resultado);
    }
}
