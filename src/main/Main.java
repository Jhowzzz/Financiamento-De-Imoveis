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
        System.out.println("Digite os dados de um Financiamento ");
            double valor = interfaceUsuario.solicitarValorImovel();
            int prazo = interfaceUsuario.solicitarPrazoFinanciamento();
            double taxa = interfaceUsuario.solicitarTaxaJurosAnual();

            //Objetos
            Financiamento casa1 = new Casa(300000, 20, 9.5);
            Financiamento casa2 = new Casa(280000, 15, 8.9);
            Financiamento ap1 = new Apartamento(250000, 25, 10.0);
            Financiamento ap2 = new Apartamento(220000, 30, 9.0);
            Financiamento terreno = new Terreno(180000, 10, 11.2);
            Financiamento financiamento = new Casa(valor, prazo, taxa);

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
        System.out.println("\n----Resumo Final----");
        System.out.printf("Total dos Imóveis: R$%.2f\n", totalImoveis);
        System.out.printf("Total do Financiamento: R$%.2f\n", totalFinanciamento);
        }
}