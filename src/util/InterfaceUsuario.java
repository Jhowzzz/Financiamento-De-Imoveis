//Package
package util;

//Scanner:
import java.util.Scanner;

//Classe Interface
public class InterfaceUsuario {
    Scanner scanner = new Scanner(System.in);
    //Atributos
    double valorImovel;

    //Solicitar Tipo do Financiamento:
    public int solicitarTipoFinanciamento() {
        while (true) {
            System.out.println("\n╔══════════════════════════════════════╗");
            System.out.println("║        TIPOS DE FINANCIAMENTO        ║");
            System.out.println("╠══════════════════════════════════════╣");
            System.out.println("║  1 - Casa                            ║");
            System.out.println("║  2 - Apartamento                     ║");
            System.out.println("║  3 - Terreno                         ║");
            System.out.println("╚══════════════════════════════════════╝");
            System.out.print(">>  Digite a sua opção: ");
            int opcao = scanner.nextInt();
            if(opcao >= 1 && opcao <= 3) {
                return opcao;
            }else {
                System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }

    //Informações do Método escolhido:
    public double solicitarAreaConstruida() {
        System.out.print("Informe a área construída (m²): ");
        return scanner.nextDouble();
    }

    public double solicitarTamanhoTerreno() {
        System.out.print("Informe o tamanho do terreno (m²): ");
        return scanner.nextDouble();
    }

    public int solicitarVagasGaragem() {
        System.out.print("Informe o número de vagas da garagem: ");
        return scanner.nextInt();
    }

    public int solicitarNumeroAndar() {
        System.out.print("Informe o número do andar: ");
        return scanner.nextInt();
    }

    public String solicitarTipoZona() {
        scanner.nextLine(); // Consumir o \n pendente
        System.out.print("Informe o tipo de zona (residencial/comercial): ");
        return scanner.nextLine();
    }

    //Solicita o valor do Imóvel:
    public double solicitarValorImovel() {

        //Validação dos dados de entrada:
        while (true) {
            System.out.print("Valor do Imóvel: R$");
            valorImovel = scanner.nextDouble();

            if (valorImovel > 0) {
                return valorImovel;
            }else {
                System.out.println("Erro! O valor digitado deve ser maior que zero.");
                System.out.println("Tente novamente.\n");
            }
        }
    }
    //Solicita o prazo do Financiamento:
    public int solicitarPrazoFinanciamento() {

        //Validação dos dados de entrada:
        while (true) {
            System.out.print("Prazo do Financiamento(em anos): ");
            int prazoFinanciamento = scanner.nextInt();

            if (prazoFinanciamento > 0 && prazoFinanciamento <= 50) {
                return prazoFinanciamento;
            } else {
                System.out.println("Erro! O prazo deve estar entre 1 à 50 anos. ");
                System.out.println("Tente novamente!\n");
            }
        }
    }

    //Solicita à da taxa de juros anual:
    public double solicitarTaxaJurosAnual() {

        //Validação dos dados de entrada:
        while (true) {

            System.out.print("Taxa de Juros Anual(sem %): ");
            double taxaJurosAnual = scanner.nextDouble();

            if (taxaJurosAnual > 0 && taxaJurosAnual < 100) {
                return taxaJurosAnual;
            } else {
                System.out.println("Erro! A taxa deve ser maior que 0 e menor que 100.");
                System.out.println("Tente novamente.\n");
            }
        }
    }
}
