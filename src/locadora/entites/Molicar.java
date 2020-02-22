
package locadora.entites;

import locadora.ex.MyException;
import locadora.utils.DataUtil;
import java.util.Date;

public abstract class Molicar
{
    private String origem;
    private String tipoVeiculo;
    private Date ano;
    
    public Molicar(final String origem, final String tipoVeiculo, final Date ano) {
        this.origem = origem;
        this.tipoVeiculo = tipoVeiculo;
        this.ano = ano;
    }
    
    public Molicar() {
    }
    
    public String getOrigemFormatted() {
        if ("N".equals(this.origem)) {
            return "Nacional";
        }
        if ("I".equals(this.origem)) {
            return "Importado";
        }
        return "Desconhecida";
    }
    
    public String getOrigem() {
        return this.origem;
    }
    
    public void setOrigem(final String origem) {
        this.origem = origem.toUpperCase();
    }
    
    public String getTipoVeiculoFormatted() {
        if ("N".equals(this.tipoVeiculo)) {
            return "Novo";
        }
        if ("U".equals(this.tipoVeiculo)) {
            return "Usado";
        }
        return "Desconhecido";
    }
    
    public String getTipoVeiculo() {
        return this.tipoVeiculo;
    }
    
    public void setTipoVeiculo(final String tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }
    
    public String getAnoFormatted() throws MyException {
        if (this.ano == null) {
            return "Desconhecido";
        }
        return DataUtil.getFormatoDataAno(this.ano);
    }
    
    public Date getAno() {
        return this.ano;
    }
    
    public void setAno(final Date ano) {
        this.ano = ano;
    }
    
    @Override
    public String toString() {
        return "Molicar [origem=" + this.origem + ", tipoVeiculo=" + this.tipoVeiculo + ", ano=" + this.ano + "]";
    }
}
