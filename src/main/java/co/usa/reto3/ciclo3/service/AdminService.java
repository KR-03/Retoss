package co.usa.reto3.ciclo3.service;

import co.usa.reto3.ciclo3.model.Admin;
import co.usa.reto3.ciclo3.repository.AdminRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author karen
 */

@Service
public class AdminService {
    
    @Autowired
    private AdminRepository adminRepository;
    
    public List<Admin> getAll(){
        return adminRepository.getAll();
    }
    public Optional<Admin> getAdmin(int id){
        return adminRepository.getAdmin(id);
    }
    public Admin save(Admin admin){
        if (admin.getId() == null){
            return adminRepository.save(admin);
        }else{
            Optional<Admin> tmpAdmin=adminRepository.getAdmin(admin.getId());
            if (tmpAdmin.isEmpty()){
                return adminRepository.save(admin);
            }else {
                return admin;
            }
        }
    }
 
    public Admin update(Admin admin){
        if(admin.getId()!=null){
            Optional<Admin>g= adminRepository.getAdmin(admin.getId());
            if(!g.isEmpty()){
                if(admin.getPassword()!=null){
                    g.get().setPassword(admin.getPassword());
                }
                if(admin.getName()!=null){
                    g.get().setName(admin.getName());
                }
                return adminRepository.save(g.get());
            }
        }
        return admin;
    }
    
    public boolean deleteAdmin(int adminId){
        Boolean d=getAdmin(adminId).map(admin -> {
            adminRepository.delete(admin);
            return true;
        }).orElse(false);
        return d;
    }    
}

