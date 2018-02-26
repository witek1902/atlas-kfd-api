package pl.kfd.atlas.domain.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import org.springframework.util.StringUtils;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
public class ImageList implements Serializable {

    private List<Image> images;

    public void addByUrl(@NotNull String url) {
        if(StringUtils.isEmpty(url))
            return;

        add(new Image(url));
    }

    public void add(@NotNull Image image) {
        if (images == null)
            images = new ArrayList<>();

        images.add(image);
    }

    public void remove(@NotNull Image image) {
        if (isEmpty())
            return;

        images.remove(image);
    }

    public void removeByUrl(@NotNull String url) {
        if(StringUtils.isEmpty(url))
            return;

        remove(new Image(url));
    }

    @JsonIgnore
    public boolean isEmpty() {
        return images == null || images.isEmpty();
    }

    public static ImageList empty() {
        return new ImageList();
    }
}
