package com.gugawag.pdist.ejb.session;

import com.gugawag.pdist.modelo.Mensagem;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class MensagemDao {

    @PersistenceContext(unitName = "bd2")
    private EntityManager em;

    public void inserir(Mensagem mensagem) {
        em.persist(mensagem);
    }

    public Mensagem buscar(int id) {
        return em.find(Mensagem.class, id);
    }

    public List<Mensagem> listar() {
        return em.createQuery("SELECT m FROM tb_mensagem_pdist m").getResultList();
    }
}
