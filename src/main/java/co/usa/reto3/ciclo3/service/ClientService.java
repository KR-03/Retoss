package co.usa.reto3.ciclo3.service;

import co.usa.reto3.ciclo3.model.Client;
import co.usa.reto3.ciclo3.repository.ClientRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author karen
 */
@Service
public class ClientService {
     @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll() {
        return clientRepository.getAll();
    }
    public Optional<Client> getClient(int idClient) {
        return clientRepository.getClient(idClient);
    }
    
    public Client save(Client client) {
        if (client.getIdClient() == null) {
            return clientRepository.save(client);
        } else {
            Optional<Client> tmpClient = clientRepository.getClient(client.getIdClient());
            if (tmpClient.isEmpty()) {
                return clientRepository.save(client);
            } else {
                return client;
            }
        }
    }
    
    public Client update(Client client){
        if(client.getIdClient()!=null){
            Optional<Client> tmpClient= clientRepository.getClient(client.getIdClient());
            if(!tmpClient.isEmpty()){
                if(client.getName()!=null){
                    tmpClient.get().setName(client.getName());
                }
                if(client.getAge()!=null){
                    tmpClient.get().setAge(client.getAge());
                }
                if(client.getPassword()!=null){
                    tmpClient.get().setPassword(client.getPassword());
                }
                clientRepository.save(tmpClient.get());
                return tmpClient.get();
            }else{
                return client;
            }
        }else{
            return client;
        }
    }

    public boolean deleteClient(int clientId) {
        Boolean result = getClient(clientId).map(client -> {
            clientRepository.delete(client);
            return true;
        }).orElse(false);
        return result;
    }
    
}
