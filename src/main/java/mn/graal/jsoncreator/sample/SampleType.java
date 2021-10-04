package mn.graal.jsoncreator.sample;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.micronaut.core.annotation.Introspected;

import java.util.Arrays;

@Introspected
public enum SampleType {
    ONE("one"),
    TWO("two");

    private final String type;

    @JsonValue
    public String getType() {
        return type;
    }

    SampleType(String type) {
        this.type = type;
    }

    // @Creator
    @JsonCreator
    @SuppressWarnings("unused")
    public SampleType fromString(String type) {
        return Arrays.stream(SampleType.values())
                .filter(sampleType -> sampleType.type.equals(type))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unsupported value for type: " + type));
    }
}
