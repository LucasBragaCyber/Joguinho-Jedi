public abstract class Jedi {

    private String nome;
    private Integer idade;
    private Integer quantidadeLutas;
    private Double forca;
    private Double valorHonra;

    public Jedi(String nome,
                Integer idade,
                Integer quantidadeLutas,
                Double forca,
                Double valorHonra) {
        this.nome = nome;
        this.idade = idade;
        this.quantidadeLutas = quantidadeLutas;
        this.forca = forca;
        this.valorHonra = valorHonra;
    }

    public String getNome() {
        return nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public Integer getQuantidadeLutas() {
        return quantidadeLutas;
    }

    public Double getForca() {
        return forca;
    }

    public Double getValorHonra() {
        return valorHonra;
    }

    public abstract Double getPoder();

    public abstract Double getEscalaForca();

    @Override
    public String toString() {
        return "Guerreiro{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", quantidadeLutas=" + quantidadeLutas +
                ", forca=" + forca +
                ", valorHonra=" + valorHonra +
                '}';
    }
}
