// 
// Decompiled by Procyon v0.5.36
// 

package locadora.service;

import locadora.entites.Cliente;
import java.util.Iterator;
import java.util.Set;
import java.util.Collection;
import java.util.TreeSet;
import locadora.entites.Veiculo;
import java.util.Calendar;
import locadora.entites.Parcela;
import java.util.Date;
import locadora.ex.MyException;
import locadora.entites.Aluguel;

public class AluguelService
{
    private static double valorTaxaAluguel(final TaxaServico taxaServico, final Aluguel aluguel) throws MyException {
        if (taxaServico == null || aluguel == null) {
            throw new MyException("Taxa de servi\u00e7o ou dados do aluguel n\u00e3o esistem");
        }
        if (aluguel.getVeiculo().getOrigem().equals("N") || aluguel.getVeiculo().getOrigem().equals("I")) {
            final double taxa = taxaServico.taxa(aluguel.getVeiculo().getAno(), aluguel.getVeiculo().getOrigem(), aluguel);
            return aluguel.getNotaFiscal().getValorBase() + taxa;
        }
        throw new MyException("Origem do veiculo invalida");
    }
    
    public static void gerarAluguel(final TaxaServico taxaServico, final Aluguel aluguel) throws MyException {
        if (taxaServico == null || aluguel == null) {
            throw new MyException("Taxa de servi\u00e7o ou dados do aluguel n\u00e3o esistem");
        }
        final long iI = aluguel.getInstanteInicial().getTime();
        final long iF = aluguel.getInstanteFinal().getTime();
        final double horas = (iF - iI) / 1000.0 / 60.0 / 60.0;
        double valorBase = 0.0;
        if (horas < 24.0) {
            valorBase = Math.ceil(horas) * aluguel.getNotaFiscal().getValorHora();
        }
        else if (horas >= 24.0) {
            final double dias = Math.ceil(horas) / 24.0;
            valorBase = Math.ceil(dias) * aluguel.getNotaFiscal().getValorDia();
        }
        aluguel.getNotaFiscal().setValorBase(Double.valueOf(valorBase));
        double valorTotal = valorTaxaAluguel(taxaServico, aluguel);
        if (aluguel.getNotaFiscal().getTipoPagamento().equals("A")) {
            final double desconto = valorTotal / 100.0 * 10.0;
            valorTotal -= desconto;
            aluguel.getNotaFiscal().getParcelas().put(1, new Parcela(new Date(), Double.valueOf(valorTotal)));
        }
        else {
            final Calendar cal = Calendar.getInstance();
            cal.setTime(new Date());
            final Integer length = aluguel.getNotaFiscal().getQtdParcelas();
            final double juros = valorTotal / 100.0 * 1.2;
            valorTotal += juros;
            final double valorParcela = valorTotal / aluguel.getNotaFiscal().getQtdParcelas();
            for (int i = 0; i < length; ++i) {
                cal.add(2, 1);
                aluguel.getNotaFiscal().getParcelas().put(i, new Parcela(cal.getTime(), Double.valueOf(valorParcela)));
            }
        }
        aluguel.getNotaFiscal().setValorTotal(valorTotal);
        aluguel.getVeiculo().getAluguel().add(aluguel);
        if (aluguel.getNotaFiscal().getCliente().getAlugueis() != null && aluguel.getNotaFiscal().getCliente().getAlugueis().size() > 0) {
            final int keyLength = aluguel.getNotaFiscal().getCliente().getAlugueis().size();
            aluguel.getNotaFiscal().getCliente().getAlugueis().put(keyLength, aluguel.getNotaFiscal());
        }
        else {
            aluguel.getNotaFiscal().getCliente().getAlugueis().put(1, aluguel.getNotaFiscal());
        }
        System.out.println(aluguel.getDadosAluguel());
    }
    
    public static void showAluguelVeiculo(final Veiculo veiculo) {
        String dados = Integer.toString(veiculo.getAluguel().size());
        final Set<Aluguel> alugueisOrdenados = new TreeSet<Aluguel>(veiculo.getAluguel());
        System.out.println("Quantidade de vezes que o veiculo oi alugado: " + dados + "\n");
        System.out.println("Dados do aluguel: ");
        dados = "";
        for (final Aluguel a : alugueisOrdenados) {
            dados = String.valueOf(dados) + a + "\n";
        }
        System.out.println("\n" + dados);
    }
    
    public static void showAluguelCliente(final Cliente cliente) {
        String dados = Integer.toString(cliente.getAlugueis().size());
        System.out.println("Dados dos alugueis referente ao cliente: " + dados + "\n");
        System.out.println("Dados do aluguel: ");
        for (final Integer key : cliente.getAlugueis().keySet()) {
            dados = String.valueOf(dados) + "\n" + key + " - " + cliente.getAlugueis().get(key);
        }
        System.out.println("\n" + dados);
    }
}
