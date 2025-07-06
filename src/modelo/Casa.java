package modelo;

//Sub-Classe Casa
public class Casa extends Financiamento{

    //Método Construtor
    public Casa(double valorImovel, int prazoFinanciamentoAnos, double taxaJurosAnual) {
        super(valorImovel, prazoFinanciamentoAnos, taxaJurosAnual);
    }

    //Método de Pagamento Mensal Casa
    @Override
    public double calculoMensal() {
        return super.calculoMensal() + 80;
    }
}
