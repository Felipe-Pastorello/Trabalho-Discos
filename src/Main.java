import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Catalogo catalogo = new Catalogo();

        while (true) {
            System.out.println("\n1. Cadastrar novo álbum");
            System.out.println("2. Cadastrar novo artista");
            System.out.println("3. Listar álbuns");
            System.out.println("4. Editar álbum");
            System.out.println("5. Remover álbum");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Título do álbum: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Ano de lançamento: ");
                    int ano = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Nome do artista: ");
                    String nomeArtista = scanner.nextLine();
                    System.out.print("Gênero musical do artista: ");
                    String genero = scanner.nextLine();

                    Artista artista = new Artista(nomeArtista, genero);
                    Album album = new Album(titulo, ano, artista);

                    System.out.print("Número de faixas: ");
                    int numFaixas = scanner.nextInt();
                    scanner.nextLine();

                    for (int i = 0; i < numFaixas; i++) {
                        System.out.print("Nome da faixa " + (i + 1) + ": ");
                        String faixa = scanner.nextLine();
                        album.adicionarFaixa(faixa);
                    }
                    catalogo.adicionarAlbum(album);

                    System.out.println("Álbum adicionado com sucesso!");
                    break;

                case 2:
                    System.out.print("Título do álbum para associar o artista: ");
                    String albumTitulo = scanner.nextLine();
                    Album albumExistente = catalogo.buscarAlbum(albumTitulo);

                    if (albumExistente != null) {
                        System.out.print("Nome do novo artista: ");
                        String novoArtistaNome = scanner.nextLine();
                        System.out.print("Gênero musical do novo artista: ");
                        String novoGenero = scanner.nextLine();

                        Artista novoArtista = new Artista(novoArtistaNome, novoGenero);
                        albumExistente.setArtista(novoArtista); //Vai realizar a mudança no álbum específico
                        System.out.println("Álbum alterado com sucesso!");
                    } else {
                        System.out.println("Álbum não encontrado.");
                    }
                    break;

                case 3:
                    catalogo.listarAlbuns();
                    break;

                case 4:
                    System.out.print("Título do álbum para editar: ");
                    String tituloEditar = scanner.nextLine();
                    Album albumParaEditar = catalogo.buscarAlbum(tituloEditar);

                    if (albumParaEditar != null) {
                        System.out.print("Novo título: ");
                        albumParaEditar.setTitulo(scanner.nextLine());
                        System.out.print("Novo ano de lançamento: ");
                        albumParaEditar.setAnoLancamento(scanner.nextInt());
                        scanner.nextLine();

                        System.out.println("Álbum atualizado com sucesso!");
                    } else {
                        System.out.println("Álbum não encontrado.");
                    }
                    break;

                case 5:
                    System.out.print("Título do álbum para remover: ");
                    String tituloRemover = scanner.nextLine();
                    catalogo.removerAlbum(tituloRemover);
                    break;

                case 0:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}