import java.io.*;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class GravadorPersonagem {

    public void gravaLista(ListaPersonagem<Jedi> lista, boolean isCSV, String nomeArquivo) {
        FileWriter arq = null;
        Formatter saida = null;
        boolean deuRuim = false;

        if (isCSV) {
            nomeArquivo += ".csv";
        } else {
            nomeArquivo += ".txt";
        }
        try {
            arq = new FileWriter(nomeArquivo, true);
            saida = new Formatter(arq);
        } catch (IOException erro) {
            System.err.println("Erro ao abrir arquivo");
            System.exit(1);
        }

        try {

            for (int i = 0; i < lista.getTamanho(); i++) {
                Jedi guerreiro = lista.getElemento(i);

                if (guerreiro instanceof LadoMauDaForca) {
                    saida.format("%s;%d;%d;%.2f;%.2f;%.2f;%s;%d;%d%n",
                            guerreiro.getNome(),
                            guerreiro.getIdade(),
                            guerreiro.getQuantidadeLutas(),
                            guerreiro.getForca(),
                            guerreiro.getValorHonra(),
                            ((LadoMauDaForca) guerreiro).getNivelDesequilibrio(),
                            ((LadoMauDaForca) guerreiro).getNomeMestre(),
                            ((LadoMauDaForca) guerreiro).getQuantidadeImperiosEscondidos(),
                            ((LadoMauDaForca) guerreiro).getQuatidadeUsuariosForca());
                }

            }
        } catch (FormatterClosedException erro) {
            System.err.println("Erro ao gravar no arquivo");
            deuRuim = true;
        } finally {
            saida.close();
            try {
                arq.close();
            } catch (IOException erro) {
                System.err.println("Erro ao fechar arquivo.");
                deuRuim = true;
            }
            if (deuRuim) {
                System.exit(1);
            }
        }
    }

    public void leExibeArquivo(String nomeArquivo) {
        FileReader arq = null;
        Scanner entrada = null;
        boolean deuRuim = false;

        nomeArquivo += ".csv";

        try {
            arq = new FileReader(nomeArquivo);

            entrada = new Scanner(arq).useDelimiter(";|\\r\\n");

        } catch (FileNotFoundException erro) {
            System.err.println("Arquivo não encontrado");
            System.exit(1);
        }

        try {
            System.out.printf("%-10s%12s%12s%7s%10s%12s%12s%13s%13s\n", "NOME", "IDADEDOJEDI",
                    "QTDEDELUTAS", "FORCAS", "VALORHONR", "NVLDESEQUIL",
                    "NOMESTRE", "QTDEIMPESCON", "QTDEUSUAFORC");
            while (entrada.hasNext()) {

                String nome = entrada.next();
                Integer idade = entrada.nextInt();
                Integer quantidadeLutas = entrada.nextInt();
                Double forca = entrada.nextDouble();
                Double valorHonra = entrada.nextDouble();
                Double nivelDesequilibrio = entrada.nextDouble();
                String nomeMestre = entrada.next();
                Integer quantidadeImperiosEscondidos = entrada.nextInt();
                Integer quatidadeUsuariosForca = entrada.nextInt();

                System.out.printf("%-10s%12d%12d%7.2f%10.2f%12.2f%12s%13d%13d%n", nome, idade,
                        quantidadeLutas, forca, valorHonra,
                        nivelDesequilibrio, nomeMestre, quantidadeImperiosEscondidos, quatidadeUsuariosForca);
            }

        } catch (NoSuchElementException erro) {
            System.err.println("Arquivo com problemas.");
            deuRuim = true;
        } catch (IllegalStateException erro) {
            System.err.println("Erro na leitura do arquivo.");
            deuRuim = true;
        } finally {
            entrada.close();
            try {
                arq.close();
            } catch (IOException erro) {
                System.err.println("Erro ao fechar arquivo.");
                deuRuim = true;
            }
            if (deuRuim) {
                System.exit(1);
            }
        }
    }

    public void gravaRegistro(String nomeArq, String registro) {
        BufferedWriter saida = null;
        try {
            saida = new BufferedWriter(new FileWriter(nomeArq, true));
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
        }

        try {
            saida.append(registro + "\n");
            saida.close();

        } catch (IOException e) {
            System.err.printf("Erro ao gravar arquivo: %s.\n", e.getMessage());
        }

    }

}


