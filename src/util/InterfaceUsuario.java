//Package
package util;

//Scanner:
import java.util.Scanner;

//Classe Interface
public class InterfaceUsuario {
    Scanner scanner = new Scanner(System.in);
    double valorImovel;

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
            }else {
                System.out.println("Erro! A taxa deve ser maior que 0 e menor que 100.");
                System.out.println("Tente novamente.\n");
        }
        }
    }
}
