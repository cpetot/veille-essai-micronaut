package first.micronaut.app.config;

import java.util.Objects;

import org.reactivestreams.Publisher;

import io.micronaut.http.HttpRequest;
import io.micronaut.security.authentication.AuthenticationProvider;
import io.micronaut.security.authentication.AuthenticationRequest;
import io.micronaut.security.authentication.AuthenticationResponse;
import jakarta.inject.Singleton;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

@Singleton
public class InMemoryAuthenticationProvider implements AuthenticationProvider {

	@Override
	public Publisher<AuthenticationResponse> authenticate(HttpRequest<?> httpRequest, AuthenticationRequest<?, ?> authenticationRequest) {
		return Flux.create(emitter -> {
			if (Objects.equals(authenticationRequest.getIdentity(), "claude") && Objects.equals(authenticationRequest.getSecret(), "claude")) {
				emitter.next(AuthenticationResponse.success((String) authenticationRequest.getIdentity()));
				emitter.complete();
			} else {
				emitter.error(AuthenticationResponse.exception());
			}
		}, FluxSink.OverflowStrategy.ERROR);
	}
}
