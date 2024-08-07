package school.sptech;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import school.sptech.Atendimento;
import school.sptech.Paciente;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Atendimento")
public class AtendimentoTest {

    @Test
    @DisplayName("Insere corretamente os pacientes nas filas")
    public void triagemTest() {
        String[] doenca = {"Doença1", "Doença2"};
        Atendimento atendimento = new Atendimento(doenca, 2, 2);

        atendimento.triagem(new Paciente(2000, "Ana Teixeira", 30, "Dor de cabeca", false));
        assertEquals(1, atendimento.getFilaNormal().getTamanho());
        assertEquals(0, atendimento.getFilaPrioritaria().getTamanho());
        atendimento.triagem(new Paciente(2001, "Mario Silva", 63, "Febre alta", false));
        assertEquals(1, atendimento.getFilaNormal().getTamanho());
        assertEquals(1, atendimento.getFilaPrioritaria().getTamanho());
        atendimento.triagem(new Paciente(2002, "Paula Souza", 27, "Dor na lombar", true));
        assertEquals(1, atendimento.getFilaNormal().getTamanho());
        assertEquals(2, atendimento.getFilaPrioritaria().getTamanho());
        atendimento.triagem(new Paciente(2003, "Fabio Reis", 25, "Dor de garganta", false));
        assertEquals(2, atendimento.getFilaNormal().getTamanho());
        assertEquals(2, atendimento.getFilaPrioritaria().getTamanho());

        assertEquals("Mario Silva", atendimento.getFilaPrioritaria().peek().getNome());
        assertEquals("Ana Teixeira", atendimento.getFilaNormal().peek().getNome());
        atendimento.getFilaPrioritaria().poll();
        atendimento.getFilaNormal().poll();
        assertEquals("Paula Souza", atendimento.getFilaPrioritaria().peek().getNome());
        assertEquals("Fabio Reis", atendimento.getFilaNormal().peek().getNome());
    }

    @Test
    @DisplayName("Deve validar corretamente se filas não vazia e se argumento correto")
    public void atenderValidacoes() {
        String[] doenca = {"Doença1", "Doença2"};
        Atendimento atendimento = new Atendimento(doenca, 2, 2);

        assertThrows(IllegalStateException.class, () -> atendimento.atender(2));

        atendimento.triagem(new Paciente(2000, "Ana Teixeira", 30, "Dor de cabeca", false));
        atendimento.triagem(new Paciente(2001, "Mario Silva", 63, "Febre alta", false));
        atendimento.triagem(new Paciente(2002, "Paula Souza", 27, "Dor na lombar", true));

        assertThrows(IllegalArgumentException.class, () -> atendimento.atender(-1));
        assertThrows(IllegalArgumentException.class, () -> atendimento.atender(0));
        assertThrows(IllegalArgumentException.class, () -> atendimento.atender(4));
    }

    @Test
    @DisplayName("Deve retornar vetor com 1 paciente")
    public void atender1() {
        String[] doenca = {"Doença1", "Doença2"};
        Atendimento atendimento = new Atendimento(doenca, 2, 2);

        atendimento.triagem(new Paciente(2000, "Ana Teixeira", 30, "Dor de cabeca", false));
        atendimento.triagem(new Paciente(2001, "Mario Silva", 63, "Febre alta", false));
        atendimento.triagem(new Paciente(2002, "Paula Souza", 27, "Dor na lombar", true));

        Paciente[] vetor = atendimento.atender(1);
        assertEquals(1, atendimento.getFilaPrioritaria().getTamanho());
        assertEquals(1, atendimento.getFilaNormal().getTamanho());
        assertEquals(1, vetor.length);
        assertEquals(2001, vetor[0].getId());
    }

    @Test
    @DisplayName("Deve retornar vetor com 2 pacientes prioritarios")
    public void atender2() {
        String[] doenca = {"Doença1", "Doença2"};
        Atendimento atendimento = new Atendimento(doenca, 2, 2);

        atendimento.triagem(new Paciente(2000, "Ana Teixeira", 30, "Dor de cabeca", false));
        atendimento.triagem(new Paciente(2001, "Mario Silva", 63, "Febre alta", false));
        atendimento.triagem(new Paciente(2002, "Paula Souza", 27, "Dor na lombar", true));

        Paciente[] vetor = atendimento.atender(2);
        assertEquals(0, atendimento.getFilaPrioritaria().getTamanho());
        assertEquals(1, atendimento.getFilaNormal().getTamanho());
        assertEquals(2, vetor.length);
        assertEquals(2001, vetor[0].getId());
        assertEquals(2002, vetor[1].getId());
    }

    @Test
    @DisplayName("Deve retornar vetor com 2 pacientes prioritarios e 1 normal")
    public void atender3() {
        String[] doenca = {"Doença1", "Doença2"};
        Atendimento atendimento = new Atendimento(doenca, 2, 2);

        atendimento.triagem(new Paciente(2000, "Ana Teixeira", 30, "Dor de cabeca", false));
        atendimento.triagem(new Paciente(2001, "Mario Silva", 63, "Febre alta", false));
        atendimento.triagem(new Paciente(2002, "Paula Souza", 27, "Dor na lombar", true));

        Paciente[] vetor = atendimento.atender(3);
        assertEquals(0, atendimento.getFilaPrioritaria().getTamanho());
        assertEquals(0, atendimento.getFilaNormal().getTamanho());
        assertEquals(3, vetor.length);
        assertEquals(2001, vetor[0].getId());
        assertEquals(2002, vetor[1].getId());
        assertEquals(2000, vetor[2].getId());
    }

    @Test
    @DisplayName("Deve retornar vetor com 2 pacientes normais")
    public void atender4() {
        String[] doenca = {"Doença1", "Doença2"};
        Atendimento atendimento = new Atendimento(doenca, 2, 2);

        atendimento.triagem(new Paciente(2000, "Ana Teixeira", 30, "Dor de cabeca", false));
        atendimento.triagem(new Paciente(2001, "Mario Silva", 59, "Febre alta", false));
        atendimento.triagem(new Paciente(2002, "Paula Souza", 27, "Dor na lombar", false));

        Paciente[] vetor = atendimento.atender(2);
        assertEquals(0, atendimento.getFilaPrioritaria().getTamanho());
        assertEquals(1, atendimento.getFilaNormal().getTamanho());
        assertEquals(2, vetor.length);
        assertEquals(2000, vetor[0].getId());
        assertEquals(2001, vetor[1].getId());
    }

    @Test
    @DisplayName("Tamanho do vetor não pode ser menor nem maior do que tam da matriz")
    public void vetorParaMatrizValidaVetor() {
        int[] vetor = {1, 2, 3};
        int[] vetor1 = {1, 2, 3, 4, 5, 6};
        String[] doenca = {"Doença1", "Doença2"};
        Atendimento atendimento = new Atendimento(doenca, 2, 2);

        assertThrows(IllegalArgumentException.class, () -> atendimento.vetorParaMatriz(vetor));
        assertThrows(IllegalArgumentException.class, () -> atendimento.vetorParaMatriz(vetor1));
    }

    @Test
    @DisplayName("Valores do vetor devem ser atribuidos corretamente para a matriz")
    public void vetorParaMatrizVerificaValor() {
        int[] vetor = {1, 2, 3, 4};
        String[] doenca = {"Doença1", "Doença2"};
        Atendimento atendimento = new Atendimento(doenca, 2, 2);

        atendimento.vetorParaMatriz(vetor);
        double[][] matriz = atendimento.getMatrizRelatorio();
        assertEquals(1, matriz[0][0]);
        assertEquals(3, matriz[0][1]);
        assertEquals(2, matriz[1][0]);
        assertEquals(4, matriz[1][1]);
    }

    @Test
    @DisplayName("Calcula corretamente as médias das linhas, as médias das colunas e exibe o relatorio")
    public void calculaMedias() {
        int[] vetor = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150, 160, 170, 180, 190, 200, 210};
        String[] doenca = {"Pedra no rim", "Sinusite", "Influenza", "Rinite", "Covid", "Virose", "Dengue"};
        Atendimento atendimento = new Atendimento(doenca, 7, 3);

        atendimento.vetorParaMatriz(vetor);
        atendimento.calculaMediaLinha();
        assertEquals(80, atendimento.getMediaLinha()[0]);
        assertEquals(90, atendimento.getMediaLinha()[1]);
        assertEquals(100, atendimento.getMediaLinha()[2]);
        assertEquals(110, atendimento.getMediaLinha()[3]);
        assertEquals(120, atendimento.getMediaLinha()[4]);
        assertEquals(130, atendimento.getMediaLinha()[5]);
        assertEquals(140, atendimento.getMediaLinha()[6]);

        atendimento.calculaMediaColuna();
        assertEquals(40, atendimento.getMediaColuna()[0]);
        assertEquals(110, atendimento.getMediaColuna()[1]);
        assertEquals(180, atendimento.getMediaColuna()[2]);

        atendimento.exibeRelatorio();
    }

}
