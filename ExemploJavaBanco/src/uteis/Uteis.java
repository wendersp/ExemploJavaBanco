/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteis;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author wender
 */
public class Uteis {

    public static Date parseDate(String dataSt) {
        if (dataSt != null && !dataSt.equals("")) {
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate localdate = LocalDate.parse(dataSt, formato);
            Date data = Date.from(localdate.atStartOfDay(ZoneId.systemDefault()).toInstant());
            return data;
        } else {
            return null;
        }
    }

    public static String parseDate(Date data) {
        if (data != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            return dateFormat.format(data);
        } else {
            return "";
        }
    }

    public static Date addHoraDate(Date data, String hora) {
        try {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
            String dataSt = Uteis.parseDate(data);
            Date dataHr = formato.parse(dataSt + " " + hora);
            return dataHr;

        } catch (ParseException ex) {
            return null;
        }
    }

    public static String parseDateTime(Date data) {
        if (data != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            return dateFormat.format(data);
        } else {
            return "";
        }
    }

    public static String parseSenha(char[] pw) {
        String pwSt = "";
        for (int i = 0; i < pw.length; i++) {
            pwSt += pw[i];
        }
        return pwSt;
    }

    public static String formatarDecimal(Double valor, int dec) {
        Locale ptBr = new Locale("pt", "BR");
        NumberFormat formato = NumberFormat.getInstance(ptBr);
        formato.setMinimumFractionDigits(dec);
        return formato.format(valor);
    }

    public static Double formatarDecimal(String valor) {
        DecimalFormat df = new DecimalFormat();
        DecimalFormatSymbols sfs = new DecimalFormatSymbols();
        sfs.setDecimalSeparator(',');
        df.setDecimalFormatSymbols(sfs);
        try {
            return df.parse(valor).doubleValue();
        } catch (ParseException ex) {
            return null;
        }

    }
    
    
    public static String removerMascara(String str) {
        return str.replaceAll("\\D", "");
    }
    
    /**
     * Formata um double em String; ex: retorna 0.00 
     * @param value
     * @return 
     */
    public static String stringFormat(Double value) {
        return String.format("%.2f", value).replace(',', '.');
    }

}
