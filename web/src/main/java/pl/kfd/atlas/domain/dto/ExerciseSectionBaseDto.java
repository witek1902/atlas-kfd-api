package pl.kfd.atlas.domain.dto;

import lombok.Builder;
import lombok.Data;
import pl.kfd.atlas.domain.ExerciseSection;

import javax.validation.constraints.NotNull;
import java.util.Comparator;

@Data
@Builder
public class ExerciseSectionBaseDto extends BaseDto {

    public static final Comparator<ExerciseSectionBaseDto> BY_NAME_COMPARATOR = (t1, t2) -> t1.getTitle().compareToIgnoreCase(t2.getTitle());

    private Long id;
    private String title;
    private String image;

    public static ExerciseSectionBaseDto convert(ExerciseSection exerciseSection) {
        if (exerciseSection == null)
            return ExerciseSectionBaseDto.builder().build();

        return ExerciseSectionBaseDto.builder()
                .id(exerciseSection.getId())
                .title(exerciseSection.getTitle())
                .image(exerciseSection.getImage().getUrl())
                .build();
    }
}
