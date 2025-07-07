package modelo;

//Sub-Classe Apartamento
public class Apartamento extends Financiamento{
    //Atributos
    protected int vagasGaragem;
    protected int numeroAndar;

    //Método Construtor
    public Apartamento(double valorImovel, int prazoFinanciamentoAnos, double taxaJurosAnual, int vagasGaragem, int numeroAndar) {
        super(valorImovel, prazoFinanciamentoAnos, taxaJurosAnual);
        this.vagasGaragem = vagasGaragem;
        this.numeroAndar = numeroAndar;
    }

    //Método de Pagamento Total
    public double calcularTotalPagamento(){
        return calculoMensal() * prazoFinanciamento * 12;
    }

    //Método de Calculo PRICE
    @Override
    public double calculoMensal() {
        double i = (taxaJurosAnual) / 100 / 12;
        int n = (prazoFinanciamento * 12);
        double fator = Math.pow(1 + i, n);
        return valorImovel * (i * fator) / (fator - 1);
    }

    //Método de Exibição
    public void imprimirDados(){
        System.out.println("\n╔═══════════════════════════════════════════════════╗");
        System.out.println("║      RESUMO DO FINANCIAMENTO DE APARTAMENTO       ║");
        System.out.println("╠═══════════════════════════════════════════════════╣");
        System.out.printf ("║ Vagas na Garagem:    %-28d║\n", vagasGaragem);
        System.out.printf ("║ Número do Andar:     %-28d║\n", numeroAndar);
        System.out.printf ("║ Valor do Imóvel:     R$ %-24.2f║\n", valorImovel);
        System.out.printf ("║ Parcela Mensal:      R$ %-24.2f║\n", calculoMensal());
        System.out.printf ("║ Total a Pagar:       R$ %-24.2f║\n", calcularTotalPagamento());
        System.out.println  ("╚═══════════════════════════════════════════════════╝");
    }
}
