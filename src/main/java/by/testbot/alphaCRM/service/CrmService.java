package by.testbot.alphaCRM.service;

import by.testbot.alphaCRM.models.Lesson;
import by.testbot.alphaCRM.models.Teacher;
import by.testbot.alphaCRM.payload.requests.AuthorizationRequest;
import by.testbot.alphaCRM.payload.requests.GroupRequest;
import by.testbot.alphaCRM.payload.requests.LessonIndexRequest;
import by.testbot.alphaCRM.payload.requests.SendLessonTypeRequest;
import by.testbot.alphaCRM.payload.responses.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class CrmService {
    @Autowired
    private CrmProxy crmProxy;

    private String token;

    @Value("${alpha.crm.email}")
    private String email;

    @Value("${alpha.crm.apiKey}")
    private String apiKey;

    private void initialToken() {
        AuthorizationRequest authorizationRequest = new AuthorizationRequest();

        authorizationRequest.setEmail(email);
        authorizationRequest.setApi_key(apiKey);

        SetTokenResponse setTokenResponse = crmProxy.authorization(authorizationRequest);

        if (setTokenResponse.getToken() != null) {
            log.info("Token received: " + setTokenResponse.getToken());
            token = setTokenResponse.getToken();
        } else {
            log.info("Token not received: " + setTokenResponse.getCode());
            token = null;
        }
    }

    public boolean isToken() {
        return this.token != null;
    }

    public void getLessonType() {
        initialToken();
        if (isToken()) {
            SendLessonTypeRequest sendLessonTypeRequest = SendLessonTypeRequest.builder()
                    .group_id("1")
                    .build();
            LessonTypeResponse str = crmProxy.sendLessonType(token, "1", sendLessonTypeRequest);
            log.info("LessonType response: " + str);
        }
    }

    public List<Lesson> getAllLesson() {
        initialToken();
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String currentDate = formatter.format(localDate);
        String currentDatePlusFiveDays = formatter.format(localDate.plusDays(10));
        if (isToken()) {
            LessonIndexRequest lesson = LessonIndexRequest.builder()
                    .page("0")
                    .date_from(currentDate)
                    .date_to(currentDatePlusFiveDays)
                    .status("1").build();
            LessonIndexResponse lessonIndexResponse = crmProxy.sendLesson(token, "1", lesson);
            if (!lessonIndexResponse.getLessonList().isEmpty()) {
                return lessonIndexResponse.getLessonList();
            }
        }
        return null;
    }

    public List<Teacher> getListTeacher() {
        initialToken();
        if (isToken()) {
            TeacherResponse response = crmProxy.getListTeachers(token);
            if (!response.getTeachers().isEmpty()) {
                return response.getTeachers();
            }
        } else {
            log.info("Token not setted! ");
        }
        return null;
    }

    public int getListParticipantGroup(int groupId) {
        if (isToken()) {
            GroupResponse response = crmProxy.getListParticipantGroup(token, groupId);
            log.info("List participant group " + groupId + ", count: " + response.getCount());
            return response.getCount();
        }
        return -1;
    }

    public List<Lesson> getGroupLessons() {
        List<Lesson> groupLessonList = new ArrayList<>();
        if (getAllLesson() != null) {
            for (Lesson lesson : getAllLesson()) {
                if (!lesson.getGroup_ids().isEmpty()) {
                    groupLessonList.add(lesson);
                }
            }
            return groupLessonList;
        }
        return null;
    }
}
