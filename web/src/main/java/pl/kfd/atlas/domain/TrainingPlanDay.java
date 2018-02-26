package pl.kfd.atlas.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import pl.kfd.atlas.domain.common.BaseEntity;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "TRAINING_PLAN_DAY")
public class TrainingPlanDay extends BaseEntity {

    @Column(name = "code", nullable = false, unique = true)
    private String code;

    @Column(name = "TITLE", nullable = false)
    private String title;

    @JsonIgnore
    @JoinColumn(name = "TRAINING_PLAN_ID", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private TrainingPlan trainingPlan;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "TRAINING_PLAN_DAY_EXERCISE",
            joinColumns = @JoinColumn(name = "TRAINING_PLAN_DAY_ID"),
            inverseJoinColumns = @JoinColumn(name = "EXERCISE_ID")
    )
    private Set<Exercise> exercises;
}
