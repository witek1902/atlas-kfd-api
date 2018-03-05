package pl.kfd.atlas.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.kfd.atlas.domain.dto.TrainingPlanBaseDto;
import pl.kfd.atlas.domain.dto.TrainingPlanDetailsDto;

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

    public Collection<TrainingPlanBaseDto> getAll() {
        List<TrainingPlan> plans = trainingPlanRepository.findAll();
        if(plans == null)
            return new ArrayList<>();

        return plans.stream()
                .map(TrainingPlanBaseDto::convert)
                .sorted(TrainingPlanBaseDto.BY_NAME_COMPARATOR)
                .collect(Collectors.toList());
    }

    public TrainingPlanDetailsDto getById(@NotNull Long trainingPlanId) {
        return TrainingPlanDetailsDto.convert(trainingPlanRepository.findOne(trainingPlanId));
    }

    public TrainingPlanDetailsDto getByCode(@NotNull String trainingPlanCode) {
        return TrainingPlanDetailsDto.convert(trainingPlanRepository.findByCodeIgnoreCase(trainingPlanCode));
    }

    public TrainingPlanDay getDay(@NotNull Long trainingPlanDayId) {
        return trainingPlanDayRepository.findOne(trainingPlanDayId);
    }
}
