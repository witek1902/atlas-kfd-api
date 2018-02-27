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
}
