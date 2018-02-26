package pl.kfd.atlas.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ExerciseProvider {

    private final ExerciseRepository exerciseRepository;
    private final ExerciseSectionRepository exerciseSectionRepository;

    public Collection<Exercise> getForSection(@NotNull Long sectionId) {
        return exerciseSectionRepository.findOne(sectionId).getExercises();
    }

    public List<Exercise> getAll() {
        return exerciseRepository.findAll();
    }

    public Exercise getById(@NotNull Long exerciseId) {
        return exerciseRepository.findOne(exerciseId);
    }

    public Exercise getByCode(@NotNull String exerciseCode) {
        return exerciseRepository.findByCodeIgnoreCase(exerciseCode);
    }
}
