package modelo;

//Sub-Classe Terreno
public class Terreno extends Financiamento{
    //Atributos
    protected String tipoDeZona;

    //Método Construtor
    public Terreno(double valorImovel, int prazoFinanciamentoAnos, double taxaJurosAnual, String tipoDeZona) {
        super(valorImovel, prazoFinanciamentoAnos, taxaJurosAnual);
        this.tipoDeZona = tipoDeZona;
    }

    //Método de Pagamento Mensal Com Acréscimo
    public double calculoMensal() {
        double parcelaBase = (valorImovel / (prazoFinanciamento * 12)) * (1 + (taxaJurosAnual / 100 / 12));
        double parcelaComAcrescimo = parcelaBase * 1.02;
        return parcelaComAcrescimo;
    }

    //Método de Pagamento Total
    public double calcularTotalPagamento(){
        return calculoMensal() * prazoFinanciamento * 12;
    }

    //Método de Exibição
    @Override
    public void imprimirDados(){
        System.out.println("\n╔═══════════════════════════════════════════════════╗");
        System.out.println("║         RESUMO DO FINANCIAMENTO DE TERRENO        ║");
        System.out.println("╠═══════════════════════════════════════════════════╣");
        System.out.printf ("║ Zona do Terreno:     %-28s║\n", tipoDeZona);
        System.out.printf ("║ Valor do Imóvel:     R$ %-24.2f║\n", valorImovel);
        System.out.printf ("║ Parcela Mensal:      R$ %-24.2f║\n", calculoMensal());
        System.out.printf ("║ Total a Pagar:       R$ %-24.2f║\n", calcularTotalPagamento());
        System.out.println  ("╚═══════════════════════════════════════════════════╝");
    }
}
