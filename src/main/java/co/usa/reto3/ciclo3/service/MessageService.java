package co.usa.reto3.ciclo3.service;

import co.usa.reto3.ciclo3.model.Message;
import co.usa.reto3.ciclo3.repository.MessageRepository;
 import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author karen
 */
@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll() {
        return messageRepository.getAll();
    }

    public Optional<Message> getMessage(int idMessage) {
        return messageRepository.getMessage(idMessage);
    }

    public Message save(Message message) {
        if (message.getIdMessage() == null) {
            return messageRepository.save(message);
        } else {
            Optional<Message> tmpMessage = messageRepository.getMessage(message.getIdMessage());
            if (tmpMessage.isEmpty()) {
                return messageRepository.save(message);
            } else {
                return message;
            }
        }
    }
    
    public Message update(Message message){
        if(message.getIdMessage()!=null){
            Optional<Message> tmpMessage= messageRepository.getMessage(message.getIdMessage());
            if(!tmpMessage.isEmpty()){
                if(message.getMessageText()!=null){
                    tmpMessage.get().setMessageText(message.getMessageText());
                }
                messageRepository.save(tmpMessage.get());
                return tmpMessage.get();
            }else{
                return message;
            }
        }else{
            return message;
        }
    }

    public boolean deleteMessage(int messageId) {
        Boolean result = getMessage(messageId).map(message -> {
            messageRepository.delete(message);
            return true;
        }).orElse(false);
        return result;
    }
}    


