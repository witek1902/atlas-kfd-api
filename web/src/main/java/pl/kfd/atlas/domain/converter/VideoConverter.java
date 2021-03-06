package pl.kfd.atlas.domain.converter;

import pl.kfd.atlas.domain.common.Video;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class VideoConverter implements AttributeConverter<Video, String> {

    @Override
    public String convertToDatabaseColumn(Video video) {
        return video != null ? video.getUrl() : null;
    }

    @Override
    public Video convertToEntityAttribute(String videoUrl) {
        return videoUrl == null ? Video.empty() : new Video(videoUrl);
    }
}
