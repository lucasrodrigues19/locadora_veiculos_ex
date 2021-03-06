

package locadora.entites;

public class ModeloVeiculo implements Comparable<ModeloVeiculo>
{
    private String descricao;
    
    public ModeloVeiculo(final String descricao) {
        this.descricao = descricao;
    }
    
    public ModeloVeiculo() {
    }
    
    public String getDescricao() {
        return this.descricao;
    }
    
    public void setDescricao(final String descricao) {
        this.descricao = descricao;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = 31 * result + ((this.descricao == null) ? 0 : this.descricao.hashCode());
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
        final ModeloVeiculo other = (ModeloVeiculo)obj;
        if (this.descricao == null) {
            if (other.descricao != null) {
                return false;
            }
        }
        else if (!this.descricao.equals(other.descricao)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return this.descricao;
    }
    
    @Override
    public int compareTo(final ModeloVeiculo o) {
        return this.descricao.compareTo(o.descricao);
    }
}
