import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Teste {

    public static void main(String[] args) {
        boolean fim = false;
        //Personagem
        String nome;
        Integer idade;
        Integer quantidadeLutas;
        Double forca;
        Double valorHonra;

        //LadoBom
        Double nivelEquilibrio;
        String corDaForca;
        String nomeMestre;
        Integer quatidadeUsuariosForca;

        //LadoMau
        Double nivelDesequilibrio;
        String nomeMestreMau;
        Integer quantidadeImperiosEscondidos;
        Integer quatidadeUsuariosForcaMau;

        int contRegDados = 0;
        int contRegDadosDois = 0;

        String nomeArq = "ArquivoDeLayout.txt";
        String header = "";
        String corpo = "";
        String trailer = "";

        ListaPersonagem<Jedi> lista = new ListaPersonagem<>(15);
        GravadorPersonagem gravadorJedi = new GravadorPersonagem();

        Scanner leitor = new Scanner(System.in);
        Scanner leitorNum = new Scanner(System.in);

        while (!fim) {
            int opcao = 0;
                // MENU
            System.out.println("1. Adicionar um lado bom da força");
            System.out.println("2. Adicionar um lado mau da força");
            System.out.println("3. Exibir a lista");
            System.out.println("4. Exibir apenas o lado bom da força");
            System.out.println("5. Mostrar informações de ambos os lados da força"); // Execução da implementação do método abstrato
            System.out.println("6. Gravar CSV da classe lado mau da força");
            System.out.println("7. Ler CSV dos métodos do item 6");
            System.out.println("8. Gravar TXT da lista, segundo documento de layout");
            System.out.println("9. Fim");
            System.out.println();

            System.out.println("Escolha uma opção:");
            opcao = leitorNum.nextInt();

            switch (opcao) {
                case 1:

                    System.out.println("Digite o nome do personagem:");
                    nome = leitor.next();
                    System.out.println("Digite a idade do personagem:");
                    idade = leitorNum.nextInt();
                    System.out.println("Digite a quantidade de lutas do personagem:");
                    quantidadeLutas = leitorNum.nextInt();
                    System.out.println("Digite o valor da forca personagem:");
                    forca = leitorNum.nextDouble();
                    System.out.println("Digite o valor da honra do personagem:");
                    valorHonra = leitorNum.nextDouble();
                    System.out.println("Digite o valor do equilibrio do lado bom da força:");
                    nivelEquilibrio = leitorNum.nextDouble();
                    System.out.println("Digite a cor da força do personagem:");
                    corDaForca = leitor.next();
                    System.out.println("Digite o nome do mestre do personagem:");
                    nomeMestre = leitor.next();
                    System.out.println("Digite quantidade de usuários do lado bom da força:");
                    quatidadeUsuariosForca = leitorNum.nextInt();

                    lista.adiciona(new LadoBomDaForca(nome, idade, quantidadeLutas, forca,
                            valorHonra, nivelEquilibrio, corDaForca, nomeMestre, quatidadeUsuariosForca));

                    System.out.println();

                    break;

                case 2:

                    System.out.println("Digite o nome do personagem:");
                    nome = leitor.next();
                    System.out.println("Digite a idade do personagem:");
                    idade = leitorNum.nextInt();
                    System.out.println("Digite a quantidade de lutas do personagem:");
                    quantidadeLutas = leitorNum.nextInt();
                    System.out.println("Digite o valor da forca personagem:");
                    forca = leitorNum.nextDouble();
                    System.out.println("Digite o valor da honra do personagem:");
                    valorHonra = leitorNum.nextDouble();
                    System.out.println("Digite o nível de desequilíbrio do lado mau da força:");
                    nivelDesequilibrio = leitorNum.nextDouble();
                    System.out.println("Digite o nome do mestre do personagem:");
                    nomeMestreMau = leitor.next();
                    System.out.println("Digite a quantidade de impérios escondidos do lado mau da força:");
                    quantidadeImperiosEscondidos = leitorNum.nextInt();
                    System.out.println("Digite quantidade de usuários do lado mau da força:");
                    quatidadeUsuariosForcaMau = leitorNum.nextInt();

                    lista.adiciona(new LadoMauDaForca(nome, idade, quantidadeLutas, forca,
                            valorHonra, nivelDesequilibrio, nomeMestreMau,
                            quantidadeImperiosEscondidos, quatidadeUsuariosForcaMau));

                    System.out.println();

                    break;

                case 3:

                    System.out.println("Exibindo a lista:");
                    lista.exibe();
                    System.out.println();

                    break;

                case 4:

                    for (int i = 0; i < lista.getTamanho(); i++) {
                        Jedi listaJedi = lista.getElemento(i);
                        if (listaJedi instanceof LadoBomDaForca){
                            lista.exibe();
                        }
                        else{
                            System.out.println("Não há professor nesta lista! \n");
                        }
                    }
                    System.out.println();

                    break;

                case 5:

                    System.out.println("Mostrando informações do lado bom da força: \n");

                    for (int i = 0; i < lista.getTamanho(); i++) {
                        Jedi listaJedi = lista.getElemento(i);
                        if (listaJedi instanceof LadoBomDaForca) {
                            System.out.println(String.format("Dados do poder do Jedi do lado bom da força: %.2f", listaJedi.getPoder()));
                            System.out.println(String.format("Dados a escala da força do Jedi do lado bom da força: %.2f", listaJedi.getEscalaForca()));
                        }
                    }

                    System.out.println();
                    System.out.println("Mostrando informações do lado mau da força: \n");

                    for (int i = 0; i < lista.getTamanho(); i++) {
                        Jedi listaJedi = lista.getElemento(i);
                        if (listaJedi instanceof LadoMauDaForca) {
                            System.out.println(String.format("Dados do poder do Jedi do lado mau da força: %.2f", listaJedi.getPoder()));
                            System.out.println(String.format("Dados a escala da força do Jedi do lado mau da força: %.2f", listaJedi.getEscalaForca()));
                        }
                    }

                    System.out.println();

                    break;

                case 6:

                    for (int i = 0; i < lista.getTamanho(); i++) {
                        Jedi listaJedi = lista.getElemento(i);
                        if (listaJedi instanceof LadoMauDaForca) {
                            gravadorJedi.gravaLista(lista, true, "ListaLadoMauDaForca");

                        }
                    }

                    break;

                case 7:

                    gravadorJedi.leExibeArquivo("ListaLadoMauDaForca");
                    System.out.println();

                    break;

                case 8:

                    Date dataDeHojeTXT = new Date();
                    SimpleDateFormat formatterTXT = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

                    header += "00JEDI";
                    header += formatterTXT.format(dataDeHojeTXT);
                    header += "01";

                    gravadorJedi.gravaRegistro(nomeArq, header);

                    for (int i = 0; i < lista.getTamanho(); i++) {
                        Jedi listaJedi = lista.getElemento(i);
                        if (listaJedi instanceof LadoMauDaForca) {
                            corpo = "04";

                            corpo += String.format("%-10s", listaJedi.getNome());
                            corpo += String.format("%3d", listaJedi.getIdade());
                            corpo += String.format("%3d", listaJedi.getQuantidadeLutas());
                            corpo += String.format("%8.2f", listaJedi.getForca());
                            corpo += String.format("%8.2f", listaJedi.getValorHonra());
                            corpo += String.format("%7.2f", ((LadoMauDaForca) listaJedi).getNivelDesequilibrio());
                            corpo += String.format("%12s", ((LadoMauDaForca) listaJedi).getNomeMestre());
                            corpo += String.format("%4d", ((LadoMauDaForca) listaJedi).getQuantidadeImperiosEscondidos());
                            corpo += String.format("%4d", ((LadoMauDaForca) listaJedi).getQuatidadeUsuariosForca());
                            contRegDados++;

                            gravadorJedi.gravaRegistro("ArquivoDeLayout.txt", corpo);

                        }else {
                            corpo = "02";

                            corpo += String.format("%-10s", listaJedi.getNome());
                            corpo += String.format("%3d", listaJedi.getIdade());
                            corpo += String.format("%3d", listaJedi.getQuantidadeLutas());
                            corpo += String.format("%8.2f", listaJedi.getForca());
                            corpo += String.format("%8.2f", listaJedi.getValorHonra());
                            corpo += String.format("%7.2f", ((LadoBomDaForca) listaJedi).getNivelEquilibrio());
                            corpo += String.format("%12s", ((LadoBomDaForca) listaJedi).getCorDaForca());
                            corpo += String.format("%-12s", ((LadoBomDaForca) listaJedi).getNomeMestre());
                            corpo += String.format("%4d", ((LadoBomDaForca) listaJedi).getQuatidadeUsuariosForca());
                            contRegDadosDois++;

                            gravadorJedi.gravaRegistro("ArquivoDeLayout.txt", corpo);
                        }
                    }

                    System.out.println();

                    break;

                case 9:

                    fim = true;

                    trailer += "01";
                    trailer += String.format("%05d", contRegDados);
                    trailer += String.format("%05d", contRegDadosDois);
                    gravadorJedi.gravaRegistro(nomeArq,
                            trailer);
                    System.out.println("Programa encerrado");

                    break;

                default:

                    System.out.println("Opção inválida!");
                    System.out.println();

                    break;

            }
        }
    }


}