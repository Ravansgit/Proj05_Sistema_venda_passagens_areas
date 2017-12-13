package com.domain.web;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

public class Price {
    private int id;
    private Date dateTime;
    private double price;
    
    public static ArrayList<Price> getList() throws Exception{
        ArrayList<Price> list = new ArrayList<>();
        Statement s = Database.getConnection().createStatement();
        ResultSet rs = s.executeQuery("SELECT * FROM HOUR_PRICE"
                + " ORDER BY DATETIME DESC");
        while(rs.next()){
            Price p = new Price(
                    rs.getInt("id")
                    , rs.getTimestamp("datetime")
                    , rs.getDouble("price")
            );
            list.add(p);
        }
        rs.close();
        s.close();
        return list;
    }
    
    public static double getCurrentPrice() throws Exception{
        double currentPrice = 0;
        Statement s = Database.getConnection().createStatement();
        ResultSet rs = s.executeQuery("SELECT * FROM HOUR_PRICE"
                + " ORDER BY DATETIME DESC");
        if(rs.next()){
            currentPrice = rs.getDouble("price");
        }
        rs.close();
        s.close();
        return currentPrice;
    }
    
    public static void addPrie(double price)
    throws Exception{
        String SQL = "INSERT INTO HOUR_PRICE VALUES("
                + "default,?,?)";
        PreparedStatement s = Database.getConnection().prepareStatement(SQL);
        s.setTimestamp(1, new Timestamp(new Date().getTime()));
        s.setDouble(2, price);
        s.execute();
        s.close();
    }

    public Price(double price) {
        this.dateTime = new Date();
        this.price = price;
    }

    public Price(int id, Date dateTime, double price) {
        this.id = id;
        this.dateTime = dateTime;
        this.price = price;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}