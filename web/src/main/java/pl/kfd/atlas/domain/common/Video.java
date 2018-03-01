package pl.kfd.atlas.domain.common;

import lombok.Data;

import java.io.Serializable;

@Data
public class Video implements Serializable {

    private final static String YOUTUBE_URL = "youtube";
    private final static String YOUTUBE_WATCH_PREFIX = "watch?v=";
    private final static String YOUTUBE_EMBED_PREFIX = "embed/";

    private final String url;
    private final String embedYoutubeUrl;

    public Video(String videoUrl) {
        url = videoUrl;
        embedYoutubeUrl = convertYoutubeToEmbedUrl(videoUrl);
    }

    private String convertYoutubeToEmbedUrl(String url) {
        if (url == null)
            return "";

        if(!url.contains(YOUTUBE_URL))
            return url;

        return url.replace(YOUTUBE_WATCH_PREFIX, YOUTUBE_EMBED_PREFIX);
    }

    public static Video empty() {
        return new Video("");
    }
}
