/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.dsw.comentarios.comentario;

import br.senac.tads.dsw.comentarios.produto.Produto;
import java.time.LocalDateTime;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

/**
 *
 * @author Bigstudios
 */

@Entity
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column
    private String nome;
    
    @Column(unique = true)
    private String email;
    
    @Column
    private String comentario;
    
    @Column
    private LocalDateTime dataHorario;
   
   @OneToOne(cascade = CascadeType.ALL)
   private Produto produto;

    public Comentario() {
    }

    public Comentario(String nome, String email, String comentario, LocalDateTime dataHorario, Produto produto) {
        this.nome = nome;
        this.email = email;
        this.comentario = comentario;
        this.dataHorario = dataHorario;
        this.produto = produto;
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

    public LocalDateTime getDataHorario() {
        return dataHorario;
    }

    public void setDataHorario(LocalDateTime dataHorario) {
        this.dataHorario = dataHorario;
    }

    public Produto getProduto() {
        return produto;
    }

   public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
    
    
}
