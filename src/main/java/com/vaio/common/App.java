package com.vaio.common;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;

import com.vaio.persistence.HibernateUtil;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Maven + Hibernate + MySQL");
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        session.beginTransaction();
        
        
        /*Stock stock = new Stock();
        
        stock.setStockCode("999");
       // stock.setStockName("nambv111");
        session.save(stock);*/
        
        //session.delete(stock);
        
        
        
        Games game = new Games();
        
        session.getTransaction().commit();
        
        
    }
}
