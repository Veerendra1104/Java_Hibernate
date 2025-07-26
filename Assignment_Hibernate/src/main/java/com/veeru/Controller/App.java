    package com.veeru.Controller;

    import com.veeru.Dao.ActorsDao;
    import com.veeru.Dao.MovieDao;
    import com.veeru.Entity.Actor;
    import com.veeru.Entity.Movie;

    import java.util.Scanner;

    /**
     * Hello world!
     *
     */
    public class App
    {
        public static void main( String[] args )
        {
            Scanner sc = new Scanner(System.in);
            Movie m1 = new  Movie();

            System.out.println("Enter the movie details");
            System.out.println("Enter the movie title  ");
            m1.setTitle(sc.nextLine());
            System.out.println("Enter the movie language");
            m1.setLangauge(sc.nextLine());
            System.out.println("Enter the movie director");
            m1.setDirector(sc.nextLine());


            MovieDao movie_dao = new MovieDao();
            movie_dao.MovieService();
            movie_dao.addMovie(m1);
            movie_dao.close();



            System.out.println("---------------------------------------------------------------------------");
            Actor actr = new Actor();
            System.out.println("Enter the  actors details");
            System.out.println("Enter the actor firstname");
            actr.setFirstname(sc.nextLine());
            System.out.println("Enter the actor last name");
            actr.setLastname(sc.nextLine());
            System.out.println("Enter the acotr age");
            actr.setAge(sc.nextInt());
            sc.nextLine();
            System.out.println("Enter the industry");
            actr.setIndustry(sc.nextLine());
            System.out.println("Enter the nationality");
            actr.setNationality(sc.nextLine());

            ActorsDao actr_dao = new ActorsDao();
            actr_dao.ActorService();
            actr_dao.add_Actor(actr);
            actr_dao.close();


            System.out.println("-----------------Movies List------------------------------------------------");
            movie_dao.display_movies_Lists();
            System.out.println("-----------------------------------------------------------------------------------");
            System.out.println("-----------------Actors List------------------------------------------------");
            actr_dao.display_actors();

            System.out.println("--------------------------------------------------------------------------");
            System.out.println("Enter the movie id to link ");
            int movie_id = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter the actor _id to link");
            int actr_id = sc.nextInt();
            sc.nextLine();
            movie_dao.linkActorToMovie(movie_id, actr_id);


        }
    }
