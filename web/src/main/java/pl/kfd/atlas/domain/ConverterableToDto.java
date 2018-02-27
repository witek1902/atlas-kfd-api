package pl.kfd.atlas.domain;

import pl.kfd.atlas.domain.common.BaseEntity;
import pl.kfd.atlas.domain.dto.BaseDto;

@FunctionalInterface
public interface ConverterableToDto<E extends BaseEntity, D extends BaseDto> {
    D toDto(E entity);
}
