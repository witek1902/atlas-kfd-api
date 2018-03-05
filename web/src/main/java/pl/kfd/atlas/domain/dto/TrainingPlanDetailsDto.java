package pl.kfd.atlas.domain.dto;

import lombok.Builder;
import lombok.Data;
import pl.kfd.atlas.domain.TrainingPlan;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class TrainingPlanDetailsDto implements Serializable {

    private String code;
    private String title;
    private String subtitle;
    private String description;
    private String beforeTraining;
    private String afterTraining;
    private String tips;
    private String aboutAuthor;
    private List<TrainingPlanDayDto> days;

    public static TrainingPlanDetailsDto convert(TrainingPlan plan) {
        if (plan == null)
            return TrainingPlanDetailsDto.builder().build();

        return TrainingPlanDetailsDto.builder()
                .code(plan.getCode())
                .title(plan.getTitle())
                .subtitle(plan.getSubtitle())
                .description(plan.getDescription())
                .beforeTraining(plan.getBeforeTraining())
                .afterTraining(plan.getAfterTraining())
                .tips(plan.getTips())
                .aboutAuthor(plan.getAboutAuthor())
                .days(plan.getDays().stream()
                        .map(TrainingPlanDayDto::convert)
                        .collect(Collectors.toList()))
                .build();
    }
}
