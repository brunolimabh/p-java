package org.example;

import org.springframework.jdbc.core.JdbcTemplate;
import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscoGrupo;
import com.github.britooo.looca.api.group.discos.Volume;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.processos.Processo;
import com.github.britooo.looca.api.group.processos.ProcessoGrupo;
//import com.github.britooo.looca.api.group.servicos.Servico;
import com.github.britooo.looca.api.group.servicos.ServicoGrupo;
import com.github.britooo.looca.api.group.sistema.Sistema;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        LocalDateTime dataHora = LocalDateTime.now();
        JdbcTemplate con = new BancoMySQLLocal().Conexao();
        Looca looca = new Looca();
        Sistema sistema = looca.getSistema();
        Processador processador = looca.getProcessador();
        Memoria memoria = looca.getMemoria();

        System.out.printf("""
                ------------------------
                Sistema operacional: %s
                ------------------------
                Processador: %s
                Frequência| Núcleos|Threads
                %s GHz |   %d    |   %d
                ------------------------
                Memoria
                Total|  Em uso  | Disponível
                %.2sGB |  %.4sGB  |    %.3sGB
                ------------------------
                """,
                sistema.getSistemaOperacional(),
                processador.getNome(),
                processador.getFrequencia()/Math.pow(10,9),
                processador.getNumeroCpusFisicas(),
                processador.getNumeroCpusLogicas(),
                memoria.getTotal()/Math.pow(10,9),
                (memoria.getEmUso()/Math.pow(10,9))-1,
                memoria.getDisponivel()/Math.pow(10,9)
        );



    }
}