package pl.kfd.atlas.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.kfd.atlas.domain.dto.AddExerciseToSectionRequestDto;
import pl.kfd.atlas.domain.dto.ExerciseSectionBaseDto;
import pl.kfd.atlas.domain.dto.RemoveExerciseFromSectionRequestDto;
import pl.kfd.atlas.domain.exception.DefaultSectionModifiedException;

import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;

@Component
@RequiredArgsConstructor
public class ExerciseSectionModifier {

    private final ExerciseSectionRepository exerciseSectionRepository;
    private final ExerciseRepository exerciseRepository;

    public void save(ExerciseSectionBaseDto dto) {
        exerciseSectionRepository.save(new ExerciseSection(dto.getTitle(), dto.getImage()));
    }

    @Transactional
    public void addExerciseToSection(@NotNull AddExerciseToSectionRequestDto request) {
        if(request.getExerciseId() == null || request.getExerciseSectionId() == null)
            throw new IllegalArgumentException();

        ExerciseSection section = exerciseSectionRepository.findOne(request.getExerciseSectionId());
        if(section.isDefault())
            throw new DefaultSectionModifiedException();

        Exercise exercise = exerciseRepository.findOne(request.getExerciseId());

        section.addExercise(exercise);
    }

    @Transactional
    public void removeExerciseFromSection(@NotNull RemoveExerciseFromSectionRequestDto request) {
        if(request.getExerciseId() == null || request.getExerciseSectionId() == null)
            throw new IllegalArgumentException();

        ExerciseSection section = exerciseSectionRepository.findOne(request.getExerciseSectionId());
        if(section.isDefault())
            throw new DefaultSectionModifiedException();

        Exercise exercise = exerciseRepository.findOne(request.getExerciseId());

        section.removeExercise(exercise);
    }
}
