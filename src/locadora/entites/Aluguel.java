

package locadora.entites;

import locadora.ex.MyException;
import java.util.Date;

public class Aluguel implements Comparable<Aluguel>
{
    private Date instanteInicial;
    private Date instanteFinal;
    private Veiculo veiculo;
    private NotaFiscal notaFiscal;
    
    public Aluguel(final Date instanteInicial, final Date instanteFinal, final Veiculo veiculo, final NotaFiscal notaFiscal) {
        this.instanteInicial = instanteInicial;
        this.instanteFinal = instanteFinal;
        this.veiculo = veiculo;
        this.notaFiscal = notaFiscal;
    }
    
    public Aluguel() {
    }
    
    public Date getInstanteInicial() {
        return this.instanteInicial;
    }
    
    public void setInstanteInicial(final Date instanteInicial) {
        this.instanteInicial = instanteInicial;
    }
    
    public Date getInstanteFinal() {
        return this.instanteFinal;
    }
    
    public void setInstanteFinal(final Date instanteFinal) {
        this.instanteFinal = instanteFinal;
    }
    
    public Veiculo getVeiculo() {
        return this.veiculo;
    }
    
    public void setVeiculo(final Veiculo veiculo) {
        this.veiculo = veiculo;
    }
    
    public NotaFiscal getNotaFiscal() {
        return this.notaFiscal;
    }
    
    public void setNotaFiscal(final NotaFiscal notaFiscal) {
        this.notaFiscal = notaFiscal;
    }
    
    @Override
    public int compareTo(final Aluguel outro) {
        return this.notaFiscal.compareTo(outro.getNotaFiscal());
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = 31 * result + ((this.notaFiscal == null) ? 0 : this.notaFiscal.hashCode());
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
        final Aluguel other = (Aluguel)obj;
        if (this.notaFiscal == null) {
            if (other.notaFiscal != null) {
                return false;
            }
        }
        else if (!this.notaFiscal.equals((Object)other.notaFiscal)) {
            return false;
        }
        return true;
    }
    
    public String getDadosAluguel() throws MyException {
        final StringBuilder sb = new StringBuilder();
        sb.append("VEICULO: \n");
        sb.append(String.valueOf(this.veiculo.getDadosVeiculo()) + "\n");
        sb.append(this.notaFiscal.getDadosNotaFiscal());
        return sb.toString();
    }
    
    @Override
    public String toString() {
        return "Aluguel [instanteInicial=" + this.instanteInicial + ", instanteFinal=" + this.instanteFinal + ", veiculo=" + this.veiculo + ", notaFiscal=" + this.notaFiscal + "]";
    }
}
