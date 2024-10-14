package app;

import model.CalculoHorasExtrasModel;
import view.CalculoHorasExtrasView;
import controller.CalculoHorasExtrasController;

public class Main {
    public static void main(String[] args) {
        // Executa o código na thread da GUI
        javax.swing.SwingUtilities.invokeLater(() -> {
            try {
                // Inicializa o modelo, view e controller
                CalculoHorasExtrasModel model = new CalculoHorasExtrasModel(0, 0, 0, 50); // Iniciando com valores padrões
                CalculoHorasExtrasView view = new CalculoHorasExtrasView();
                CalculoHorasExtrasController controller = new CalculoHorasExtrasController(model, view);

                // Exibe a interface gráfica
                view.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
