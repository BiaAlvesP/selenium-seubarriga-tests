package br.ce.wcaquino.tests.utils;

public class DataUtils {

    public static String obterDataComDiferencaDias(int dias) {
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.add(java.util.Calendar.DAY_OF_MONTH, dias);
        return new java.text.SimpleDateFormat("dd/MM/yyyy").format(cal.getTime());
    }

    public static String obterDataFormatada(java.util.Date data) {
        return new java.text.SimpleDateFormat("dd/MM/yyyy").format(data);
    }
}
