package pl.kfd.atlas.domain.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@RequiredArgsConstructor
public class RemoveExerciseFromSectionRequestDto implements Serializable {

    private final Long exerciseSectionId;
    private final Long exerciseId;
}
