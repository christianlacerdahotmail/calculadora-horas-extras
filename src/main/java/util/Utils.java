package util;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class Utils {
    // Método para converter strings no formato brasileiro para double
    public static double parseStringToDouble(String value) throws ParseException {
        // Remove espaços em branco
        value = value.trim();

        // Remove os pontos para evitar problemas com o separador de milhares
        value = value.replace(".", "");

        // Usa o NumberFormat com o Locale do Brasil para tratar números com vírgula
        NumberFormat nf = NumberFormat.getInstance(new Locale("pt", "BR"));
        return nf.parse(value).doubleValue();
    }
}
