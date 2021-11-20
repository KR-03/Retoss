/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.reto3.ciclo3.repository.crud;

import co.usa.reto3.ciclo3.model.Message;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author karen
 */

public interface MessageCrudRepository extends CrudRepository<Message, Integer> {
}

