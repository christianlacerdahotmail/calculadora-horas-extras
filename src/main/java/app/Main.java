package app;

import model.CalculoHorasExtrasModel;
import view.CalculoHorasExtrasView;
import controller.CalculoHorasExtrasController;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {
        // Executa o código na thread da GUI
        javax.swing.SwingUtilities.invokeLater(() -> {
            try {
                // Inicializa o modelo, view e controller
                CalculoHorasExtrasModel model = new CalculoHorasExtrasModel(0, 0, 0, 50); // Iniciando com valores padrões
                CalculoHorasExtrasView view = new CalculoHorasExtrasView();
                new CalculoHorasExtrasController(model, view);

                // Exibe a interface gráfica
                view.setVisible(true);
            } catch (Exception e) {
                // Substitui o printStackTrace() por um logger
                logger.log(Level.SEVERE, "Erro ao inicializar a aplicação: ", e);
            }
        });
    }
}
