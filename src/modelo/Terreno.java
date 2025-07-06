package modelo;

//Sub-Classe Terreno
public class Terreno extends Financiamento{

    //Método Construtor
    public Terreno(double valorImovel, int prazoFinanciamentoAnos, double taxaJurosAnual) {
        super(valorImovel, prazoFinanciamentoAnos, taxaJurosAnual);
    }

    //Método Calculo Pagamento de Terreno
    @Override
    public double calculoMensal() {
        double parcelaBase = super.calculoMensal();
        double parcelaComAcrescimo = parcelaBase * 1.02;

        return parcelaComAcrescimo;
    }
}
