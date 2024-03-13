package entidade;

public class FilmeCompanhiaCinematografica extends Filme{
    private boolean oscarMelhorFilme;
    private String oscarMelhorDiretor;
    private String oscarMelhorAtor;
    private String oscarMelhorAtriz;

    public FilmeCompanhiaCinematografica(int sequencial, String titulo, Genero genero, int ano, boolean oscarMelhorFilme, String oscarMelhorDiretor, String oscarMelhorAtor, String oscarMelhorAtriz) {
        super(sequencial, titulo, genero, ano);
        this.oscarMelhorFilme = oscarMelhorFilme;
        this.oscarMelhorDiretor = oscarMelhorDiretor;
        this.oscarMelhorAtor = oscarMelhorAtor;
        this.oscarMelhorAtriz = oscarMelhorAtriz;
    }

    public FilmeCompanhiaCinematografica(boolean oscarMelhorFilme, String oscarMelhorDiretor, String oscarMelhorAtor, String oscarMelhorAtriz, int sequencial, String titulo) {
        super(sequencial, titulo);
        this.oscarMelhorFilme = oscarMelhorFilme;
        this.oscarMelhorDiretor = oscarMelhorDiretor;
        this.oscarMelhorAtor = oscarMelhorAtor;
        this.oscarMelhorAtriz = oscarMelhorAtriz;
    }

    

    public boolean isOscarMelhorFilme() {
        return oscarMelhorFilme;
    }

    public void setOscarMelhorFilme(boolean oscarMelhorFilme) {
        this.oscarMelhorFilme = oscarMelhorFilme;
    }

    public String getOscarMelhorDiretor() {
        return oscarMelhorDiretor;
    }

    public void setOscarMelhorDiretor(String oscarMelhorDiretor) {
        this.oscarMelhorDiretor = oscarMelhorDiretor;
    }

    public String getOscarMelhorAtor() {
        return oscarMelhorAtor;
    }

    public void setOscarMelhorAtor(String oscarMelhorAtor) {
        this.oscarMelhorAtor = oscarMelhorAtor;
    }

    public String getOscarMelhorAtriz() {
        return oscarMelhorAtriz;
    }

    public void setOscarMelhorAtriz(String oscarMelhorAtriz) {
        this.oscarMelhorAtriz = oscarMelhorAtriz;
    }
    
    
}
