//Importa às classes dos packeges:
package main;
import modelo.Financiamento;
import modelo.Casa;
import modelo.Apartamento;
import modelo.Terreno;
import util.ArquivoUtil;
import util.InterfaceUsuario;

//Importa às listas:

import java.util.ArrayList;
import java.util.List;

//Inicio
public class Main {
    public static void main(String[] args) {
        List<Financiamento> lista = new ArrayList<>();

        lista.add(new Casa(300000, 20, 6.5, 120, 300));
        lista.add(new Apartamento(250000, 15, 5.2, 3, 2));
        lista.add(new Terreno(200000, 10, 4.8, "Residencial"));

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