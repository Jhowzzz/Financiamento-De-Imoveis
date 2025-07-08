package util;

import modelo.*;

import java.io.*;
import java.util.List;

public class ArquivoUtil {

    // Salvar como texto
    public static void salvarComoTexto(List<Financiamento> lista, String caminho) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminho))) {
            for (Financiamento f : lista) {
                if (f instanceof Casa c) {
                    bw.write("Casa;" + c.getValorImovel() + ";" + c.getPrazoFinanciamento() + ";"    +
                            c.getTaxaJurosAnual() + ";" + c.getAreaConstruida() + ";" + c.getTamanhoDaCasa());
                } else if (f instanceof Apartamento a) {
                    bw.write("Apartamento;" + a.getValorImovel() + ";" + a.getPrazoFinanciamento() + ";" +
                            a.getTaxaJurosAnual() + ";" + a.getNumeroAndar() + ";" + a.getVagasGaragem());
                } else if (f instanceof Terreno t) {
                    bw.write("Terreno;" + t.getValorImovel() + ";" + t.getPrazoFinanciamento() + ";" +
                            t.getTaxaJurosAnual() + ";" + t.getTipoDeZona());
                }
                bw.newLine();
            }
            System.out.println("Dados salvos em: " + caminho);
        } catch (IOException e) {
            System.out.println("Erro ao salvar .txt: " + e.getMessage());
        }
    }

    // Ler como texto
    public static void lerTexto(String caminho) {
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha;
            System.out.println("\n--- CONTEÚDO DO ARQUIVO ---");
            while ((linha = br.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler .txt: " + e.getMessage());
        }
    }

    // Serializar
    public static void salvarSerializado(List<Financiamento> lista, String caminho) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(caminho))) {
            out.writeObject(lista);
            System.out.println("ArrayList serializado em: " + caminho);
        } catch (IOException e) {
            System.out.println("Erro ao serializar: " + e.getMessage());
        }
    }

    // Desserializar
    public static List<Financiamento> lerSerializado(String caminho) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(caminho))) {
            return (List<Financiamento>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao desserializar: " + e.getMessage());
            return null;
        }
    }
}