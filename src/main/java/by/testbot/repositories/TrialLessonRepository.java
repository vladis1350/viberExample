package by.testbot.repositories;

import by.testbot.models.TrialLesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrialLessonRepository extends JpaRepository<TrialLesson, Long> {
    TrialLesson findTrialLessonByViberId(String viberId);
    void deleteTrialLessonByViberId(String viberId);
}
