package pl.kfd.atlas.endpoint;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.kfd.atlas.domain.TrainingPlan;
import pl.kfd.atlas.domain.TrainingPlanDay;
import pl.kfd.atlas.domain.TrainingPlanProvider;
import pl.kfd.atlas.domain.dto.TrainingPlanBaseDto;

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

    @PostMapping(path = "/trainingPlans")
    public TrainingPlan createTrainingPlan(@Valid @RequestBody TrainingPlan trainingPlan) {
        return trainingPlan;
    }

    @GetMapping(path = "/trainingPlans/{trainingPlanId}")
    public ResponseEntity<TrainingPlan> trainingPlanById(@PathVariable Long trainingPlanId) {
        TrainingPlan trainingPlan = trainingPlanProvider.getById(trainingPlanId);

        if(trainingPlan == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(trainingPlan);
    }

    @GetMapping(path = "/trainingPlans/code/{trainingPlanCode}")
    public ResponseEntity<TrainingPlan> trainingPlanByCode(@PathVariable String trainingPlanCode) {
        TrainingPlan trainingPlan = trainingPlanProvider.getByCode(trainingPlanCode);

        if(trainingPlan == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(trainingPlan);
    }

    @GetMapping(path = "/trainingPlanDays/{trainingPlanDayId}")
    public ResponseEntity<TrainingPlanDay> trainingPlanDays(@PathVariable Long trainingPlanDayId) {
        TrainingPlanDay trainingPlanDay = trainingPlanProvider.getDay(trainingPlanDayId);

        if(trainingPlanDay == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(trainingPlanDay);
    }

}
