

package locadora.entites;

import locadora.ex.MyException;
import java.util.HashSet;
import java.util.Date;
import java.util.Set;

public class Veiculo extends Molicar implements Comparable<Veiculo>
{
    private String placa;
    private Integer codigo;
    private ModeloVeiculo modelo;
    private FabricanteVeiculo fabricante;
    private Set<Aluguel> aluguel;
    
    public Veiculo(final String origem, final String tipoVeiculo, final Date ano, final String placa, final Integer codigo, final ModeloVeiculo modelo, final FabricanteVeiculo fabricante) {
        super(origem, tipoVeiculo, ano);
        this.aluguel = new HashSet<Aluguel>();
        this.placa = placa;
        this.codigo = codigo;
        this.modelo = modelo;
        this.fabricante = fabricante;
    }
    
    public Veiculo() {
        this.aluguel = new HashSet<Aluguel>();
    }
    
    public String getPlaca() {
        return this.placa;
    }
    
    public void setPlaca(final String placa) {
        this.placa = placa;
    }
    
    public Integer getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(final Integer codigo) {
        this.codigo = codigo;
    }
    
    public ModeloVeiculo getModelo() {
        return this.modelo;
    }
    
    public void setModelo(final ModeloVeiculo modelo) {
        this.modelo = modelo;
    }
    
    public FabricanteVeiculo getFabricante() {
        return this.fabricante;
    }
    
    public void setFabricante(final FabricanteVeiculo fabricante) {
        this.fabricante = fabricante;
    }
    
    public Set<Aluguel> getAluguel() {
        return this.aluguel;
    }
    
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = 31 * result + ((this.codigo == null) ? 0 : this.codigo.hashCode());
        result = 31 * result + ((this.placa == null) ? 0 : this.placa.hashCode());
        return result;
    }
    
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
        final Veiculo other = (Veiculo)obj;
        if (this.codigo == null) {
            if (other.codigo != null) {
                return false;
            }
        }
        else if (!this.codigo.equals(other.codigo)) {
            return false;
        }
        if (this.placa == null) {
            if (other.placa != null) {
                return false;
            }
        }
        else if (!this.placa.equals(other.placa)) {
            return false;
        }
        return true;
    }
    
    public int compareTo(final Veiculo o) {
        return this.codigo.compareTo(o.codigo);
    }
    
    public String getDadosVeiculo() throws MyException {
        final StringBuilder sb = new StringBuilder();
        sb.append("Placa: ");
        sb.append(String.valueOf(this.placa) + ", ");
        sb.append("Modelo: ");
        sb.append(this.modelo + ", ");
        sb.append("Fabricante: ");
        sb.append(this.fabricante);
        sb.append("Ano: ");
        sb.append(String.valueOf(this.getAnoFormatted()) + " ,");
        sb.append("Tipo do veiculo: ");
        sb.append(this.getTipoVeiculoFormatted());
        sb.append("Origem: ");
        sb.append(this.getOrigemFormatted());
        return sb.toString();
    }
    
    public String toString() {
        return "Veiculo [placa=" + this.placa + ", codigo=" + this.codigo + ", modelo=" + this.modelo + ", fabricante=" + this.fabricante + ", aluguel=" + this.aluguel + "]";
    }
}
