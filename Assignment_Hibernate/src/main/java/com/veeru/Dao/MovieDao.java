package com.veeru.Dao;

import com.veeru.Entity.Actor;
import com.veeru.Entity.Movie;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovieDao {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql-config");
    EntityManager em = emf.createEntityManager();


    public void  MovieService(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql-config");
        EntityManager em = emf.createEntityManager();

    }



    public  void addMovie(Movie movie){
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(movie);

        et.commit();

    }


    public void linkActorToMovie(int mov_id, int act_id){
        EntityTransaction et = em.getTransaction();
        et.begin();
        Movie m = em.find(Movie.class, mov_id);
        Actor act = em.find(Actor.class, act_id);

        if(m != null && act != null){
            List<Actor> actrs_present = m.getActors();
            if(actrs_present == null)
                actrs_present = new ArrayList<>();
            actrs_present.add(act);
            m.setActors(actrs_present);
            em.merge(m);

            et.commit();
        }else{
            System.out.println("Movie or actor not found");
        }
    }

    public void display_movies_Lists(){
        EntityTransaction et = em.getTransaction();
        et.begin();

        Query query_data = em.createQuery("Select m from Movie m");
        List<Movie> movies = query_data.getResultList();

        for(Movie m : movies){
            System.out.println(m.getMovie_id()+" | "+ m.getTitle()+" |  "+ m.getDirector()+" | "
            + m.getLangauge() +" | "+ m.getActors());

        }

        et.commit();
    }


    public void close(){
        em.close();
        emf.close();
    }

}
