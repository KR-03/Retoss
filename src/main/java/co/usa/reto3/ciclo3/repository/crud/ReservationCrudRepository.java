package co.usa.reto3.ciclo3.repository.crud;

import co.usa.reto3.ciclo3.model.Reservation;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author karen
 */
 
public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer>{
    
    public List<Reservation> findAllByStatus(String status);

        public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo);


        //select clientid, count(*) as "total" from reservation group by clientid order by total desc;


        @Query("SELECT c.client, COUNT(c.client) FROM Reservation AS c group by c.client order by COUNT(c.client)DESC")
        public List<Object[]> countTotalReservationByClient();

}