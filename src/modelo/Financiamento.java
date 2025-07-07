//Package
package modelo;

//Super-Classe Financiamento:
public abstract class Financiamento {

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
    public Financiamento(double valorImovel, int prazoFinanciamentoAnos, double taxaJurosAnual) {

        this.valorImovel = valorImovel;
        this.prazoFinanciamento = prazoFinanciamentoAnos;
        this.taxaJurosAnual = taxaJurosAnual;
    }

    //Método de Pagamento Mensal
    public abstract double calculoMensal();

    //Método de Pagamento Total
    public abstract double calcularTotalPagamento();

    //Método de Exibição
    public abstract void imprimirDados();
}