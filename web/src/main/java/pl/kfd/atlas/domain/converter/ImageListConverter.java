package pl.kfd.atlas.domain.converter;

import pl.kfd.atlas.domain.common.Image;
import pl.kfd.atlas.domain.common.ImageList;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Converter(autoApply = true)
public class ImageListConverter implements AttributeConverter<ImageList, String> {

    public static final String DELIMITER = ";";

    @Override
    public String convertToDatabaseColumn(ImageList images) {
        if (images == null || images.isEmpty())
            return null;

        List<String> urls = images.getImages().stream()
                .map(Image::getUrl)
                .collect(Collectors.toList());

        return String.join(DELIMITER, urls);

    }

    @Override
    public ImageList convertToEntityAttribute(String urls) {
        if(urls == null)
            return ImageList.empty();

        ImageList images = new ImageList();
        Arrays.asList(urls.split(DELIMITER)).stream()
                .forEach(url -> images.addByUrl(url));

        return images;
    }
}
