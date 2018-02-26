package pl.kfd.atlas.domain.dto;

import lombok.Builder;
import lombok.Data;
import pl.kfd.atlas.domain.ExerciseSection;

import java.io.Serializable;

@Data
@Builder
public class ExerciseSectionBaseDto implements Serializable {

    private Long id;
    private String title;
    private String iconUrl;

    public static ExerciseSectionBaseDto convert(ExerciseSection exerciseSection) {
        if(exerciseSection == null)
            return ExerciseSectionBaseDto.builder().build();

        return ExerciseSectionBaseDto.builder()
                .id(exerciseSection.getId())
                .title(exerciseSection.getTitle())
                .iconUrl(exerciseSection.getIconUrl())
                .build();
    }
}
