package com.veeru.Dao;

import com.veeru.Entity.Actor;

import javax.persistence.*;
import java.util.List;

public class ActorsDao {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql-config");
    EntityManager em = emf.createEntityManager();


    public void  ActorService(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql-config");
        EntityManager em = emf.createEntityManager();

    }


    public void add_Actor(Actor actor){
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(actor);
        et.commit();
    }

    public void close(){
        em.close();
        emf.close();
    }


    public void display_actors() {
        EntityTransaction et = em.getTransaction();
        et.begin();

        Query query_atr = em.createQuery("Select a from Actor a");
        List<Actor> actr_list = query_atr.getResultList();
        for (Actor a : actr_list){
            System.out.println(a.getId()+" | "+ a.getFirstname()+" |  "+ a.getLastname()+" | "
                    + a.getAge()+" | " + a.getIndustry() +" | "+ a.getNationality());
        }

        et.commit();

    }
}
