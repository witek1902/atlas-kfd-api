package pl.kfd.atlas.domain.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@AllArgsConstructor
@EqualsAndHashCode
public class Image implements Serializable {

    private final String url;

    public static Image empty() {
        return new Image("");
    }
}
