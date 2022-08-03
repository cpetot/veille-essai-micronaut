package first.micronaut.app.infrastructure.web;

import java.time.LocalDate;
import java.util.List;

import first.micronaut.app.domain.Example;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/examples")
public class ExampleController {

	//@Secured(SecurityRule.IS_ANONYMOUS)
	@Get
	public List<Example> getAll() {
		return List.of(
				new Example(LocalDate.now(), "Petot", "Claude")
		);
	}
}
