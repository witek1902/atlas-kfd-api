package pl.kfd.atlas.domain.dto;

import lombok.Builder;
import lombok.Data;
import pl.kfd.atlas.domain.TrainingPlanDay;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class TrainingPlanDayDto implements Serializable {

    private String code;
    private String title;
    private List<ExerciseDetailsDto> exercises;

    public static TrainingPlanDayDto convert(TrainingPlanDay day) {
        if (day == null)
            return TrainingPlanDayDto.builder().build();

        return TrainingPlanDayDto.builder()
                .code(day.getCode())
                .title(day.getTitle())
                .exercises(day.getExercises().stream()
                        .map(ExerciseDetailsDto::convert)
                        .collect(Collectors.toList()))
                .build();
    }
}
