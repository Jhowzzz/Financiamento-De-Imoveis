//Package
package modelo;

//Super-Classe Financiamento:
public class Financiamento {

    //Atributos
    protected double valorImovel;
    protected int prazoFinanciamento;
    protected double taxaJurosAnual;

    //Impressão dos atributos privados
    public double getValorImovel() {
        return valorImovel;
    }

    public int getPrazoFinanciamento() {
        return prazoFinanciamento;
    }

    public double getTaxaJurosAnual() {
        return taxaJurosAnual;
    }

    //Método Construtor
    public Financiamento(double valorImovel, int prazoFinanciamentoAnos, double taxaJurosAnual){

        this.valorImovel = valorImovel;
        this.prazoFinanciamento = prazoFinanciamentoAnos;
        this.taxaJurosAnual = taxaJurosAnual;
    }

    //Método de Pagamento Mensal
    public double calculoMensal(){
        return (valorImovel / (prazoFinanciamento * 12)) * (1 + (taxaJurosAnual / 100 / 12));
    }

    //Método de Pagamento Total
    public double calcularTotalPagamento() {
        return calculoMensal() * prazoFinanciamento * 12;
    }

    //Método de Exibição
    public void imprimirDados() {
        System.out.println("\n---- Dados do Financiamento ----");
        System.out.printf("Valor do Imóvel: R$ %.2f\n", valorImovel);
        System.out.printf("Valor Total do Financiamento: R$ %.2f\n", calcularTotalPagamento() );
        System.out.println("");
    }
}