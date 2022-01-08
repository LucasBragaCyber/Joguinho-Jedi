public class LadoMauDaForca extends Jedi {

    private Boolean jediCinza;
    private Double nivelDesequilibrio;
    private String nomeMestre;
    private Integer quantidadeImperiosEscondidos;
    private Integer quatidadeUsuariosForca;

    public LadoMauDaForca(String nome,
                          Integer idade,
                          Integer quantidadeLutas,
                          Double forca,
                          Double valorHonra,
                          Double nivelDesequilibrio,
                          String nomeMestre,
                          Integer quantidadeImperiosEscondidos,
                          Integer quatidadeUsuariosForca) {
        super(nome,
                idade,
                quantidadeLutas,
                forca,
                valorHonra);
        jediCinza = false;
        this.nivelDesequilibrio = nivelDesequilibrio;
        this.nomeMestre = nomeMestre;
        this.quantidadeImperiosEscondidos = quantidadeImperiosEscondidos;
        this.quatidadeUsuariosForca = quatidadeUsuariosForca;
    }

    public Boolean getJediCinza() {
        return jediCinza;
    }

    public void setJediCinza(Boolean jediCinza) {
        this.jediCinza = jediCinza;
    }

    public Double getNivelDesequilibrio() {
        return nivelDesequilibrio;
    }

    public void setNivelDesequilibrio(Double nivelDesequilibrio) {
        this.nivelDesequilibrio = nivelDesequilibrio;
    }

    public String getNomeMestre() {
        return nomeMestre;
    }

    public void setNomeMestre(String nomeMestre) {
        this.nomeMestre = nomeMestre;
    }

    public Integer getQuantidadeImperiosEscondidos() {
        return quantidadeImperiosEscondidos;
    }

    public void setQuantidadeImperiosEscondidos(Integer quantidadeImperiosEscondidos) {
        this.quantidadeImperiosEscondidos = quantidadeImperiosEscondidos;
    }

    public Integer getQuatidadeUsuariosForca() {
        return quatidadeUsuariosForca;
    }

    public void setQuatidadeUsuariosForca(Integer quatidadeUsuariosForca) {
        this.quatidadeUsuariosForca = quatidadeUsuariosForca;
    }

    @Override
    public Double getPoder() {
        Double resultado = ((super.getIdade() * super.getValorHonra()) + (super.getQuantidadeLutas()) * 3.80) / 200;
        if (resultado <= 13) {
            return resultado;
        } else {
            jediCinza = true;
            resultado = resultado + quantidadeImperiosEscondidos;
            return resultado;
        }
    }

    @Override
    public Double getEscalaForca() {
        return ((getPoder() / super.getForca()) * 30);
    }

    @Override
    public String toString() {
        return super.toString() +
                "Lado Mau da Força {" +
                "jediCinza =" + jediCinza +
                ", nivelDesequilibrio =" + nivelDesequilibrio +
                ", nomeMestre ='" + nomeMestre + '\'' +
                ", quantidadeImperiosEscondidos ='" + quantidadeImperiosEscondidos + '\'' +
                ", quatidadeUsuariosForca =" + quatidadeUsuariosForca +
                "} ";
    }
}