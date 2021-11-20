package co.usa.reto3.ciclo3.repository;

import co.usa.reto3.ciclo3.model.Cloud;
import co.usa.reto3.ciclo3.repository.crud.CloudCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author karen
 */

@Repository
public class CloudRepository {
    
    @Autowired
    private CloudCrudRepository cloudCrudRepository;

    public List<Cloud> getAll(){
        return (List<Cloud>) cloudCrudRepository.findAll();
    }

    public Optional<Cloud> getCloud(int id){
        return cloudCrudRepository.findById(id);
    }

    public Cloud save(Cloud cld){
        return cloudCrudRepository.save(cld);
    }
    
    public void delete(Cloud cloud){
        cloudCrudRepository.delete(cloud);
    }
}   

