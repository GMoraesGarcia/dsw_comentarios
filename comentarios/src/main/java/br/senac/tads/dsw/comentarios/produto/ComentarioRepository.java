/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.dsw.comentarios.produto;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author adm
 */
@Repository
public class ComentarioRepository {
    @PersistenceContext
    private EntityManager em;
    
    @Transactional
    public Comentario save(Comentario coment) {
        if (coment.getId() == null) {
            // JPA vai incluir novo registro no banco
            em.persist(coment);
        } else {
            // Atualiza categoria existente
            coment = em.merge(coment);
        }
        return coment;
    }
}
