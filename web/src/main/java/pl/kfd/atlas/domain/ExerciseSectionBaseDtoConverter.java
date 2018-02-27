package pl.kfd.atlas.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import pl.kfd.atlas.domain.dto.ExerciseSectionBaseDto;

@Component
class ExerciseSectionBaseDtoConverter implements ConverterableToDto<ExerciseSection, ExerciseSectionBaseDto> {

    @Value("${image.server}")
    private String imageServer;

    public ExerciseSectionBaseDto toDto(ExerciseSection exerciseSection) {
        if (exerciseSection == null)
            return ExerciseSectionBaseDto.builder().build();

        return ExerciseSectionBaseDto.builder()
                .id(exerciseSection.getId())
                .title(exerciseSection.getTitle())
                .image(imageServer + exerciseSection.getImage().getUrl())
                .build();
    }
}
