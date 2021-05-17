/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.dsw.comentarios.comentario;

/**
 *
 * @author Bigstudios
 */

public class Comentario {
    private Long id;
    
    private String nome;
    
    private String email;
    
    private String comentario;

    public Comentario() {
    }

    public Comentario(String nome, String email, String comentario) {
        this.nome = nome;
        this.email = email;
        this.comentario = comentario;
    }

    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    
    
    
}
