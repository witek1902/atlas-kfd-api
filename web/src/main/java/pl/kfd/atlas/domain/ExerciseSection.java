package pl.kfd.atlas.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.kfd.atlas.domain.common.BaseEntity;
import pl.kfd.atlas.domain.common.Image;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "EXERCISE_SECTION")
public class ExerciseSection extends BaseEntity {

    @Column(name = "TITLE", nullable = false)
    private String title;

    @Column(name = "ICON_URL")
    private Image image;

    @Column(name = "IS_DEFAULT", nullable =  false)
    private boolean isDefault;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "EXERCISE_SECTION_EXERCISE",
            joinColumns = @JoinColumn(name = "EXERCISE_SECTION_ID"),
            inverseJoinColumns = @JoinColumn(name = "EXERCISE_ID")
    )
    private Set<Exercise> exercises;

    public ExerciseSection(String title, String image) {
        this.title = title;
        this.image = new Image(image);
    }

    public void addExercise(Exercise exercise) {
        if(exercise == null)
            return;

        if(exercises == null)
            exercises = new HashSet<>();

        exercises.add(exercise);
    }

    public void removeExercise(Exercise exercise) {
        if(exercise == null || exercises == null || exercises.isEmpty())
            return;

        exercises.remove(exercise);
    }
}
