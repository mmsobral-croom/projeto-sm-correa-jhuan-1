import esd.ListaSequencial;
import model.ResultadoMercado;
import service.ComparadorService;
import sm.Bistek;
import sm.Fort;
import sm.Giassi;
import sm.Produto;

import java.net.URISyntaxException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws URISyntaxException {

        Scanner sc = new Scanner(System.in);

        ListaSequencial<String> cesta =
                new ListaSequencial<>();

        System.out.println("================================");
        System.out.println("COMPARADOR DE SUPERMERCADOS");
        System.out.println("================================");

        System.out.println("\nDigite os produtos da cesta.");
        System.out.println("Digite 'fim' para terminar.\n");

        // entrada dos produtos
        while (true) {

            System.out.print("Produto: ");

            String produto =
                    sc.nextLine();

            // termina
            if (produto.equalsIgnoreCase("fim")) {
                break;
            }

            // evita vazio
            if (produto.isBlank()) {

                System.out.println(
                        "Digite um produto valido."
                );

                continue;
            }

            cesta.adiciona(produto);
        }

        // verifica cesta vazia
        if (cesta.comprimento() == 0) {

            System.out.println(
                    "\nNenhum produto informado."
            );

            return;
        }

        ComparadorService comparador =
                new ComparadorService();

        ListaSequencial<ResultadoMercado>
                resultados =
                new ListaSequencial<>();

        // compara mercados
        resultados.adiciona(
                comparador.comparar(
                        "Giassi",
                        new Giassi(),
                        cesta
                )
        );

        resultados.adiciona(
                comparador.comparar(
                        "Fort Atacadista",
                        new Fort(),
                        cesta
                )
        );

        resultados.adiciona(
                comparador.comparar(
                        "Bistek",
                        new Bistek(),
                        cesta
                )
        );

        // ordena pelo menor preco
        resultados.ordena();

        System.out.println("\n================================");
        System.out.println("RANKING DOS MERCADOS");
        System.out.println("================================");

        // mostra ranking
        for (int i = 0;
             i < resultados.comprimento();
             i++) {

            ResultadoMercado r =
                    resultados.obtem(i);

            System.out.println(
                    "\n" + (i + 1) + " lugar"
            );

            System.out.println(
                    "Mercado: " +
                            r.getNomeMercado()
            );

            System.out.printf(
                    "Total: R$ %.2f%n",
                    r.getTotal()
            );

            System.out.println("\nProdutos encontrados:");

            // produtos encontrados
            for (int j = 0;
                 j < r.getProdutos().comprimento();
                 j++) {

                Produto p =
                        r.getProdutos().obtem(j);

                System.out.printf(
                        "- %s | R$ %.2f%n",
                        p.getNome(),
                        p.getPreco()
                );
            }

            // nao encontrados
            if (r.getNaoEncontrados()
                    .comprimento() > 0) {

                System.out.println(
                        "\nNao encontrados:"
                );

                for (int j = 0;
                     j < r.getNaoEncontrados()
                             .comprimento();
                     j++) {

                    System.out.println(
                            "- " +
                                    r.getNaoEncontrados()
                                            .obtem(j)
                    );
                }
            }

            System.out.println(
                    "\n----------------------------"
            );
        }

        sc.close();
    }
}