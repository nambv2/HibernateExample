package com.vaio.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.vaio.common.Content;
import com.vaio.common.Games;
import com.vaio.persistence.HibernateUtil;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Starting import...");
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String path = args[0];
        List<Content> listGames = new ArrayList<Content>();
        listGames = ReadFromExcel.getContents(path);
        Games game ;
        for(Content c : listGames) {
        	game = new Games();
        	game.setName(c.getTitle());
        	game.setActive("Yes");
        	game.setImgname(c.getImg());
        	game.setSwfname(c.getSwf());
        	System.out.println("import ==>"+c.getTitle());
        	session.save(game);
        }
        System.out.println("Finish!!!");
        session.getTransaction().commit();
        
        
    }
}
