package school.sptech;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Repositorio")
public class RepositorioTest {

    @Test
    @DisplayName("Salva corretamente os recursos")
    public void salvarTest() {
        Repositorio repo = new Repositorio();
        repo.salvar(new Recurso(100,"Enfermeiro", "Pessoal", 100));
        repo.salvar(new Recurso(101,"Aparelho Raio-X", "Equipamento", 3));
        repo.salvar(new Recurso(102,"Medico Cirurgiao", "Pessoal", 5));
        repo.salvar(new Recurso(103,"Medico Plantonista", "Pessoal", 15));
        assertEquals(4, repo.getLista().size());
        assertEquals(100, repo.getLista().get(0).getId());
        assertEquals(103, repo.getLista().get(3).getId());
    }

    @Test
    @DisplayName("Deleta corretamente os recursos")
    public void deletarTest() {
        Repositorio repo = new Repositorio();
        repo.salvar(new Recurso(100,"Enfermeiro", "Pessoal", 100));
        repo.salvar(new Recurso(101,"Aparelho Raio-X", "Equipamento", 3));
        repo.salvar(new Recurso(102,"Medico Cirurgiao", "Pessoal", 5));
        repo.salvar(new Recurso(103,"Medico Plantonista", "Pessoal", 15));

        assertThrows(IllegalArgumentException.class, () -> repo.deletar(300));

        repo.deletar(102);
        assertEquals(3, repo.getLista().size());
        assertEquals(100, repo.getLista().get(0).getId());
        assertEquals(103, repo.getLista().get(2).getId());
    }

    @Test
    @DisplayName("Aumenta corretamente a quantidade de recursos")
    public void aumentarRecursoTest() {
        Repositorio repo = new Repositorio();
        repo.salvar(new Recurso(100,"Enfermeiro", "Pessoal", 100));
        repo.salvar(new Recurso(101,"Aparelho Raio-X", "Equipamento", 3));
        repo.salvar(new Recurso(102,"Medico Cirurgiao", "Pessoal", 5));
        repo.salvar(new Recurso(103,"Medico Plantonista", "Pessoal", 15));
        repo.aumentarRecurso("Pessoal", 10);
        assertEquals(110, repo.getLista().get(0).getQuantidade());
        assertEquals(3, repo.getLista().get(1).getQuantidade());
        assertEquals(15, repo.getLista().get(2).getQuantidade());
        assertEquals(25, repo.getLista().get(3).getQuantidade());
    }

    @Test
    @DisplayName("Diminui corretamente a quantidade de recursos")
    public void diminuirRecursoTest() {
        Repositorio repo = new Repositorio();
        repo.salvar(new Recurso(100,"Enfermeiro", "Pessoal", 100));
        repo.salvar(new Recurso(101,"Aparelho Raio-X", "Equipamento", 3));
        repo.salvar(new Recurso(102,"Medico Cirurgiao", "Pessoal", 5));
        repo.salvar(new Recurso(103,"Medico Plantonista", "Pessoal", 15));
        repo.diminuirRecurso("Equipamento", 2);
        assertEquals(100, repo.getLista().get(0).getQuantidade());
        assertEquals(1, repo.getLista().get(1).getQuantidade());
        assertEquals(5, repo.getLista().get(2).getQuantidade());
        assertEquals(15, repo.getLista().get(3).getQuantidade());
    }

    @Test
    @DisplayName("Desfaz corretamente as operações")
    public void desfazerTest() {
        Repositorio repo = new Repositorio();
        repo.salvar(new Recurso(100,"Enfermeiro", "Pessoal", 100));
        repo.salvar(new Recurso(101,"Aparelho Raio-X", "Equipamento", 3));
        repo.salvar(new Recurso(102,"Medico Cirurgiao", "Pessoal", 5));
        repo.salvar(new Recurso(103,"Medico Plantonista", "Pessoal", 15));
        assertThrows(IllegalStateException.class, () -> repo.desfazer());

        repo.aumentarRecurso("Equipamento", 2);
        repo.deletar(102);
        repo.aumentarRecurso("Pessoal", 10);
        repo.desfazer();
        assertEquals(100, repo.getLista().get(0).getQuantidade());
        assertEquals(5, repo.getLista().get(1).getQuantidade());
        assertEquals(15, repo.getLista().get(2).getQuantidade());
        repo.desfazer();
        assertEquals(102, repo.getLista().get(3).getId());
        assertEquals(5, repo.getLista().get(3).getQuantidade());

    }



}
