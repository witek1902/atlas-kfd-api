package pl.kfd.atlas.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.kfd.atlas.domain.dto.ExerciseSectionBaseDto;

@Component
@RequiredArgsConstructor
public class ExerciseSectionSaver {

    private final ExerciseSectionRepository exerciseSectionRepository;

    public void save(ExerciseSectionBaseDto dto) {
        exerciseSectionRepository.save(new ExerciseSection(dto.getTitle(), dto.getImage()));
    }
}
