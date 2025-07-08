package util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EntradaSegura {
    private static Scanner scanner = new Scanner(System.in);

    public static double lerDouble(String mensagem) {
        while (true) {
            try {

                System.out.print(mensagem);
                return scanner.nextDouble();

            } catch (InputMismatchException e) {
                System.out.println("Erro: digite um número decimal válido!");
                scanner.nextLine();

            } catch (Exception erro) {
                System.out.println("Erro: " + erro.getMessage());
                scanner.nextLine();
            }
        }
    }

    public static int lerInt(String mensagem) {
        while (true) {
            try {

                System.out.print(mensagem);
                return scanner.nextInt();

            } catch (InputMismatchException e) {
                System.out.println("Erro: digite um número inteiro válido!");
                scanner.nextLine();

            } catch (Exception erro) {
                System.out.println("Erro: " + erro.getMessage());
                scanner.nextLine();
            }
        }
    }

    public static double lerDoubleMaiorQue(String mensagem, double min) {
        while(true){
            try {

                System.out.print(mensagem);
                double valor = scanner.nextDouble();
                if (valor > min) {
                    return valor;
                } else {
                    System.out.println("Erro! O valor deve ser maior que " + min + ".");
                }

            } catch (InputMismatchException e) {
                System.out.println("Erro: digite um número válido!");
                scanner.nextLine();

            } catch (Exception erro) {
                System.out.println("Erro: " + erro.getMessage());
                scanner.nextLine();
            }
        }
    }

    public static double lerDoubleIntervalo (String mensagem, int min, int max) {
        while(true){
            try {

                System.out.print(mensagem);
                int valor = scanner.nextInt();
                if (valor >= min && valor <= max) {
                    return valor;
                } else {
                    System.out.println("Erro! O valor deve ser maior que " + min + " e menor que " + max + ".");
                }

            } catch (InputMismatchException e) {
                System.out.println("Erro: digite um número inteiro válido!");
                scanner.nextLine();

            } catch (Exception erro) {
                System.out.println("Erro: " + erro.getMessage());
                scanner.nextLine();
            }
        }
    }

    public static int lerIntEntreIntervalo (String mensagem, int min, int max) {
        while(true){
            try {
                System.out.print(mensagem);
                int valor = scanner.nextInt();
                if (valor >= min && valor <= max) {
                    return valor;
                } else {
                    System.out.println("Erro! Digite um valor entre " + min + " e " + max + ".");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: digite um número inteiro válido!");
                scanner.nextLine();

            } catch (Exception erro) {
                System.out.println("Erro: " + erro.getMessage());
                scanner.nextLine();
            }
        }
    }

    public static String lerLinha(String mensagem) {
        System.out.print(mensagem);
        scanner.nextLine();
        return scanner.nextLine();
    }
}