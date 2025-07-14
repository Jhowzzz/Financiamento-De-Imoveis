//Importa às classes dos packeges:
package main;
import modelo.Financiamento;
import modelo.Casa;
import modelo.Apartamento;
import modelo.Terreno;
import util.ArquivoUtil;
import util.InterfaceUsuario;
import java.util.Scanner;

//Importa às listas:

import java.util.ArrayList;
import java.util.List;

//Inicio
public class Main {
    public static void main(String[] args) {
        List<Financiamento> lista = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        InterfaceUsuario iu = new InterfaceUsuario();

        boolean continuar = true;
        while (continuar) {
            int opcao = iu.solicitarTipoFinanciamento();

            double valor = iu.solicitarValorImovel();
            int prazo = iu.solicitarPrazoFinanciamento();
            double taxa = iu.solicitarTaxaJurosAnual();

            Financiamento financiamento = null;

            if (opcao == 1) { //Casa
                double area = iu.solicitarAreaConstruida();
                double terreno = iu.solicitarTamanhoTerreno();
                financiamento = new Casa(valor, prazo, taxa, area, terreno);

            } else if (opcao == 2) {
                int vagasGaragem = iu.solicitarVagasGaragem();
                int numeroAndar = iu.solicitarNumeroAndar();
                financiamento = new Apartamento(valor, prazo, taxa, vagasGaragem, numeroAndar);

            } else if (opcao == 3) { //Terreno
                String tipoZona = iu.solicitarTipoZona();
                financiamento = new Terreno(valor, prazo, taxa, tipoZona);
            }

            lista.add(financiamento);

            System.out.print("\nDeseja cadastrar outro financiamento? (s/n): ");
            String resposta = scanner.nextLine().toLowerCase();
            scanner.nextLine();
            System.out.println();
            if (!resposta.equals("s")) {
                continuar = false;
            }
            // 1. Salvar como texto
            ArquivoUtil.salvarComoTexto(lista, "financiamentos.txt");

            // 2. Ler para conferir
            ArquivoUtil.lerTexto("financiamentos.txt");

            // 3. Serializar o ArrayList
            ArquivoUtil.salvarSerializado(lista, "financiamentos.dat");

            // 4. Ler novamente o ArrayList serializado
            List<Financiamento> recuperados = ArquivoUtil.lerSerializado("financiamentos.dat");
            if (recuperados != null) {
                System.out.println("\n--- FINANCIAMENTOS DESSERIALIZADOS ---");
                for (Financiamento f : recuperados) {
                    f.imprimirDados();
                }
            }
        }
    }
}
