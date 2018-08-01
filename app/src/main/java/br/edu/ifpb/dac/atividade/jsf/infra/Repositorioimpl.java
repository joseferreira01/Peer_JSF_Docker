/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.atividade.jsf.infra;

import br.edu.ifpb.dac.atividade.jsf.entity.Contato;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author jose
 */
@Stateless
public class Repositorioimpl implements Repositorio {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void salvar(Contato contato) {
        em.persist(contato);
    }

    @Override
    public void atualizar(Contato contato) {
        em.merge(contato);
    }

    @Override
    public void remover(Contato contato) {
        System.err.println("remove "+contato);
        em.remove(contato);
    }

    @Override
    public Contato buscar(long id) {
        return em.find(Contato.class, id);
    }

    @Override
    public List<Contato> buscarTodos() {
        return em.createQuery("select c from Contato c ", Contato.class).getResultList();
    }

    @Override
    public List<Contato> getAllFirstLettersAsc() {
        return em.createQuery("select c from Contato c order by c.nome", Contato.class).getResultList();

    }

    @Override
    public List<Contato> getContatoPorNome(String nome) {
         StringBuffer  sql =new StringBuffer("SELECT c FROM Contato c "
         );  sql.append( " WHERE UPPER(c.nome) LIKE" ); sql.append(nome);sql.append("'%'");
        TypedQuery<Contato> query = em.createQuery(sql.toString(), Contato.class);
        return query.getResultList();
    }

}
