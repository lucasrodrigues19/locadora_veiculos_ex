// 
// Decompiled by Procyon v0.5.36
// 

package locadora.service;

import locadora.ex.MyException;
import locadora.entites.Aluguel;
import java.util.Date;

public class MotoTaxaServico implements TaxaServico
{
    @Override
    public double taxa(final Date ano, final String origem, final Aluguel aluguel) throws MyException {
        if (ano == null || origem == null || aluguel == null) {
            throw new MyException("Ano, origem ou modelo n\u00e3o existem!");
        }
        final double taxaInicial = aluguel.getNotaFiscal().getValorBase() / 100.0 * 2.0;
        double taxaOrigem = 0.0;
        double taxaAno = 0.0;
        final Date dataAtual = new Date();
        if ("N".equals(origem)) {
            taxaOrigem = aluguel.getNotaFiscal().getValorBase() / 100.0 * 2.0;
        }
        else {
            taxaOrigem = aluguel.getNotaFiscal().getValorBase() / 100.0 * 4.0;
        }
        if (ano.getYear()<dataAtual.getYear()) {
            taxaAno = aluguel.getNotaFiscal().getValorBase() / 100.0 * 2.0;
        }
        else {
            taxaAno = aluguel.getNotaFiscal().getValorBase() / 100.0 * 3.0;
        }
        return taxaInicial + taxaOrigem + taxaAno;
    }
}
