package school.sptech;

import javax.swing.text.StyledEditorKit;
import java.util.List;

public class Faculdade {

  private String nome;
  private List<Aluno> alunos;

  public Faculdade(String nome) {
  }

  /*
      Deve verificar se existe um aluno com o nome informado, caso não exista,
      retorne false;
  */
  public Boolean existsAlunoPorNome(String nome) {
    for (Aluno alunoDaVez: alunos) {
      if (alunoDaVez.equals(nome)){
        return true;
      }
    }
    return false;
  }

  /*
      Deve matricular um aluno na faculdade (inserir na lista), se a lista já
      possuir um aluno com o nome informado, não deve matricular;
  */
  public void matricularAluno(Aluno aluno) {
    if (aluno == null) {
      System.out.println("Insira um aluno válido");
    } else {
      Boolean isExiste = false;
      for (Aluno alunoDaVez: alunos) {
        if (alunoDaVez.equals(aluno)){
          isExiste = true;
        }
      }

      if (isExiste == true) {
        System.out.println("O aluno já existe");
      } else {
        this.alunos.add(aluno);
      }
    }
  }

  /*
      Deve cancelar a matricula de um aluno na faculdade (ativo = false), se não existir
      um aluno com o RA informado, não faça nada.
  */
  public void cancelarMatricula(String ra) {
    Integer posicao = -1;
    for (int i = 0; i < alunos.size(); i++) {
      if (alunos.get(i).getRa() == ra){
        posicao = i;
      }
    }
    if (posicao == -1) {
      System.out.println("O aluno não existe");
    } else {
      alunos.remove(posicao);
    }
  }

  /*
      Deve retornar a quantidade de alunos contidos na lista (matriculados);
  */
  public Integer getQuantidadeAlunos() {
    return alunos.size();
  }

  /*
      Deve retornar a quantidade de alunos matriculados (contidos na lista)
      no semestre informado;
  */
  public Integer getQuantidadeAlunosPorSemestre(Integer semestre) {
    Integer qtd = 0;
    for (Aluno alunoDaVez: alunos) {
      if (alunoDaVez.getSemestre().equals(semestre)){
        qtd++;
      }
    }
    return qtd;
  }

  /*
      Deve retornar a quantidade de alunos com matrícula cancelada (contidos na lista);
  */
  public Integer getQuantidadeAlunosComMatriculaCancelada() {
    Integer qtd = 0;
    for (Aluno alunoDaVez: alunos) {
      if (alunoDaVez.isAtivo() == false){
        qtd++;
      }
    }
    return qtd;
  }

  public String getNome() {
    return this.nome;
  }
}