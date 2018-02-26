package pl.kfd.atlas.domain.common;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Video implements Serializable {

    private final String url;

    public static Video empty() {
        return new Video("");
    }
}
