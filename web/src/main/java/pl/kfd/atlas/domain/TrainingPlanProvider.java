package pl.kfd.atlas.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.kfd.atlas.domain.dto.TrainingPlanBaseDto;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class TrainingPlanProvider {

    private final TrainingPlanRepository trainingPlanRepository;
    private final TrainingPlanDayRepository trainingPlanDayRepository;
    private final TrainingPlanBaseDtoConverter trainingPlanBaseDtoConverter;

    public Collection<TrainingPlanBaseDto> getAll() {
        List<TrainingPlan> plans = trainingPlanRepository.findAll();
        if(plans == null)
            return new ArrayList<>();

        return plans.stream()
                .map(trainingPlanBaseDtoConverter::toDto)
                .collect(Collectors.toList());
    }

    public TrainingPlan getById(@NotNull Long trainingPlanId) {
        return trainingPlanRepository.findOne(trainingPlanId);
    }

    public TrainingPlanDay getDay(@NotNull Long trainingPlanDayId) {
        return trainingPlanDayRepository.findOne(trainingPlanDayId);
    }

    public TrainingPlan getByCode(@NotNull String trainingPlanCode) {
        return trainingPlanRepository.findByCodeIgnoreCase(trainingPlanCode);
    }
}
