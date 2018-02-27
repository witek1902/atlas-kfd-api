package pl.kfd.atlas.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.kfd.atlas.domain.common.BaseEntity;
import pl.kfd.atlas.domain.common.Image;

import javax.persistence.*;
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

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "EXERCISE_SECTION_EXERCISE",
            joinColumns = @JoinColumn(name = "EXERCISE_SECTION_ID"),
            inverseJoinColumns = @JoinColumn(name = "EXERCISE_ID")
    )
    private Set<Exercise> exercises;
}
