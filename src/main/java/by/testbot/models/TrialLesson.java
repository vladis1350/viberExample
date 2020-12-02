package by.testbot.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "trial_lesson")
public class TrialLesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "viber_id")
    private String viberId;

    @Column(name = "child_name")
    private String childName;

    @Column(name = "child_age")
    private String childAge;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "type_lessons")
    private String typeLesson;

    @Column(name = "dateTime")
    private String dateTime;

}
