package by.testbot.services;

import by.testbot.models.BotMessage;
import by.testbot.models.User;
import by.testbot.repositories.BotMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BotMessageService {

    public static long botMessageId;

    @Autowired
    private BotMessageRepository botMessageRepository;

    public void save(BotMessage botMessage) {
        botMessageRepository.save(botMessage);
    }

    public void update(BotMessage botMessage) {
        botMessageRepository.save(botMessage);
    }

    public List<BotMessage> getAllMessages() {
        return botMessageRepository.findAll();
    }

    public void deleteMessage(long botMessageId) {
        if (botMessageRepository.findById(botMessageId).isPresent()) {
            BotMessage botMessage = botMessageRepository.findById(botMessageId).get();
            botMessageRepository.delete(botMessage);
        }
    }

    public BotMessage getBotMessageById(long botMessageId) {
        if (botMessageRepository.findById(botMessageId).isPresent()) {
            return botMessageRepository.findById(botMessageId).get();
        }
        return null;
    }

    public String getStartAllMessagesToString() {
        List<BotMessage> botMessages = getAllMessages();
        String list = "";
        if (!botMessages.isEmpty()) {
            for (int i = 0; i < botMessages.size(); i++) {
                if (botMessages.get(i).getMessageText().length() > 100) {
                    list = list.concat(i + 1 + ". " + botMessages.get(i).getMessageText().substring(0, 60) + "...\n\n");
                } else {
                    list = list.concat("/n/n" + (i + 1) + ". " + botMessages.get(i).getMessageText());
                }
            }
        } else {
            list = "Сообщений нет";
        }
        return list;
    }
}
