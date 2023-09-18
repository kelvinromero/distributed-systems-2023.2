package com.gugawag.pdist.ejb.session;

import com.gugawag.pdist.modelo.Mensagem;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

import java.util.List;

@Stateless(name = "mensagemService")
public class MensagemService {
    @EJB
    private MensagemDao mensagemDao;

    public void inserir(long id, String texto) {
        Mensagem novaMensagem = new Mensagem(id, texto);
        this.mensagemDao.inserir(novaMensagem);
    }

    public Mensagem buscar(int id) {
        return this.mensagemDao.buscar(id);
    }

    public List<Mensagem> listar() {
        return this.mensagemDao.listar();
    }

}
