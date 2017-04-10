package com.vaio.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.vaio.common.Content;
import com.vaio.common.Games;
import com.vaio.persistence.HibernateUtil;

public class App 
{
	public static void run(String[] params) {
		System.out.println("Starting import...");
		SessionFactory sf  = configDB(params[0], params[1], params[2]);
		Session session = sf.openSession();
		session.beginTransaction();
		List<JsonNode> listGames = new ArrayList<JsonNode>();
		Games game ;
		String[] columnNames = sf.getClassMetadata(Games.class).getPropertyNames();
        for(JsonNode c : listGames) {
        	game = new Games();
        	for(int i = 0; i < columnNames.length; i++) {
        		String attr = columnNames[i].toString().trim();
        	}
//        	game.setName(c.getTitle());
//        	game.setActive("Yes");
//        	game.setImgname(c.getImg());
//        	game.setSwfname(c.getSwf());
//        	System.out.println("import ==>"+c.getTitle());
        	session.save(game);
        }
        System.out.println("Finish!!!");
        session.getTransaction().commit();
		
	}
	public static SessionFactory configDB(String db, String user, String pass) {
	  Configuration cfg = new Configuration();
	  cfg.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/"+db);
	  cfg.setProperty("hibernate.connection.username", user);
	  cfg.setProperty("hibernate.connection.password", pass);
	  cfg.buildMapping();
	  SessionFactory sf = cfg.buildSessionFactory();
	  return sf;
	 }
    public static void main( String[] args )
    {
        System.out.println("Starting import...");
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String path = args[0];
        List<Content> listGames = new ArrayList<Content>();
//        listGames = ReadFromExcel.getContents(path);
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
