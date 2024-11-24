import java.util.ArrayList;
import java.util.List;

public class Album {
    private String titulo;
    private int anoLancamento;
    private List<String> faixas;
    private Artista artista;

    public Album(String titulo, int anoLancamento, Artista artista) {
        this.titulo = titulo;
        this.anoLancamento = anoLancamento;
        this.faixas = new ArrayList<>();
        this.artista = artista;
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public List<String> getFaixas() {
        return faixas;
    }
    public void adicionarFaixa(String faixa) {
        this.faixas.add(faixa);
    }

    public Artista getArtista() {
        return artista;
    }
    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    @Override
    public String toString() {
        return "Album: " + titulo + " (" + anoLancamento + ")"
                + "\nArtista: " + artista.getNome()
                + "\n Gênero Musical: " + artista.getGeneroMusical()
                + "\nFaixas: " + faixas;
    }
}
