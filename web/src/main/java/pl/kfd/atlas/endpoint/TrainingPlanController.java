package pl.kfd.atlas.endpoint;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.kfd.atlas.domain.TrainingPlan;
import pl.kfd.atlas.domain.TrainingPlanDay;
import pl.kfd.atlas.domain.TrainingPlanProvider;
import pl.kfd.atlas.domain.dto.TrainingPlanBaseDto;
import pl.kfd.atlas.domain.dto.TrainingPlanDetailsDto;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TrainingPlanController {

    private final TrainingPlanProvider trainingPlanProvider;

    @GetMapping(path = "/trainingPlans")
    public Collection<TrainingPlanBaseDto> trainingPlans() {
        return trainingPlanProvider.getAll();
    }

    @GetMapping(path = "/trainingPlans/{trainingPlanId}")
    public ResponseEntity<TrainingPlanDetailsDto> trainingPlanById(@PathVariable Long trainingPlanId) {
        TrainingPlanDetailsDto trainingPlan = trainingPlanProvider.getById(trainingPlanId);
        return getTrainingPlanDetailsDtoResponseEntity(trainingPlan);
    }

    @GetMapping(path = "/trainingPlans/code/{trainingPlanCode}")
    public ResponseEntity<TrainingPlanDetailsDto> trainingPlanByCode(@PathVariable String trainingPlanCode) {
        TrainingPlanDetailsDto trainingPlan = trainingPlanProvider.getByCode(trainingPlanCode);
        return getTrainingPlanDetailsDtoResponseEntity(trainingPlan);
    }

    private ResponseEntity<TrainingPlanDetailsDto> getTrainingPlanDetailsDtoResponseEntity(TrainingPlanDetailsDto trainingPlan) {
        if(trainingPlan == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(trainingPlan);
    }
}
