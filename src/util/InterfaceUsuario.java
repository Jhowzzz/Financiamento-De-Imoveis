//Package
package util;

//Scanner:
import java.util.InputMismatchException;
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
            if (opcao >= 1 && opcao <= 3) {
                return opcao;
            } else {
                System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }

    //Método escolhido: Casa
    public double solicitarAreaConstruida() {
        return EntradaSegura.lerDouble("Informe a área construída (m²): ");
    }

    //Método escolhido: Casa
    public double solicitarTamanhoTerreno() {
        return EntradaSegura.lerDouble("Informe o tamanho do terreno (m²): ");
    }

    //Método escolhido: Apartamento
    public int solicitarVagasGaragem() {
        return EntradaSegura.lerInt("Informe o número de vagas da garagem: ");
    }

    //Método escolhido: Apartamento
    public int solicitarNumeroAndar() {
        return EntradaSegura.lerInt("Informe o número do andar: ");
    }

    //Informações do Método escolhido: Terreno
    public String solicitarTipoZona() {
        return EntradaSegura.lerLinha("Informe o tipo de zona (residencial/comercial): ");
    }

    //Solicita o valor do Imóvel:
    public double solicitarValorImovel() {
        //Validação dos dados de entrada:
        while (true) {
            try {
                System.out.print("Valor do Imóvel: R$");
                valorImovel = scanner.nextDouble();

                if (valorImovel > 0) {
                    return valorImovel;
                } else {
                    System.out.println("Erro! O valor deve ser maior que zero.");
                }

            } catch (InputMismatchException erro) {
                System.out.println("Erro: valor inválido! Digite um número válido.");
                scanner.nextLine();
            } catch (Exception erro) {
                System.out.println("Erro: " + erro.getMessage());
                scanner.nextLine();
            }
        }
    }

    //Solicita o prazo do Financiamento:
    public int solicitarPrazoFinanciamento() {
        //Validação dos dados de entrada:
        return EntradaSegura.lerIntEntreIntervalo("Prazo do Financiamento(em anos): ", 1, 50);
    }

    //Solicita à da taxa de juros anual:
    public double solicitarTaxaJurosAnual() {
        //Validação dos dados de entrada:
        return EntradaSegura.lerDoubleIntervalo("Taxa de Juros Anual (sem %): ", 0, 100);
    }
}