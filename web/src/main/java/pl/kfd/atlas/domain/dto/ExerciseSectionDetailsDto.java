package pl.kfd.atlas.domain.dto;

import lombok.Builder;
import lombok.Data;
import pl.kfd.atlas.domain.ExerciseSection;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class ExerciseSectionDetailsDto implements Serializable {

    private Long id;
    private String title;
    private String imageUrl;
    private List<ExerciseBaseDto> exercises;

    public static ExerciseSectionDetailsDto convert(ExerciseSection section) {
        if (section == null)
            return ExerciseSectionDetailsDto.builder().build();

        return ExerciseSectionDetailsDto.builder()
                .id(section.getId())
                .title(section.getTitle())
                .imageUrl(section.getImage().getUrl())
                .exercises(section.getExercises().stream()
                        .map(ExerciseBaseDto::convert)
                        .sorted(ExerciseBaseDto.BY_NAME_COMPARATOR)
                        .collect(Collectors.toList()))
                .build();
    }
}
