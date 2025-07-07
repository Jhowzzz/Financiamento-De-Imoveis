//Importa às classes dos packeges:
package main;
import modelo.Financiamento;
import modelo.Casa;
import modelo.Apartamento;
import modelo.Terreno;
import util.InterfaceUsuario;

//Importa às listas:
import java.util.ArrayList;
import java.util.List;

//Inicio
class Main {
    public static void main(String[] args) {

        //Objeto:
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();

        //Lista dos quatro financiamentos:
        List<Financiamento> listaFinanciamento = new ArrayList<Financiamento>();

        //Solicitação de Dados Financiamento
            int tipo = interfaceUsuario.solicitarTipoFinanciamento();

            double valor = interfaceUsuario.solicitarValorImovel();
            int prazo = interfaceUsuario.solicitarPrazoFinanciamento();
            double taxa = interfaceUsuario.solicitarTaxaJurosAnual();

            //Objetos
            Financiamento casa1 = new Casa(300000, 20, 9.5, 120.0, 250.0);
            Financiamento casa2 = new Casa(280000, 15, 8.9, 100.0, 200.0);
            Financiamento ap1 = new Apartamento(250000, 25, 10.0, 2, 5);
            Financiamento ap2 = new Apartamento(220000, 30, 9.0, 1, 3);
            Financiamento terreno = new Terreno(180000, 10, 11.2, "Comercial");
            Financiamento financiamento;

            switch (tipo) {
                case 1: // Casa
                    double areaConstruida = interfaceUsuario.solicitarAreaConstruida();
                    double tamanhoTerreno = interfaceUsuario.solicitarTamanhoTerreno();
                    financiamento = new Casa(valor, prazo, taxa, areaConstruida, tamanhoTerreno);
                    break;

                case 2: //Apartamento
                    int vagasGaragem = interfaceUsuario.solicitarVagasGaragem();
                    int numeroAndar = interfaceUsuario.solicitarNumeroAndar();
                    financiamento = new Apartamento(valor, prazo, taxa, vagasGaragem, numeroAndar);
                    break;

                case 3: //Terreno
                    String tipoDeZona = interfaceUsuario.solicitarTipoZona();
                    financiamento = new Terreno(valor, prazo, taxa, tipoDeZona);
                    break;
                default:
                    financiamento = null;
            }

            //Adicionando à lista
            listaFinanciamento.add(financiamento);
            listaFinanciamento.add(casa1);
            listaFinanciamento.add(casa2);
            listaFinanciamento.add(ap1);
            listaFinanciamento.add(ap2);
            listaFinanciamento.add(terreno);

        //Soma os valores:
        double totalImoveis = 0;
        double totalFinanciamento = 0;

        for (Financiamento f : listaFinanciamento) {
            totalImoveis += f.getValorImovel();
            totalFinanciamento += f.calcularTotalPagamento();

            System.out.println("\nTipo de financiamento: " + f.getClass().getSimpleName());
            f.imprimirDados();
        }

        //Imprime os dados:
        System.out.println("\n╔═══════════════════════════════════════════════════╗");
        System.out.println("║                  RESUMO FINAL GERAL               ║");
        System.out.println("╠═══════════════════════════════════════════════════╣");
        System.out.printf ("║ Total dos Imóveis:       R$ %-22.2f║\n", totalImoveis);
        System.out.printf ("║ Total do Financiamento:  R$ %-22.2f║\n", totalFinanciamento);
        System.out.println  ("╚═══════════════════════════════════════════════════╝");
        }
}