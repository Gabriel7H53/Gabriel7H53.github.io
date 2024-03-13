package entidade;

public class FilmeProvedoraStreaming extends Filme {

    public enum ProvedoraStreaming {
        NetFlix, AmazonPrimeVideo, HBOGo, GooglePlayStores
    };

    public enum Producao {
        filme, serie
    };

    private ProvedoraStreaming provedora;
    private Producao producao;
    private int totalEpisodios;

    public FilmeProvedoraStreaming(int sequencial, String titulo, Genero genero, int ano, ProvedoraStreaming provedora, Producao producao, int totalEpisodios) {
        super(sequencial, titulo, genero, ano);
        this.provedora = provedora;
        this.producao = producao;
        this.totalEpisodios = totalEpisodios;
    }

    public FilmeProvedoraStreaming(int sequencial, String titulo, ProvedoraStreaming provedora, Producao producao, int totalEpisodios) {
        super(sequencial, titulo);
        this.provedora = provedora;
        this.producao = producao;
        this.totalEpisodios = totalEpisodios;
    }

    

    public ProvedoraStreaming getProvedora() {
        return provedora;
    }

    public void setProvedora(ProvedoraStreaming provedora) {
        this.provedora = provedora;
    }

    public Producao getProducao() {
        return producao;
    }

    public void setProducao(Producao producao) {
        this.producao = producao;
    }

    public int getTotalEpisodios() {
        return totalEpisodios;
    }

    public void setTotalEpisodios(int totalEpisodios) {
        this.totalEpisodios = totalEpisodios;
    }

}
