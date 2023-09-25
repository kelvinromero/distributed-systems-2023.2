package com.gugawag.pdist.ejb.session;

import com.gugawag.pdist.modelo.Mensagem;
import com.gugawag.pdist.modelo.Usuario;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;


import java.util.List;

@Stateless(name = "usuarioService")
public class UsuarioService {
    @EJB
    private UsuarioDAO usuarioDAO;

    @EJB
    MensagemDao mensagemDao;

    public void inserir(long id, String nome) {
        Usuario novoUsuario = new Usuario(id, nome);
        this.usuarioDAO.inserir(novoUsuario);
        this.mensagemDao.inserir(new Mensagem(id, "Mensagem de teste :" + id));

        if (id == 5) {
            throw new RuntimeException("Erro de teste");
        }
    }

    public List<Usuario> listar() {
        return this.usuarioDAO.listar();
    }
}
