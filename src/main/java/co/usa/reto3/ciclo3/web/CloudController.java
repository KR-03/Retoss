package co.usa.reto3.ciclo3.web;

import co.usa.reto3.ciclo3.model.Cloud;
import co.usa.reto3.ciclo3.service.CloudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
/**
 *
 * @author karen
 */
@RestController
@RequestMapping("/api/Cloud")
public class CloudController {
    
    @Autowired
    private CloudService cloudService;
    
    @GetMapping("/all")
    public List<Cloud> getAll() {
        return cloudService.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Cloud> getCloud(@PathVariable("id") int id) {
        return cloudService.getCloud(id);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Cloud save(@RequestBody Cloud cloud) {
        return cloudService.save(cloud);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Cloud update(@RequestBody Cloud cloud) {
        return cloudService.update(cloud);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return cloudService.deleteCloud(id);
    }      
}