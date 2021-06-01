/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.dsw.comentarios.produto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoRepository repository;
    
    @Autowired
    private ComentarioRepository cRepository;
    

    public ProdutoController(ProdutoRepository repository) {
        this.repository = repository;
        
    }
    
    @GetMapping
    public ModelAndView listar() {
        List<Produto> produtos = repository.findAll();
        return new ModelAndView("produtos/lista").addObject("items", produtos);
    }

    @GetMapping("/{id}")
    public ModelAndView mostrarDetalhes(@PathVariable("id") Integer id, RedirectAttributes redirAttr) {
        Optional<Produto> optProduto = repository.findById(id);
        ArrayList<Comentario> comentario = (ArrayList<Comentario>) cRepository.findByProdutoId();
       
       
      
        if (optProduto.isEmpty()) {
            redirAttr.addFlashAttribute("msgErro", "Produto com ID " + id + " não encontrado.");
            return new ModelAndView("redirect:/produtos");
        }
       
        return new ModelAndView("produtos/detalhes")
                .addObject("item", optProduto.get()).addObject("comentario",comentario).addObject("formC",new Comentario());
    }
    
    @PostMapping("/Salvar-Comentario/{prodid}")
    public ModelAndView recebeComentario(@PathVariable("prodid") Integer id,
       @Valid @ModelAttribute("comentario") Comentario comentario,
       BindingResult bindingResult,
       RedirectAttributes redirAttr){
        
        if(bindingResult.hasErrors()){
            System.out.println("fdp");
           return new ModelAndView("redirect:/produtos/"+id+"");
        }
        
       Optional<Produto> optProduto = repository.findById(id);
       comentario.setProduto(optProduto.get()); 
       comentario.setDataHorario(LocalDateTime.of(LocalDate.now(), LocalTime.now()));
        cRepository.save(comentario);
       ModelAndView mv = new ModelAndView("redirect:/produtos/"+id+"");
       redirAttr.addFlashAttribute("comentario",comentario);
       return mv;
       
    }

}
