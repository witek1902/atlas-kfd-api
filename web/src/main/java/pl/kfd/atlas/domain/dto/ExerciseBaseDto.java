package pl.kfd.atlas.domain.dto;

import lombok.Builder;
import lombok.Data;
import pl.kfd.atlas.domain.Exercise;
import pl.kfd.atlas.domain.common.Image;

import java.io.Serializable;
import java.util.Comparator;

@Data
@Builder
public class ExerciseBaseDto implements Serializable {

    public static final Comparator<ExerciseBaseDto> BY_NAME_COMPARATOR = (t1, t2) -> t1.getTitle().compareToIgnoreCase(t2.getTitle());

    private Long id;
    private String code;
    private String title;
    private String mainImageUrl;

    public static ExerciseBaseDto convert(Exercise exercise) {
        if (exercise == null)
            return ExerciseBaseDto.builder().build();

        Image image = exercise.getImages().getImages().stream()
                .findFirst()
                .orElse(Image.empty());

        return ExerciseBaseDto.builder()
                .id(exercise.getId())
                .code(exercise.getCode())
                .title(exercise.getTitle())
                .mainImageUrl(image.getUrl())
                .build();
    }
}
