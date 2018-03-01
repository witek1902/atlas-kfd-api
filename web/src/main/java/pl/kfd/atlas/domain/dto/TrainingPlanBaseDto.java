package pl.kfd.atlas.domain.dto;

import lombok.Builder;
import lombok.Data;
import pl.kfd.atlas.domain.TrainingPlan;

import java.io.Serializable;

@Data
@Builder
public class TrainingPlanBaseDto extends BaseDto {

    private Long id;
    private String title;
    private String subtitle;
    private int numberOfDays;

    public static TrainingPlanBaseDto convert(TrainingPlan plan) {
        if (plan == null)
            return TrainingPlanBaseDto.builder().build();

        return TrainingPlanBaseDto.builder()
                .id(plan.getId())
                .title(plan.getTitle())
                .subtitle(plan.getSubtitle())
                .numberOfDays(plan.getDays() == null ? 0 : plan.getDays().size())
                .build();
    }
}
