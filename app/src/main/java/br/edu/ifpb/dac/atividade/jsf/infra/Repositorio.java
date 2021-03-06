/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.atividade.jsf.infra;

import br.edu.ifpb.dac.atividade.jsf.entity.Contato;
import java.util.List;

/**
 *
 * @author jose
 */
public interface Repositorio {

    void atualizar(Contato contato);

    Contato buscar(long id);

    List<Contato> buscarTodos();

    List<Contato> getAllFirstLettersAsc();

    List<Contato> getContatoPorNome(String nome);

    void remover(Contato contato);

    void salvar(Contato contato);
    
}
