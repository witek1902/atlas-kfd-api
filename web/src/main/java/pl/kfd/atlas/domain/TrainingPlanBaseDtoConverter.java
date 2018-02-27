package pl.kfd.atlas.domain;

import org.springframework.stereotype.Component;
import pl.kfd.atlas.domain.dto.TrainingPlanBaseDto;

@Component
class TrainingPlanBaseDtoConverter implements ConverterableToDto<TrainingPlan, TrainingPlanBaseDto> {

    public TrainingPlanBaseDto toDto(TrainingPlan plan) {
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
