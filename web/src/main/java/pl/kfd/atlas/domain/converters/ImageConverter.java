package pl.kfd.atlas.domain.converters;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import pl.kfd.atlas.domain.common.Image;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class ImageConverter implements AttributeConverter<Image, String> {

    @Override
    public String convertToDatabaseColumn(Image image) {
        return image != null ? image.getUrl() : null;
    }

    @Override
    public Image convertToEntityAttribute(String s) {
        return s == null ? Image.empty() : new Image(s);
    }
}
