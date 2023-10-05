package school.sptech;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cinema {
    private String nome;
    private List<Sessao> sessoes;

    public Cinema(String nome) {
        this.nome = nome;
        this.sessoes = new ArrayList<>();
    }

    public void adicionarSessao(Sessao sessao) {
        if (Objects.nonNull(sessao)){
            this.sessoes.add(sessao);
        }
    }
    public Integer getQuantidadeSessoes3d() {
        Integer qtd = 0;
        for (Sessao sessaoDaVez: sessoes){
            if (sessaoDaVez.getSessao3d()){
                qtd++;
            }
        }
        return qtd;
    }
    public List<Sessao> getSessoesPorNomeFilme(String filme) {
        List<Sessao> busca = new ArrayList<>();
        if (Objects.nonNull(filme) && this.sessoes.size() > 0){
            for (Sessao sessaoDaVez: sessoes){
                if (sessaoDaVez.getFilme().equalsIgnoreCase(filme)){
                    busca.add(sessaoDaVez);
                }
            }
        }
        return busca;
    }
    public Double getMediaIngressosVendidos() {
        Double media = 0.0;
        Double totalVendidos = 0.0;
        if (this.sessoes.size() > 0) {
            for (Sessao sessaoDaVez : sessoes) {
                totalVendidos += sessaoDaVez.getIngressosVendidos();
            }
            media = totalVendidos / this.sessoes.size();
            return media;
        }
        return media;
    }

    public Double calcularTotalVendas() {
        Double total = 0.0;
        if (this.sessoes.size() > 0){
            for (Sessao sessaoDaVez: sessoes){
                if (sessaoDaVez.getSessao3d()){
                    total += (sessaoDaVez.getPreco()*2) * sessaoDaVez.getIngressosVendidos();
                } else {
                    total += sessaoDaVez.getPreco() * sessaoDaVez.getIngressosVendidos();
                }
            }
            return total;
        }
        return total;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
