package pl.kfd.atlas.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import pl.kfd.atlas.domain.Exercise;
import pl.kfd.atlas.domain.common.Image;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class ExerciseDetailsDto implements Serializable {

    private Long id;
    private String code;
    private String title;
    private String subtitle;
    private String muscleImageUrl;
    private String embedVideoUrl;
    private String mainMuscles;
    private String auxiliaryMuscles;
    private String stabilizers;
    private String execution;
    private String remarks;
    private List<String> imageUrls;

    public static ExerciseDetailsDto convert(Exercise exercise) {
        if (exercise == null)
            return ExerciseDetailsDto.builder().build();

        return ExerciseDetailsDto.builder()
                .id(exercise.getId())
                .title(exercise.getTitle())
                .subtitle(exercise.getSubtitle())
                .muscleImageUrl(exercise.getMuscleImage().getUrl())
                .embedVideoUrl(exercise.getVideo().getEmbedYoutubeUrl())
                .mainMuscles(exercise.getMainMuscles())
                .auxiliaryMuscles(exercise.getAuxiliaryMuscles())
                .stabilizers(exercise.getStabilizers())
                .execution(exercise.getExecution())
                .remarks(exercise.getRemarks())
                .imageUrls(exercise.getImages().getImages().stream()
                        .map(Image::getUrl)
                        .collect(Collectors.toList()))
                .build();
    }

    @JsonIgnore
    public boolean isEmpty() {
        return id == null && code == null;
    }
}
