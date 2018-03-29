package pl.kfd.atlas.domain.exception;

public class DefaultSectionModifiedException extends BusinessException {

    public DefaultSectionModifiedException() {
        super("Cannot modify default Section!");
    }
}
