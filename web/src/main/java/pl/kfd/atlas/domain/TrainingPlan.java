package pl.kfd.atlas.domain;

import lombok.Data;
import org.hibernate.annotations.BatchSize;
import pl.kfd.atlas.domain.common.BaseEntity;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "TRAINING_PLAN")
public class TrainingPlan extends BaseEntity {

    @Column(name = "CODE", nullable = false, unique = true)
    private String code;

    @Column(name = "TITLE", nullable = false)
    private String title;

    @Column(name = "SUBTITLE")
    private String subtitle;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "BEFORE_TRAINING")
    private String beforeTraining;

    @Column(name = "AFTER_TRAINING")
    private String afterTraining;

    @Column(name = "TIPS")
    private String tips;

    @Column(name = "ABOUT_AUTHOR")
    private String aboutAuthor;

    @BatchSize(size = 20)
    @OneToMany(mappedBy = "trainingPlan", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<TrainingPlanDay> days;
}
