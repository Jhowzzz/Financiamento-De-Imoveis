package modelo;

public class Casa extends Financiamento {
    protected double areaConstruida;
    protected double tamanhoDaCasa;

    public Casa(double valorImovel, int prazoFinanciamentoAnos, double taxaJurosAnual, double areaConstruida, double tamanhoDaCasa) {
        super(valorImovel, prazoFinanciamentoAnos, taxaJurosAnual);
        this.areaConstruida = areaConstruida;
        this.tamanhoDaCasa = tamanhoDaCasa;
    }

    public double calcularTotalPagamento() {
        try {
            return calculoMensal() * prazoFinanciamento * 12;
        } catch (AumentoMaiorDoQueJurosException e) {
            System.out.println("Erro no cálculo: " + e.getMessage());
            return 0;
        }
    }

    @Override
    public double calculoMensal() throws AumentoMaiorDoQueJurosException {
        double parcelaBase = (valorImovel / (prazoFinanciamento * 12));
        double jurosMensal = parcelaBase * (taxaJurosAnual / 100 / 12);
        double parcelaComJuros = parcelaBase + jurosMensal;

        double aumento = 80.0;

        if (aumento > (jurosMensal / 2)) {
            throw new AumentoMaiorDoQueJurosException("Acréscimo de R$ 80,00 é maior que metade dos juros mensais (R$ " + (jurosMensal / 2) + ")");
        }

        return parcelaComJuros + aumento;
    }

    public double getAreaConstruida() {
        return areaConstruida;
    }

    public double getTamanhoDaCasa() {
        return tamanhoDaCasa;
    }

    public void imprimirDados() {
        System.out.println("\n╔═══════════════════════════════════════════════════╗");
        System.out.println("║         RESUMO DO FINANCIAMENTO DE CASA           ║");
        System.out.println("╠═══════════════════════════════════════════════════╣");
        System.out.printf("║ Área Construída:     %-24.2f m²║\n", areaConstruida);
        System.out.printf("║ Tamanho do Terreno:  %-24.2f m²║\n", tamanhoDaCasa);
        System.out.printf("║ Valor do Imóvel:     R$ %-24.2f║\n", valorImovel);

        try {
            double parcela = calculoMensal();
            double total = calcularTotalPagamento();
            System.out.printf("║ Parcela Mensal:      R$ %-24.2f║\n", parcela);
            System.out.printf("║ Total a Pagar:       R$ %-24.2f║\n", total);
        } catch (AumentoMaiorDoQueJurosException e) {
            String msg = "Cálculo não realizado: acréscimo R$ 80,00 inválido";
            System.out.printf("║ %-48s║\n", msg);
        }

        System.out.println("╚═══════════════════════════════════════════════════╝");
    }
}