package pl.kfd.atlas.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.kfd.atlas.domain.dto.ExerciseBaseDto;
import pl.kfd.atlas.domain.dto.ExerciseDetailsDto;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ExerciseProvider {

    private final ExerciseRepository exerciseRepository;
    private final ExerciseSectionRepository exerciseSectionRepository;


    public Collection<ExerciseBaseDto> getAll() {
        return exerciseRepository.findAll().stream()
                .map(ExerciseBaseDto::convert)
                .collect(Collectors.toList());
    }

    public Collection<ExerciseBaseDto> getForSection(@NotNull Long sectionId) {
        Set<Exercise> exercises = exerciseSectionRepository.findOne(sectionId).getExercises();
        if(exercises == null)
            return new ArrayList<>();

        return exercises.stream()
                .map(ExerciseBaseDto::convert)
                .collect(Collectors.toList());
    }

    public ExerciseDetailsDto getById(@NotNull Long exerciseId) {
        return ExerciseDetailsDto.convert(exerciseRepository.findOne(exerciseId));
    }

    public ExerciseDetailsDto getByCode(@NotNull String exerciseCode) {
        return ExerciseDetailsDto.convert(exerciseRepository.findByCodeIgnoreCase(exerciseCode));
    }

}
