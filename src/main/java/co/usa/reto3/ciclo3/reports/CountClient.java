package co.usa.reto3.ciclo3.reports;

import co.usa.reto3.ciclo3.model.Client;

/**
 *
 * @author karen
 */
public class CountClient {
    
private long total;
    private Client client;

    public CountClient(long total, Client client) {
        this.total = total;
        this.client = client;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    
}
