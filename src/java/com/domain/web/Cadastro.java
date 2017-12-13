package com.domain.web;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Cadastro {
    private int cpf;
    private String name;
    private String email;
    private String nacionalidade;
    private String genero;
    
        public Cadastro(int cpf, String name, String email, String nacionalidade, String genero) {
        this.cpf = cpf;
        this.name = name;
        this.email = email;
        this.nacionalidade = nacionalidade;
        this.genero = genero;
    }
        
    public static String addDadosUser(int cpf, String name, String email, String nacionalidade, String genero)throws SQLException{
        String SQL = "INSERT INTO users VALUES(default,?,?,?,?,null,null)";
        PreparedStatement statement = Database.getConnection().prepareStatement(SQL);
        statement.setInt(1, cpf);
        statement.setString(2, name);
        statement.setString(3, email);
        statement.setString(4, nacionalidade);
        statement.setString(5, genero);
        statement.execute();
        statement.close();
        System.out.println("Dados inseridos com sucesso.");
        return "Cadastro realizado com sucesso";
    }
    
    public static Cadastro getUser(String name,String email,String nacionalidade,String genero) throws SQLException{
        String SQL = "SELECT * FROM users WHERE name=? AND email=? AND nacionalidade=? AND genero=?";
        PreparedStatement s = Database.getConnection().prepareStatement(SQL);
        s.setString(1, name);
        s.setString(2, email);
        s.setString(3, nacionalidade);
        s.setString(4, genero);
        ResultSet rs = s.executeQuery();
        Cadastro u = null;
        if(rs.next()){
            u = new Cadastro(rs.getInt("cpf")
                    , rs.getString("name")
                    , rs.getString("email")
                    , rs.getString("nacionalidade")
                    , rs.getString("genero"));
        }
        rs.close();
        s.close();
        return u;
    }
    
    
      public static ArrayList<Cadastro> getList() throws SQLException{
        ArrayList<Cadastro> list = new ArrayList<>();
        Statement s = Database.getConnection().createStatement();
        ResultSet rs = s.executeQuery("SELECT * FROM Cadastro"
                        + " WHERE end_stay IS NULL");
        while(rs.next()){
            Cadastro vs = new Cadastro(
                   rs.getInt("cpf")
                    , rs.getString("name")
                    , rs.getString("email")
                    , rs.getString("nacionalidade")
                    , rs.getString("genero"));
            
            list.add(vs);
        }
        rs.close();
        s.close();
        return list;
    }

    /*public static ArrayList<Cadastro> getCadastroList(String plate, String beginDate) throws SQLException{
        ArrayList<Cadastro> list = new ArrayList<>();
        String SQL = "SELECT * FROM users WHERE end_stay IS NOT NULL ";
        if(plate!=null)
            SQL += " AND vehicle_plate = ?";
        if(beginDate!=null){
            SQL += " AND begin_stay >= TIMESTAMP('"+beginDate+"')";
        }
        PreparedStatement s = Database.getConnection().prepareStatement(SQL);
        int paramIndex = 1;
        if(plate!=null)
            s.setString(paramIndex++, plate);
        /*if(beginDate!=null)
            s.setString(paramIndex++, beginDate);*//*
        ResultSet rs = s.executeQuery();
        while(rs.next()){
            Cadastro vs = new Cadastro(
                   rs.getInt("cpf")
                    , rs.getString("name")
                    , rs.getString("email")
                    , rs.getString("nacionalidade")
                    , rs.getString("genero"));
            list.add(vs);
        }
        rs.close();
        s.close();
        return list;
    }*/

    
    
    /*public static void finishVehicleStay(int id, double price)
            throws SQLException{
        String SQL = "UPDATE vehicles_stays"
                + " SET end_stay=?, price=?"
                + " WHERE id =?";
        PreparedStatement s = Database.getConnection().prepareStatement(SQL);
        s.setTimestamp(1, new Timestamp(new Date().getTime()));
        s.setDouble(2, price);
        s.setInt(3, id);
        s.execute();
        s.close();
      
    }*/
      

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
}

