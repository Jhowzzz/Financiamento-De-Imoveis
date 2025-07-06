package modelo;

//Sub-Classe Apartamento
public class Apartamento extends Financiamento{
    //Atributos
    protected double taxaMensal;
    //Método Construtor
    public Apartamento(double valorImovel, int prazoFinanciamentoAnos, double taxaJurosAnual) {
        super(valorImovel, prazoFinanciamentoAnos, taxaJurosAnual);
    }

    //Método de Calculo PRICE
    @Override
    public double calculoMensal() {
        double i = (taxaJurosAnual) / 100 / 12;
        int n = (prazoFinanciamento * 12);
        double fator = Math.pow(1 + i, n);

        return valorImovel * (i * fator) / (fator - 1);
    }
}
