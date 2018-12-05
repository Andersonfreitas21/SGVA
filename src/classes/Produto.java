/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author Anderson Freitas
 */
public class Produto {
    
    private int id_produto;
    private String prod_nome;
    private Double prod_valor;
    private String prod_descricao;
    private int prod_estoque;
    private String prod_categoria;
    private String prod_data_cadastro;

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public String getProd_nome() {
        return prod_nome;
    }

    public void setProd_nome(String prod_nome) {
        this.prod_nome = prod_nome;
    }

    public Double getProd_valor() {
        return prod_valor;
    }

    public void setProd_valor(Double prod_valor) {
        this.prod_valor = prod_valor;
    }

    public String getProd_descricao() {
        return prod_descricao;
    }

    public void setProd_descricao(String prod_descricao) {
        this.prod_descricao = prod_descricao;
    }

    public int getProd_estoque() {
        return prod_estoque;
    }

    public void setProd_estoque(int prod_estoque) {
        this.prod_estoque = prod_estoque;
    }

    public String getProd_categoria() {
        return prod_categoria;
    }

    public void setProd_categoria(String prod_categoria) {
        this.prod_categoria = prod_categoria;
    }

    public String getProd_data_cadastro() {
        return prod_data_cadastro;
    }

    public void setProd_data_cadastro(String prod_data_cadastro) {
        this.prod_data_cadastro = prod_data_cadastro;
    }
    
}
