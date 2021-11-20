package co.usa.reto3.ciclo3.repository;

import co.usa.reto3.ciclo3.model.Admin;
import co.usa.reto3.ciclo3.repository.crud.AdminCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author karen
 */
@Repository
public class AdminRepository {

    @Autowired
    private AdminCrudRepository admiCrudRepository;

    public List<Admin> getAll() {
        return (List<Admin>) admiCrudRepository.findAll();
    }

    public Optional<Admin> getAdmin(int id) {
        return admiCrudRepository.findById(id);
    }

    public Admin save(Admin admin) {
        return admiCrudRepository.save(admin);
    }
    
    public void delete(Admin admin){
        admiCrudRepository.delete(admin);
    }

}
