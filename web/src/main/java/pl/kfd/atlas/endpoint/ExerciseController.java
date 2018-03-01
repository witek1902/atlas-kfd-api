package pl.kfd.atlas.endpoint;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.kfd.atlas.domain.Exercise;
import pl.kfd.atlas.domain.ExerciseProvider;
import pl.kfd.atlas.domain.dto.ExerciseBaseDto;
import pl.kfd.atlas.domain.dto.ExerciseDetailsDto;

import java.util.Collection;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ExerciseController {

    private final ExerciseProvider exerciseProvider;

    @GetMapping(path = "/exercises")
    public Collection<ExerciseBaseDto> exercises() {
        return exerciseProvider.getAll();
    }

    @GetMapping(path = "/exercises/{exerciseId}")
    public ResponseEntity<ExerciseDetailsDto> exerciseById(@PathVariable Long exerciseId) {
        ExerciseDetailsDto exercise = exerciseProvider.getById(exerciseId);
        if(exercise.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(exercise);
    }

    @GetMapping(path = "/exercises/code/{exerciseCode}")
    public ResponseEntity<ExerciseDetailsDto> exerciseByCode(@PathVariable String exerciseCode) {
        ExerciseDetailsDto exercise = exerciseProvider.getByCode(exerciseCode);
        if(exercise.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(exercise);
    }

}
