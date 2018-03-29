package pl.kfd.atlas.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.kfd.atlas.domain.common.BaseEntity;
import pl.kfd.atlas.domain.common.Image;
import pl.kfd.atlas.domain.common.ImageList;
import pl.kfd.atlas.domain.common.Video;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "EXERCISE")
public class Exercise extends BaseEntity {

    @Column(name = "CODE", nullable = false, unique = true)
    private String code;

    @Column(name = "TITLE", nullable = false)
    private String title;

    @Column(name = "SUBTITLE")
    private String subtitle;

    @Column(name = "MUSCLE_IMAGE_URL")
    private Image muscleImage;

    @Column(name = "VIDEO_URL")
    private Video video;

    @Column(name = "MAIN_MUSCLES")
    private String mainMuscles;

    @Column(name = "AUXILIARY_MUSCLES")
    private String auxiliaryMuscles;

    @Column(name = "STABILIZERS")
    private String stabilizers;

    @Column(name = "EXECUTION")
    private String execution;

    @Column(name = "REMARKS")
    private String remarks;

    @Column(name = "IMAGE_URL_LIST")
    private ImageList images;

    @Column(name = "IS_DEFAULT", nullable = false)
    private boolean isDefault;

}
