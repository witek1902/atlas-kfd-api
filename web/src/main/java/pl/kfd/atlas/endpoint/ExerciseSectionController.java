package pl.kfd.atlas.endpoint;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.kfd.atlas.domain.Exercise;
import pl.kfd.atlas.domain.ExerciseProvider;
import pl.kfd.atlas.domain.ExerciseSection;
import pl.kfd.atlas.domain.ExerciseSectionProvider;
import pl.kfd.atlas.domain.dto.ExerciseSectionBaseDto;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ExerciseSectionController {

    private final ExerciseSectionProvider exerciseSectionProvider;
    private final ExerciseProvider exerciseProvider;

    @GetMapping(path = "/sections")
    public Collection<ExerciseSectionBaseDto> sections() {
        return exerciseSectionProvider.getAll();
    }

    @PostMapping(path = "/sections")
    public ExerciseSection createSection(@Valid @RequestBody ExerciseSection exerciseSection) {
        return exerciseSection;
    }

    @GetMapping(path = "/sections/{sectionId}")
    public ResponseEntity<ExerciseSection> sectionById(@PathVariable Long sectionId) {
        ExerciseSection exerciseSection = exerciseSectionProvider.get(sectionId);

        if (exerciseSection == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(exerciseSection);
    }

    @GetMapping(path = "/section/{sectionId}/exercises")
    public Collection<Exercise> exercisesBySection(@PathVariable Long sectionId) {
        return exerciseProvider.getForSection(sectionId);
    }
}
