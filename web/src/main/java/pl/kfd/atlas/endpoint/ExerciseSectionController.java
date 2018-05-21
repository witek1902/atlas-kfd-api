package pl.kfd.atlas.endpoint;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.kfd.atlas.domain.*;
import pl.kfd.atlas.domain.dto.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.Collection;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ExerciseSectionController {

    private final ExerciseSectionModifier exerciseSectionModifier;
    private final ExerciseSectionProvider exerciseSectionProvider;


    @GetMapping(path = "/sections")
    public Collection<ExerciseSectionBaseDto> sections() {
        return exerciseSectionProvider.getAll();
    }


    @GetMapping(path = "/sections/{sectionId}")
    public ResponseEntity<ExerciseSectionDetailsDto> sectionById(@PathVariable Long sectionId) {
        ExerciseSectionDetailsDto section = exerciseSectionProvider.get(sectionId);

        if (section == null)
            return ResponseEntity.notFound().build();


        return ResponseEntity.ok(section);
    }
}
