package locadora.application;

import locadora.entites.Aluguel;
import locadora.entites.Cliente;
import locadora.entites.FabricanteVeiculo;
import locadora.entites.ModeloVeiculo;
import locadora.entites.NotaFiscal;
import locadora.entites.Veiculo;
import locadora.ex.MyException;
import locadora.service.AluguelService;
import locadora.service.MotoTaxaServico;
import locadora.service.TaxaServico;
import locadora.service.VeiculoTaxaService;
import locadora.utils.DataUtil;

public class Program {

	public static void main(String[] args) {
		
		try {
			Cliente c1 = new Cliente("Teste","12345678910");
			ModeloVeiculo modelo = new ModeloVeiculo("Golf 4 portas - 1.8");
			FabricanteVeiculo fabricante  = new FabricanteVeiculo("Wolkswagem");
			Veiculo veiculo  = new Veiculo("N", "C", DataUtil.parseDataAno("2018"), "LPR-2081", 1, modelo, fabricante);
			TaxaServico taxaServico = null;
			if(veiculo.getTipoVeiculo().equals("C")) {
				taxaServico = new VeiculoTaxaService();
			}else {
				taxaServico = new MotoTaxaServico();
			}
			NotaFiscal notaFiscal = new NotaFiscal(12.0, 14.0, "A", 1, c1, 1);
			Aluguel aluguel = new Aluguel(DataUtil.parseDataComHora("10/12/2019 08:00:00"), DataUtil.parseDataComHora("10/12/2019 20:00:00"), veiculo, notaFiscal);
		    AluguelService.gerarAluguel(taxaServico, aluguel);
			
		} catch (MyException e) {
			System.out.println("Erro: "+e.getMessage());
			e.printStackTrace();
		}catch(RuntimeException e) {
			System.out.println("Erro inesperado: "+e);
			e.printStackTrace();
		}catch(Exception e) {
			System.out.println("Erro: "+e);
			e.printStackTrace();
		}

	}

}
