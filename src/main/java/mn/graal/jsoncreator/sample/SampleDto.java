package mn.graal.jsoncreator.sample;

import io.micronaut.core.annotation.Introspected;

@Introspected
public class SampleDto {
    private SampleType type;

    public SampleType getType() {
        return type;
    }

    public void setType(SampleType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "SampleDto{" + "type=" + type + '}';
    }
}
