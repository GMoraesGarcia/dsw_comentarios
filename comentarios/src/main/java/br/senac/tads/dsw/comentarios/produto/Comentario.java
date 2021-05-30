/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.dsw.comentarios.produto;

import br.senac.tads.dsw.comentarios.produto.Produto;
import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Bigstudios
 */
@Entity
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Size(min = 1, max = 100)
    @Column
    private String nome;

    @NotBlank
    @Size(min = 1, max = 100)
    @Column(unique = true)
    private String email;

    @NotBlank
    @Column
    private String comentario;

    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date dataHorario;

    @OneToOne(cascade = CascadeType.ALL)
    private Produto produto;

    public Comentario() {
    }

    public Comentario(String nome, String email, String comentario, Date dataHorario, Produto produto) {
        this.nome = nome;
        this.email = email;
        this.comentario = comentario;
        this.dataHorario = dataHorario;
        this.produto = produto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Date getDataHorario() {
        return dataHorario;
    }

    public void setDataHorario(Date dataHorario) {
        this.dataHorario = dataHorario;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public String toString() {
        return "Comentario{" + "id=" + id + ", nome=" + nome + ", email=" + email + ", comentario=" + comentario + ", dataHorario=" + dataHorario + ", produto=" + produto + '}';
    }

}
