package com.domain.web;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Cadastro {
    private String cpf;
    private String name;
    private String email;
    private String senha;
    private String data;
    private String nacionalidade;
    private int telefone;
    private String genero; 

    public Cadastro(String cpf, String name, String data, String email, String senha, String nacionalidade, int telefone, String genero) {
        this.cpf = cpf;
        this.name = name;
        this.data = data;
        this.email = email;
        this.senha = senha;
        this.nacionalidade = nacionalidade;
        this.telefone = telefone;
        this.genero = genero;
    }
    
    
   
    
    public void InsertCadastro(String cpf, String name, String data, String email, String senha, String nacionalidade, int telefone, String genero) throws SQLException{
        try{
            
           String SQL = "INSERT INTO users(cpf, name, login, genero, dt__nascimento, pass_hash, telefone, nacionalidade VALUES('"
                   +getCpf()+"', '"+getName()+"' ,'"+getEmail()+"', '"+getGenero()+"', '"+getData()+"' ,'"+getSenha().hashCode()+"', '"+getTelefone()+"', '"+getNacionalidade()+"')";
            PreparedStatement ss= Database.getConnection().prepareStatement(SQL);
            ResultSet rs = ss.executeQuery();
            rs.close();
            ss.close();
        }catch(Exception ex){
            System.out.println("Erro ao gravar os dados: " + ex.getMessage());
            System.out.println();
        }
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}

