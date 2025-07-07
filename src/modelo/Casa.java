package modelo;

//Sub-Classe Casa
public class Casa extends Financiamento{
    //Atributos
   protected double areaConstruida;
   protected double tamanhoDaCasa;

    //Método Construtor
    public Casa(double valorImovel, int prazoFinanciamentoAnos, double taxaJurosAnual, double areaConstruida, double tamanhoDaCasa) {
        super(valorImovel, prazoFinanciamentoAnos, taxaJurosAnual);
        this.areaConstruida = areaConstruida;
        this.tamanhoDaCasa = tamanhoDaCasa;
    }

    //Método de Pagamento Total
    public double calcularTotalPagamento(){
        return calculoMensal() * prazoFinanciamento * 12;
    }

    //Método de Pagamento Mensal Casa
    @Override
    public double calculoMensal() {
        double parcelaBase = (valorImovel / (prazoFinanciamento * 12)) * (1 + (taxaJurosAnual / 100 / 12));
        double parcelaComTaxa = parcelaBase + 80;
        return parcelaComTaxa;
    }

    //Método de Exibição
    public void imprimirDados(){
        System.out.println("\n╔═══════════════════════════════════════════════════╗");
        System.out.println("║         RESUMO DO FINANCIAMENTO DE CASA           ║");
        System.out.println("╠═══════════════════════════════════════════════════╣");
        System.out.printf ("║ Área Construída:     %-24.2f m²║\n", areaConstruida);
        System.out.printf ("║ Tamanho do Terreno:  %-24.2f m²║\n", tamanhoDaCasa);
        System.out.printf ("║ Valor do Imóvel:     R$ %-24.2f║\n", valorImovel);
        System.out.printf ("║ Parcela Mensal:      R$ %-24.2f║\n", calculoMensal());
        System.out.printf ("║ Total a Pagar:       R$ %-24.2f║\n", calcularTotalPagamento());
        System.out.println  ("╚═══════════════════════════════════════════════════╝");
    }
}
