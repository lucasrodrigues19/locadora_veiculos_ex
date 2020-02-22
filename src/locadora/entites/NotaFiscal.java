

package locadora.entites;

import locadora.ex.MyException;
import java.util.Iterator;
import java.util.TreeMap;
import locadora.utils.TrataValorUtil;
import java.util.HashMap;
import java.util.Map;

public class NotaFiscal implements Comparable<NotaFiscal>
{
    private Double valorBase;
    private Double valorTotal;
    private Double valorHora;
    private Double valorDia;
    private Map<Integer, Parcela> parcelas;
    private String tipoPagamento;
    private Integer qtdParcelas;
    private Cliente cliente;
    private Integer codigo;
    
    public NotaFiscal(final Double valorHora, final Double valorDia, final String tipoPagamento, final Integer qtdParcelas, final Cliente cliente, final Integer codigo) {
        this.parcelas = new HashMap<Integer, Parcela>();
        this.valorHora = valorHora;
        this.valorDia = valorDia;
        this.tipoPagamento = tipoPagamento;
        this.qtdParcelas = qtdParcelas;
        this.cliente = cliente;
        this.codigo = codigo;
    }
    
    public String getValorBaseFormatted() {
        return TrataValorUtil.getValorFormatado(this.valorBase);
    }
    
    public Double getValorBase() {
        return this.valorBase;
    }
    
    public void setValorBase(final Double valorBase) {
        this.valorBase = valorBase;
    }
    
    public String getValorHoraFormatted() {
        return TrataValorUtil.getValorFormatado(this.valorHora);
    }
    
    public Double getValorHora() {
        return this.valorHora;
    }
    
    public void setValorHora(final Double valorHora) {
        this.valorHora = valorHora;
    }
    
    public String getTipoPagamento() {
        return this.tipoPagamento;
    }
    
    public void setTipoPagamento(final String tipoPagamento) {
        this.tipoPagamento = tipoPagamento.toUpperCase();
    }
    
    public Integer getQtdParcelas() {
        return this.qtdParcelas;
    }
    
    public void setQtdParcelas(final Integer qtdParcelas) {
        this.qtdParcelas = qtdParcelas;
    }
    
    public Cliente getCliente() {
        return this.cliente;
    }
    
    public void setCliente(final Cliente cliente) {
        this.cliente = cliente;
    }
    
    public Integer getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(final Integer codigo) {
        this.codigo = codigo;
    }
    
    public Map<Integer, Parcela> getParcelas() {
        return this.parcelas;
    }
    
    public String getValorDiaFormatted() {
        return TrataValorUtil.getValorFormatado(this.valorDia);
    }
    
    public Double getValorDia() {
        return this.valorDia;
    }
    
    public void setValorDia(final Double valorDia) {
        this.valorDia = valorDia;
    }
    
    public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public void setParcelas(Map<Integer, Parcela> parcelas) {
		this.parcelas = parcelas;
	}

	@Override
    public int compareTo(final NotaFiscal outra) {
        return this.codigo.compareTo(outra.getCodigo());
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = 31 * result + ((this.codigo == null) ? 0 : this.codigo.hashCode());
        return result;
    }
    
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        final NotaFiscal other = (NotaFiscal)obj;
        if (this.codigo == null) {
            if (other.codigo != null) {
                return false;
            }
        }
        else if (!this.codigo.equals(other.codigo)) {
            return false;
        }
        return true;
    }
    
    public String getDadosNotaFiscal() throws MyException {
        final StringBuilder sb = new StringBuilder();
        sb.append("NOTA FISCAL \nCodigo: ");
        sb.append(this.codigo + "\n");
        sb.append("Valor Base: ");
        sb.append(String.valueOf(this.getValorBaseFormatted()) + ", ");
        sb.append("Tipo do pagamento: ");
        Parcela parcela = null;
        String dadosParcela = "--------------------\n";
        if (this.tipoPagamento.equals("A")) {
            sb.append("Avista \n");
            final Map<Integer, Parcela> parcelaOrdenada = new TreeMap<Integer, Parcela>(this.parcelas);
            for (final Integer key : parcelaOrdenada.keySet()) {
                parcela = parcelaOrdenada.get(key);
                dadosParcela = String.valueOf(dadosParcela) + parcela.getDadosParcela() + "\n";
            }
        }
        else {
            sb.append("Aprazo \n");
            final Map<Integer, Parcela> parcelaOrdenada = new TreeMap<Integer, Parcela>(this.parcelas);
            for (final Integer key : parcelaOrdenada.keySet()) {
                parcela = parcelaOrdenada.get(key);
                dadosParcela = String.valueOf(dadosParcela) + parcela.getDadosParcela() + "\n";
            }
        }
        dadosParcela = String.valueOf(dadosParcela) + "--------------------\n";
        sb.append(dadosParcela);
        sb.append("\nQuantidade de parcelas: ");
        sb.append(this.qtdParcelas + ", ");
        sb.append("Valor total: ");
        sb.append(TrataValorUtil.getValorFormatado(valorTotal));
        sb.append("\n\nDADOS DO CLIENTE: \n");
        sb.append(this.cliente.getDadosCliente());
        return sb.toString();
    }
    
    @Override
    public String toString() {
        return "NotaFiscal [valorBase=" + this.valorBase + ", valorHora=" + this.valorHora + ", valorDia=" + this.valorDia + ", parcelas=" + this.parcelas + ", tipoPagamento=" + this.tipoPagamento + ", qtdParcelas=" + this.qtdParcelas + ", cliente=" + this.cliente + ", codigo=" + this.codigo + "]";
    }
}
