package by.testbot.repositories;

import by.testbot.models.BotMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BotMessageRepository extends JpaRepository<BotMessage, Long> {

}
