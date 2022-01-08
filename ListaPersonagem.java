public class ListaPersonagem<T> {

    private T[] vetor;
    int nroElem;

    public ListaPersonagem(int tam) {
        this.vetor = (T[]) new Object[tam];
        this.nroElem = 0;
    }

    public boolean adiciona(T valor) {
        if (nroElem >= vetor.length) {
            System.out.println("Personagem não adicionado!");
            return false;
        } else {
            vetor[nroElem++] = valor;
            System.out.println("Personagem adicionado com sucesso!");
            return true;
        }
    }

    public void exibe() {
        for (int i = 0; i < nroElem; i++) {
            System.out.println(vetor[i]);
        }
    }

    public int getTamanho() {
        return nroElem;
    }

    public T getElemento(int indice) {
        if (indice < 0 || indice >= nroElem) {
            System.out.println("Índice inválido");
            return null;
        } else {
            T elemento = null;
            for (int i = 0; i < nroElem; i++) {
                if (i == indice) {
                    elemento = vetor[i];
                }
            }
            return elemento;
        }
    }

}
