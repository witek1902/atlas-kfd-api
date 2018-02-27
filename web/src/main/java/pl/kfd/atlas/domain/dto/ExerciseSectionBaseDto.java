package pl.kfd.atlas.domain.dto;

import lombok.Builder;
import lombok.Data;
import pl.kfd.atlas.domain.ExerciseSection;

import java.io.Serializable;

@Data
@Builder
public class ExerciseSectionBaseDto extends BaseDto {

    private Long id;
    private String title;
    private String image;
}
