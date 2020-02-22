

package locadora.entites;

import locadora.utils.TrataValorUtil;
import locadora.ex.MyException;
import locadora.utils.DataUtil;
import java.util.Date;

public class Parcela
{
    private Date data;
    private Double valorParcela;
    
    public Parcela(final Date data, final Double valorParcela) {
        this.data = data;
        this.valorParcela = valorParcela;
    }
    
    public Parcela() {
    }
    
    public String getDataFormatted() throws MyException {
        return DataUtil.getFormatoDataCompleta(this.data);
    }
    
    public Date getData() {
        return this.data;
    }
    
    public void setData(final Date data) {
        this.data = data;
    }
    
    public String getValorParcelaFormatted() throws MyException {
        return TrataValorUtil.getValorFormatado(this.valorParcela);
    }
    
    public Double getValorParcela() {
        return this.valorParcela;
    }
    
    public void setValorParcela(final Double valorParcela) {
        this.valorParcela = valorParcela;
    }
    
    public String getDadosParcela() throws MyException {
        return String.valueOf(this.getDataFormatted()) + " - " + this.getValorParcelaFormatted();
    }
    
    @Override
    public String toString() {
        return "Parcela [data=" + this.data + ", valorParcela=" + this.valorParcela + "]";
    }
}
