package school.sptech;

public class Atendimento {

    // Atributos
    private FilaObj<Paciente> filaPrioritaria;      // Fila de pacientes prioritarios
    private FilaObj<Paciente> filaNormal;           // Fila de pacientes normais (nao prioritarios)
    private String[] doenca;        // Vetor com nome de doencas, usado para o relatorio
    private double[] mediaColuna;   // Vetor com as medias das colunas da matriz, usado para o relatorio
    private double[] mediaLinha;    // Vetor com as medias das linhas da matriz, usado para o relatorio
    private double[][] matrizRelatorio;  // Matriz com os dados de atendimento, usado para o relatorio

    // Construtor
    /* Recebe como argumento o vetor com nomes de doencas, a quantidade de linhas e a quantidade de colunas
       da matrizRelatorio
       Atribui o vetor doenca recebido omo arbumento para o atributo vetor doenca
       Instancia (faz o new) a matrizRelatorio, usando qtdLinha e qtdColuna recebidos como argumento
       Instancia o vetor mediaColuna, com o tamanho qtdColuna
       Instancia o vetor mediaLinha, com o tamanho qtdLinha
       Instancia a filaPrioritaria e a filaNormal com tamanho 10 cada uma
     */

    public Atendimento(String[] doenca, int qtdLinha, int qtdColuna) {
        this.doenca = doenca;
        this.matrizRelatorio = new double[qtdLinha][qtdColuna];
        this.mediaColuna = new double[qtdColuna];
        this.mediaLinha = new double[qtdLinha];
        this.filaPrioritaria = new FilaObj<>(10);
        this.filaNormal = new FilaObj<>(10);
    }

    // Métodos

    /* Metoro triagem - recebe como argumento um Paciente p
       Se o paciente for prioritario, insere-o na filaPrioritaria
       Se o paciente nao for prioritario, insere-o na filaNormal
     */
    public void triagem(Paciente p) {
        if (p.getIdade() >= 60 || p.getGestante()) {
            filaPrioritaria.insert(p);
        } else {
            filaNormal.insert(p);
        }
    }

    /* Metodo atender - recebe como argumento a quantidade de pacientes a serem chamados
        para atendimento
        Retorna um vetor com os pacientes que devem ser atendidos
        Se as duas filas estiverem vazias, lanca IllegalStateException
        Se a quantidade de pacientes a serem chamados for menor ou igual a zero ou for maior
        do que a quantidade de pacientes das 2 filas, lanca IllegalArgumentException
        Instancia um vetor de Pacientes com o tamanho igual a qtdPacienteChamado
        Atribui os pacientes a serem chamados para esse vetor, respeitando a prioridade
        Se houver 2 pacientes na filaPrioritaria e 2 pacientes na filaNormal, e se qtdPacienteChamdao for 3,
        o vetor retornado deveo conter os 2 pacientes da filaPrioritaria e o 1o paciente da filaNormal
    */
    public Paciente[] atender(int qtdPacienteChamado) {
        if (filaNormal.isEmpty() && filaPrioritaria.isEmpty()) throw new IllegalStateException();
        if (qtdPacienteChamado <= 0 || qtdPacienteChamado > (filaNormal.getTamanho() + filaPrioritaria.getTamanho())) throw new IllegalArgumentException();

        Paciente[] pacientes = new Paciente[qtdPacienteChamado];
        int qtdPaciente = 0;
        int tam = filaPrioritaria.getTamanho();
        int tam2 = filaNormal.getTamanho();

            for (int i = 0; i < tam ; i++) {
                if (qtdPaciente == qtdPacienteChamado) return pacientes;
                if (filaPrioritaria.peek() != null) {
                    pacientes[i] = filaPrioritaria.poll();
                    qtdPaciente++;
                }
            };

            for (int i = tam; i < tam2+tam ; i++) {
                if (qtdPaciente == qtdPacienteChamado) return pacientes;
                if (filaNormal.peek() != null) {
                    pacientes[i] = filaNormal.poll();
                    qtdPaciente++;
                }
            };

        return pacientes;
    }


    /* Metodo vetorParaMatriz - recebe como argumento um vetor de valores que devem ser
       atribuidos para a matriz
       Deve copiar os valores do vetor para a matrizRelatorio
       Se a quantidade de valores do vetor for menor ou maior do que a quantidade de
       valores que cabe na matriz, lanca IllegalArgymentException
       Os valores do vetor devem ser copiados preenchendo coluna por coluna
       Por exemplo, se o vetor tiver os valores 10, 30, 20, 40
       E for chamado vetorParaMatriz(vetor), sendo matrizRelatorio 2 x 2
       A matrizRelatorio tera os valores (apos execucao deste metodo)
       10  20
       30  40
       OBS: Este metodo deve funcionar para que funcionem os proximos metodos abaixo
     */
    public void vetorParaMatriz(int[] vetor) {
        if (vetor.length != (mediaLinha.length * mediaColuna.length )) throw new IllegalArgumentException();

        int indice = 0;
        for (int i = 0; i < mediaColuna.length; i++) {
            for (int j = 0; j < mediaLinha.length; j++) {
                matrizRelatorio[j][i] = vetor[indice];
                indice++;
            }
        }

        exibeRelatorio();
    }


    /* Metodo calculaMediaLinha - nao recebe argumentos
       Calcula a media de cada linha da matrizRelatorio, colocando a media de
       cada linha no vetor mediaLinha
       Supoe que os dados da matrizRelatorio ja foram copiados de um vetor pelo metodo vetorParaMatriz
     */
    public void calculaMediaLinha() {
        for (int i = 0; i < mediaLinha.length; i++) {
            for (int j = 0; j < mediaColuna.length; j++) {
                mediaLinha[i] += matrizRelatorio[i][j];
            }
            mediaLinha[i] = mediaLinha[i] / mediaColuna.length;
        }
    }

    /* Metodo calculaMediaColuna - nao recebe argumentos
       Calcula a media de cada coluna da matrizRelatorio, colocando a media de
       cada coluna no vetor mediaColuna
       Supoe que os dados da matrizRelatorio ja foram copiados de um vetor pelo metodo vetorParaMatriz
    */
    public void calculaMediaColuna() {

        for (int i = 0; i < mediaLinha.length; i++) {
            for (int j = 0; j < mediaColuna.length; j++) {
                mediaColuna[j] += matrizRelatorio[i][j];
            }
        }

        for (int i = 0; i < mediaColuna.length; i++) {
            mediaColuna[i] = mediaColuna[i] / mediaLinha.length;
        }
    }

    /* Metodo exibeRelatorio - nao recebe argumentos
       Supoe que matrizRelatorio, mediaLinha, mediaColuna estejam corretamente preenchidos
       Exibe o relatorio, usando saida formatada, de forma que a 1a coluna seja os nomes das doencas
       Cada coluna da matriz corresponde aos meses de Janeiro, Fevereiro e Marco, respectivamente
       A coluna final deve ser das medias das linhas
       A linha final deve ser das medias das colunas
       Valores texto devem ser alinhados para a esquerda
       Valores numericos devem ser alinhados para a direita (inclusive o titulo da coluna)
       Nao esquecam de printar os titulos!
     */
    public void exibeRelatorio() {
        calculaMediaColuna();
        calculaMediaLinha();

        System.out.printf("%-15S %10S %10S %10S %6S\n", "doenças", "janeiro", "fevereiro", "março", "media");


        for (int i = 0; i < matrizRelatorio.length; i++) {
            System.out.printf("%-15s ", doenca[i]);
            for (int j = 0; j < mediaColuna.length; j++) {
                System.out.printf("%10.2f ", matrizRelatorio[i][j]);
            }
            System.out.printf("%6.2f\n", mediaLinha[i]);
        }

        System.out.printf("%-15S ", "média");
        for (int j = 0; j < mediaColuna.length; j++) {
            System.out.printf("%10.2f ", mediaColuna[j]);
        }
        System.out.printf("\n");

    }

    // Getters - usados nos testes automatizados
    // Favor nao altera-los
    public double[] getMediaColuna() {
        return mediaColuna;
    }

    public double[] getMediaLinha() {
        return mediaLinha;
    }

    public double[][] getMatrizRelatorio() {
        return matrizRelatorio;
    }

    public FilaObj<Paciente> getFilaPrioritaria() {
        return filaPrioritaria;
    }

    public FilaObj<Paciente> getFilaNormal() {
        return filaNormal;
    }
}
