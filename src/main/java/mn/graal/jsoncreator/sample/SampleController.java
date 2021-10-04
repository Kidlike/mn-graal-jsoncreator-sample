package mn.graal.jsoncreator.sample;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;

@Controller
public class SampleController {

    @Post
    public SampleDto echo(SampleDto sampleDto) {
        System.out.println(sampleDto);
        return sampleDto;
    }
}
