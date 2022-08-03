package first.micronaut.app.infrastructure.web;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;

@Controller
public class HelloController {

	@Secured(SecurityRule.IS_ANONYMOUS)
	@Get(uris = {"/{name}", "/person/{name}"}, produces = "text/plain")
	public String hello(String name) {
		return "Hello, " + name;
	}

}
