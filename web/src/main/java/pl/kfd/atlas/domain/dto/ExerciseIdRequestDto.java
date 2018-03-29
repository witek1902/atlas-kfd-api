package pl.kfd.atlas.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class ExerciseIdRequestDto implements Serializable {
    @NotNull
    private Long exerciseId;
}
