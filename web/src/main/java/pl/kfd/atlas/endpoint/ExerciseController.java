package pl.kfd.atlas.endpoint;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.kfd.atlas.domain.Exercise;
import pl.kfd.atlas.domain.ExerciseProvider;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ExerciseController {

    private final ExerciseProvider exerciseProvider;

    @GetMapping(path = "/exercises")
    public List<Exercise> exercises() {
        return exerciseProvider.getAll();
    }

    @GetMapping(path = "/exercises/{exerciseId}")
    public ResponseEntity<Exercise> exerciseById(@PathVariable Long exerciseId) {
        Exercise exercise = exerciseProvider.getById(exerciseId);
        if(exercise == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(exercise);
    }

    @GetMapping(path = "/exercises/code/{exerciseCode}")
    public ResponseEntity<Exercise> exerciseByCode(@PathVariable String exerciseCode) {
        Exercise exercise = exerciseProvider.getByCode(exerciseCode);
        if(exercise == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(exercise);
    }

}
