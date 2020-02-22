// 
// Decompiled by Procyon v0.5.36
// 

package locadora.utils;

public class TrataValorUtil
{
    private static String mascaraCPF;
    
    static {
        TrataValorUtil.mascaraCPF = "rtu.dgh.ope-zx";
    }
    
    public static String getValorFormatado(final Double valor) {
        final String retorno = "0.0";
        if (valor != null) {
            return String.format("%.2f", valor);
        }
        return retorno;
    }
    
    public static String getValorFormatado(final Float valor) {
        final String retorno = "0.0";
        if (valor != null) {
            return String.format("%.2f", valor);
        }
        return retorno;
    }
    
    public static Number verificaValor(final Number valor) {
        Number retorno = 0;
        if (valor != null) {
            if (valor instanceof Integer) {
                retorno = valor;
            }
            else if (valor instanceof Double) {
                retorno = valor;
            }
            else if (valor instanceof Long) {
                retorno = valor;
            }
            else if (valor instanceof Float) {
                retorno = valor;
            }
        }
        else if (valor instanceof Integer) {
            retorno = 0;
        }
        else if (valor instanceof Double) {
            retorno = 0.0;
        }
        else if (valor instanceof Long) {
            retorno = 0L;
        }
        else if (valor instanceof Float) {
            retorno = 0.0f;
        }
        return retorno;
    }
    
    public static String verificaValor(final String valor) {
        if (valor != null) {
            return valor;
        }
        return "";
    }
    
    public static String getCpfFormatado(final String valor) {
        String retorno = "";
        if (valor != null) {
            char proxDigito = valor.charAt(0);
            for (int i = 0; i < TrataValorUtil.mascaraCPF.length(); ++i) {
                if (i == 3) {
                    TrataValorUtil.mascaraCPF = TrataValorUtil.mascaraCPF.replace(TrataValorUtil.mascaraCPF.charAt(i + 1), proxDigito);
                }
                else if (i == 4) {
                    proxDigito = valor.charAt(i);
                }
                else if (i == 7) {
                    TrataValorUtil.mascaraCPF = TrataValorUtil.mascaraCPF.replace(TrataValorUtil.mascaraCPF.charAt(i + 1), proxDigito);
                }
                else if (i == 8) {
                    proxDigito = valor.charAt(i - 1);
                }
                else if (i == 11) {
                    TrataValorUtil.mascaraCPF = TrataValorUtil.mascaraCPF.replace(TrataValorUtil.mascaraCPF.charAt(i + 1), proxDigito);
                    proxDigito = valor.charAt(i - 1);
                }
                else if (i != 12) {
                    TrataValorUtil.mascaraCPF = TrataValorUtil.mascaraCPF.replace(TrataValorUtil.mascaraCPF.charAt(i), proxDigito);
                    retorno = TrataValorUtil.mascaraCPF;
                    if (i < valor.length() - 1) {
                        proxDigito = valor.charAt(i + 1);
                    }
                    if (i == 5) {
                        proxDigito = valor.charAt(i);
                    }
                    else if (i == 6) {
                        proxDigito = valor.charAt(i);
                    }
                    else if (i > 8 && i <= 10) {
                        proxDigito = valor.charAt(i - 1);
                    }
                }
            }
        }
        return retorno;
    }
}
