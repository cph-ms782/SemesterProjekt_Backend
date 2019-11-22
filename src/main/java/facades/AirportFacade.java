package facades;

import entities.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import errorhandling.AuthenticationException;

/**
 * @author lam@cphbusiness.dk
 */
public class AirportFacade {
  
    private static EntityManagerFactory emf;
    private static AirportFacade instance;
    
    private AirportFacade(){}
    
    /**
     * 
     * @param _emf
     * @return the instance of this facade.
     */
    public static AirportFacade getAirportFacade (EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new AirportFacade();
        }
        return instance;
    }
    
    public String getNearestAirport(String team){
        
        
        EntityManager em = emf.createEntityManager();
              try {
            em.getTransaction().begin();
            //Delete existing users and roles to get a "fresh" database
            em.createQuery("delete from User").executeUpdate();
//            em.find(TeamAirportDTO.class, em);
// https://en.wikibooks.org/wiki/Java_Persistence/JPQL
//            Role userRole = new Role("user");
//            Role adminRole = new Role("admin");
//            User user = new User("user", "test");
//            user.addRole(userRole);
//            User admin = new User("admin", "test");
//            admin.addRole(adminRole);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return "";
    }
    
    
}
