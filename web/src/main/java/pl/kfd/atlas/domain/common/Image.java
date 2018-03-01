package pl.kfd.atlas.domain.common;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Data
@RequiredArgsConstructor
@EqualsAndHashCode
public class Image implements Serializable {

    private final String url;

    public static Image empty() {
        return new Image("");
    }
}
