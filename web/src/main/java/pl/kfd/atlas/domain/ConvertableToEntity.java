package pl.kfd.atlas.domain;

import pl.kfd.atlas.domain.common.BaseEntity;
import pl.kfd.atlas.domain.dto.BaseDto;

@FunctionalInterface
public interface ConvertableToEntity<E extends BaseEntity, D extends BaseDto> {
    E toEntity(D dto);
}
