import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {


        Scanner scanNum = new Scanner(System.in);

        Scanner scanStr = new Scanner(System.in);

        CadastroLogin cadastrados = new CadastroLogin();

        Usuario brandao = new Usuario("Fernando Brandão", "fernando", "fernando@brandao");

        Usuario diego = new Usuario("Diego", "diego", "diego123");

        cadastrados.cadastrar(brandao);
        cadastrados.cadastrar(diego);

        Integer opcao = 0;

        Integer opcaoAplicacao = 0;

        Usuario usuarioLogado;

        String quebraDeLinha = "_".repeat(75);

        String novoNome;

        String novoNomeUsuario;

        String novaSenha;

        String nomeAntigo;

        String nomeAntigoUsuario;

        Boolean jaExibiu = false;

        Double aleatorioCPU = ThreadLocalRandom.current().nextDouble(0.0, 100.0);

        Double aleaorioRAM = ThreadLocalRandom.current().nextDouble(0.0, 8.0);

        Double aleatorioDisco = ThreadLocalRandom.current().nextDouble(0.0, 999.9);


        do {
            System.out.println("""
                    O que deseja fazer?
                    
                    1 - Login
                    2 - Sair
                    """);
            opcao = scanNum.nextInt();

            if (opcao == 1) {

                System.out.println("Digite seu usuario:");
                String usuario = scanStr.nextLine();

                System.out.println("Digite sua senha:");
                String senha = scanStr.nextLine();

                usuarioLogado = cadastrados.login(usuario, senha);

                if (usuarioLogado != null){
                    System.out.println(
                    """
                    Login realizado com sucesso! 
                    Redirecionando para a aplicação
                    """);


                    do{
                        if (jaExibiu == false) {
                            System.out.println(
                                    """
                                            %s
                                            Seja Bem-Vindo a aplicação do BankSecure
                                                                                
                                            Selecione uma das opções que deseja fazer 
                                                                                
                                            Opção 1 - Alterar seu nome
                                            Opção 2 - Alterar seu nome de usuário 
                                            Opção 3 - Alterar sua senha
                                            Opção 4 - Monitorar dados de máquinas
                                            Opção 5 - Voltar ao login
                                            """.formatted(quebraDeLinha));
                        }

                        opcaoAplicacao = scanNum.nextInt();


                        if(opcaoAplicacao.equals(1)){
                            nomeAntigo = usuarioLogado.getNome();

                            System.out.println("Digite seu novo Nome: ");

                            novoNome = scanStr.nextLine();

                            usuarioLogado.setNome(novoNome);

                            System.out.println(
                            """
                            Seu nome foi altarado
                            Era: %s
                            Foi para %s
                            """.formatted(nomeAntigo, novoNome));

                            jaExibiu = false;

                        } else if (opcaoAplicacao.equals(2)) {
                            nomeAntigoUsuario = usuarioLogado.getUsuario();

                            System.out.println("Digite seu novo nome de usuário: ");

                            novoNomeUsuario = scanStr.nextLine();

                            usuarioLogado.setUsuario(novoNomeUsuario);

                            System.out.println(
                            """
                            Seu nome de usuário foi altarado
                            Era: %s
                            Foi para %s
                            """.formatted(nomeAntigoUsuario, novoNomeUsuario));

                            jaExibiu = false;

                        } else if (opcaoAplicacao.equals(3)){
                            System.out.println("Digite sua nova senha: ");

                            novaSenha = scanStr.nextLine();

                            usuarioLogado.setSenha(novaSenha);

                            System.out.println(
                            """
                            Sua senha foi alterada para %s
                            """.formatted( novaSenha));

                            jaExibiu = false;

                        } else if (opcaoAplicacao.equals(4)){
                            System.out.println(
                            """
                            %s
                            Sua CPU está usando %.2f%%
                            Sua RAM está usando %.2f GB
                            Seu Disco tem a capacidade total de 1TB
                            Esá sendo usado  %.2f GB     
                            """.formatted(quebraDeLinha, aleatorioCPU, aleaorioRAM, aleatorioDisco));
                        }



                    }while(opcaoAplicacao != 5);



                } else {
                    System.out.println("Usuário e/ou senha incorreto! \n");
                }

            }

        } while (opcao != 2);

        System.out.println("Até breve!");


    }
}
