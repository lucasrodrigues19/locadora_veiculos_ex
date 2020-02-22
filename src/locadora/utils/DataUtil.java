// 
// Decompiled by Procyon v0.5.36
// 

package locadora.utils;

import java.text.ParseException;
import locadora.ex.MyException;
import java.util.Date;
import java.text.SimpleDateFormat;

public class DataUtil
{
    private static SimpleDateFormat sdfY;
    private static SimpleDateFormat sdfDH;
    private static SimpleDateFormat sdfD;
    private static SimpleDateFormat sdfH;
    
    static {
        DataUtil.sdfY = new SimpleDateFormat("yyyy");
        DataUtil.sdfDH = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        DataUtil.sdfD = new SimpleDateFormat("dd/MM/yyyy");
        DataUtil.sdfH = new SimpleDateFormat("HH:mm:ss");
    }
    
    public static Date parseDataComHora(final String date) throws MyException {
        if (date == null) {
            throw new MyException("data inexistente ");
        }
        try {
            return DataUtil.sdfDH.parse(date);
        }
        catch (ParseException e) {
            throw new MyException("Formato de data invalido para (dd/MM/yyyy HH:mm:ss)");
        }
    }
    
    public static Date parseDataCompleta(final String date) throws MyException {
        if (date == null) {
            throw new MyException("data inexistente ");
        }
        try {
            return DataUtil.sdfD.parse(date);
        }
        catch (ParseException e) {
            throw new MyException("Formato de data invalido para (dd/MM/yyyy)");
        }
    }
    
    public static Date parseHoraCompleta(final String date) throws MyException {
        if (date == null) {
            throw new MyException("data inexistente ");
        }
        try {
            return DataUtil.sdfH.parse(date);
        }
        catch (ParseException e) {
            throw new MyException("Formato de data invalido para (HH:mm:ss)");
        }
    }
    
    public static Date parseDataAno(final String date) throws MyException {
        if (date == null) {
            throw new MyException("data inexistente ");
        }
        try {
            return DataUtil.sdfY.parse(date);
        }
        catch (ParseException e) {
            throw new MyException("Formato de data invalido para (HH:mm:ss)");
        }
    }
    
    public static String getFormatoDataComHora(final Date date) throws MyException {
        if (date == null) {
            throw new MyException("data inexistente ");
        }
        try {
            return DataUtil.sdfDH.format(date);
        }
        catch (Exception e) {
            throw new MyException("Formato de data invalido para (dd/MM/yyyy HH:mm:ss)");
        }
    }
    
    public static String getFormatoDataCompleta(final Date date) throws MyException {
        if (date == null) {
            throw new MyException("data inexistente ");
        }
        try {
            return DataUtil.sdfD.format(date);
        }
        catch (Exception e) {
            throw new MyException("Formato de data invalido para (dd/MM/yyyy)");
        }
    }
    
    public static String getFormatoHoraCompleta(final Date date) throws MyException {
        if (date == null) {
            throw new MyException("data inexistente ");
        }
        try {
            return DataUtil.sdfH.format(date);
        }
        catch (Exception e) {
            throw new MyException("Formato de data invalido para (HH:mm:ss)");
        }
    }
    
    public static String getFormatoDataAno(final Date date) throws MyException {
        if (date == null) {
            throw new MyException("data inexistente ");
        }
        try {
            return DataUtil.sdfY.format(date);
        }
        catch (Exception e) {
            throw new MyException("Formato de data invalido para (yyyy)");
        }
    }
}
