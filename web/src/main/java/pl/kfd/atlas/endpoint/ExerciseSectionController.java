package pl.kfd.atlas.endpoint;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.kfd.atlas.domain.*;
import pl.kfd.atlas.domain.dto.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.Collection;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ExerciseSectionController {

    private final ExerciseSectionModifier exerciseSectionModifier;
    private final ExerciseSectionProvider exerciseSectionProvider;


    @GetMapping(path = "/sections")
    public Collection<ExerciseSectionBaseDto> sections() {
        return exerciseSectionProvider.getAll();
    }


    @GetMapping(path = "/sections/{sectionId}")
    public ResponseEntity<ExerciseSectionDetailsDto> sectionById(@PathVariable Long sectionId) {
        ExerciseSectionDetailsDto section = exerciseSectionProvider.get(sectionId);

        if (section == null)
            return ResponseEntity.notFound().build();


        return ResponseEntity.ok(section);
    }

    @PostMapping(path = "/sections")
    public ResponseEntity<?> createSection(@Valid @RequestBody ExerciseSectionBaseDto exerciseSection) {
        exerciseSectionModifier.save(exerciseSection);

        return ResponseEntity.created(URI.create("/sections")).build();
    }

    @PostMapping(path = "/sections/{sectionId}/exercises")
    public ResponseEntity<?> addExerciseToSection(@Valid @RequestBody ExerciseIdRequestDto exercise, @PathVariable Long sectionId) {
        exerciseSectionModifier.addExerciseToSection(new AddExerciseToSectionRequestDto(sectionId, exercise.getExerciseId()));

        return ResponseEntity.ok().build();
    }

    @DeleteMapping(path = "sections/{sectionId}/exercises/{exerciseId}")
    public ResponseEntity<?> removeExerciseFromSection(@PathVariable Long sectionId, @PathVariable Long exerciseId) {
        exerciseSectionModifier.removeExerciseFromSection(new RemoveExerciseFromSectionRequestDto(sectionId, exerciseId));

        return ResponseEntity.ok().build();
    }
}
