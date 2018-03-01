package pl.kfd.atlas.domain.dto;

import lombok.Builder;
import lombok.Data;
import pl.kfd.atlas.domain.ExerciseSection;

import javax.validation.constraints.NotNull;

@Data
@Builder
public class ExerciseSectionBaseDto extends BaseDto {

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
