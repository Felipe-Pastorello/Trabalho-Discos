import java.util.ArrayList;
import java.util.List;

public class Catalogo {
    private List<Album> albuns;

    public Catalogo() {
        this.albuns = new ArrayList<>();
    }

    public void adicionarAlbum(Album album) {
        albuns.add(album);
    }

    public void removerAlbum(String titulo) {
        boolean encontrado = false;

        for (int i = 0; i < albuns.size(); i++) {
            if (albuns.get(i).getTitulo().equalsIgnoreCase(titulo)) { //IgnoreCase para ignorar as diferenças de maiúsculas e minúsculas
                albuns.remove(i);
                encontrado = true;
                System.out.println("Álbum '" + titulo + "' removido com sucesso.");
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Álbum '" + titulo + "' não encontrado no catálogo.");
        }
    }

    public void listarAlbuns() {
        if (albuns.isEmpty()) {
            System.out.println("Nenhum álbum disponível.");
        } else {
            for (Album album : albuns) {
                System.out.println(album);
                System.out.println("-------------------");
            }
        }
    }

    public Album buscarAlbum(String titulo) {
        for (Album album : albuns) {
            if (album.getTitulo().equalsIgnoreCase(titulo)) {
                return album;
            }
        }
        return null;
    }
}
