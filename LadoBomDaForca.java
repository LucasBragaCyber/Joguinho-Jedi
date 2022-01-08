public class LadoBomDaForca extends Jedi {

    private Boolean jediCinza;
    private Double nivelEquilibrio;
    private String corDaForca;
    private String nomeMestre;
    private Integer quatidadeUsuariosForca;

    public LadoBomDaForca(String nome,
                          Integer idade,
                          Integer quantidadeLutas,
                          Double forca,
                          Double valorHonra,
                          Double nivelEquilibrio,
                          String corDaForca,
                          String nomeMestre,
                          Integer quatidadeUsuariosForca) {
        super(nome,
                idade,
                quantidadeLutas,
                forca,
                valorHonra);
        jediCinza = false;
        this.nivelEquilibrio = nivelEquilibrio;
        this.corDaForca = corDaForca;
        this.nomeMestre = nomeMestre;
        this.quatidadeUsuariosForca = quatidadeUsuariosForca;
    }

    public Boolean getJediCinza() {
        return jediCinza;
    }

    public void setJediCinza(Boolean jediCinza) {
        this.jediCinza = jediCinza;
    }

    public Double getNivelEquilibrio() {
        return nivelEquilibrio;
    }

    public void setNivelEquilibrio(Double nivelEquilibrio) {
        this.nivelEquilibrio = nivelEquilibrio;
    }

    public String getCorDaForca() {
        return corDaForca;
    }

    public void setCorDaForca(String corDaForca) {
        this.corDaForca = corDaForca;
    }

    public String getNomeMestre() {
        return nomeMestre;
    }

    public void setNomeMestre(String nomeMestre) {
        this.nomeMestre = nomeMestre;
    }

    public Integer getQuatidadeUsuariosForca() {
        return quatidadeUsuariosForca;
    }

    public void setQuatidadeUsuariosForca(Integer quatidadeUsuariosForca) {
        this.quatidadeUsuariosForca = quatidadeUsuariosForca;
    }

    @Override
    public Double getPoder() {
        Double resultado = ((super.getIdade()) + (super.getQuantidadeLutas()) * 1.80) / 100;
        if (resultado <= 13) {
            return resultado;
        } else {
            jediCinza = true;
            resultado = resultado + quatidadeUsuariosForca;
            return resultado;
        }
    }

    @Override
    public Double getEscalaForca() {
        return ((super.getValorHonra() / super.getForca()) * 30);
    }

    @Override
    public String toString() {
        return super.toString() +
                "Lado Bom da Força{" +
                "jediCinza=" + jediCinza +
                ", nivelEquilibrio=" + nivelEquilibrio +
                ", corDaForca='" + corDaForca + '\'' +
                ", nomeMestre='" + nomeMestre + '\'' +
                ", quatidadeUsuariosForca=" + quatidadeUsuariosForca +
                "} ";
    }
}

