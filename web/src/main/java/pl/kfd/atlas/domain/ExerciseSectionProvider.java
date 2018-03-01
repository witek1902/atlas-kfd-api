package pl.kfd.atlas.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.kfd.atlas.domain.dto.ExerciseSectionBaseDto;
import pl.kfd.atlas.domain.dto.ExerciseSectionDetailsDto;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ExerciseSectionProvider {

    private final ExerciseSectionRepository exerciseSectionRepository;

    public Collection<ExerciseSectionBaseDto> getAll() {
        List<ExerciseSection> sections = exerciseSectionRepository.findAll();
        if(sections == null)
            return new ArrayList<>();

        return sections.stream()
                .map(ExerciseSectionBaseDto::convert)
                .collect(Collectors.toList());
    }

    public ExerciseSectionDetailsDto get(@NotNull Long sectionId) {
        ExerciseSection section = exerciseSectionRepository.findOne(sectionId);
        return ExerciseSectionDetailsDto.convert(section);
    }
}
