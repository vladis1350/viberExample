package by.testbot.services;

import by.testbot.models.TrialLesson;
import by.testbot.repositories.TrialLessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class TrialLessonService {

    @Autowired
    private TrialLessonRepository trialLessonRepository;

    @Transactional
    public void save(TrialLesson trialLesson) {
        TrialLesson trialLesson1 = trialLessonRepository.findTrialLessonByViberId(trialLesson.getViberId());
        if (trialLesson1 == null) {
            trialLessonRepository.save(trialLesson);
        } else {
            trialLessonRepository.save(trialLesson1);
        }
    }

    @Transactional
    public TrialLesson findTrialLessonById(String viberId) {
        return trialLessonRepository.findTrialLessonByViberId(viberId);
    }

    @Transactional
    public void deleteUserById(String viberId) {
        trialLessonRepository.deleteTrialLessonByViberId(viberId);
    }
}
