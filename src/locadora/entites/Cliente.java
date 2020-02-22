/**
 * 
 */
package locadora.entites;

import java.util.HashMap;
import java.util.Map;

import locadora.utils.TrataValorUtil;

/**
 * @author Lucas_Rodrigues
 *
 */
public class Cliente implements Comparable<Cliente>{
	private String nome;
	private String cpf;
	private Map<Integer,NotaFiscal>alugueis = new HashMap<Integer,NotaFiscal>();
	public Cliente(String nome, String cpf) {
		super();
		this.nome = nome;
		this.cpf = cpf;
	}
	public Cliente() {
		
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Map<Integer, NotaFiscal> getAlugueis() {
		return alugueis;
	}
	public String getDadosCliente() {
		return nome +", "+TrataValorUtil.getCpfFormatado(cpf);
	}
	@Override
	public int compareTo(Cliente o) {
		cpf.compareTo(o.getCpf());
		return 0;
	}
	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", cpf=" + cpf + ", alugueis=" + alugueis + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}
	
}
