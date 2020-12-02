package by.testbot.alphaCRM.service;

import by.testbot.alphaCRM.payload.requests.AuthorizationRequest;
import by.testbot.alphaCRM.payload.requests.LessonIndexRequest;
import by.testbot.alphaCRM.payload.requests.SendLessonTypeRequest;
import by.testbot.alphaCRM.payload.responses.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@FeignClient(name = "ALFACRM-PROXY", url = "https://megalife.s20.online/v2api")
public interface CrmProxy {
    @PostMapping("/auth/login")
    public SetTokenResponse authorization(@RequestBody AuthorizationRequest authorizationRequest);

    @PostMapping("/{branch}/lesson-type/index")
    public LessonTypeResponse sendLessonType(@RequestHeader("X-ALFACRM-TOKEN") String authenticationToken,
                                             @PathVariable(name = "branch") String branch,
                                             SendLessonTypeRequest sendLessonTypeRequest);

@PostMapping("/{branch}/lesson/index")
    public LessonIndexResponse sendLesson(@RequestHeader("X-ALFACRM-TOKEN") String authenticationToken,
                                          @PathVariable(name = "branch") String branch,
                                          LessonIndexRequest lessonIndexRequest);

    @PostMapping("/teacher/index")
    public TeacherResponse getListTeachers(@RequestHeader("X-ALFACRM-TOKEN") String authenticationToken);

    @PostMapping("/1/cgi/index")
    public GroupResponse getListParticipantGroup(@RequestHeader("X-ALFACRM-TOKEN") String authenticationToken,
                                                 @RequestParam(name = "group_id") int groupRequest);

}
