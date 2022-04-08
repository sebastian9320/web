package com.pruebadev.web.services.users;

import com.pruebadev.web.helpers.WebClientHelper;
import com.pruebadev.web.models.Profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService implements IUserService{
    
    @Autowired
    WebClientHelper webClientHelper;

	@Override
	public Profile[] findAll() {
		Mono<Profile[]> fluxProfile = webClientHelper.getWebClient().get()
            .uri("/users/")
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToMono(Profile[].class);

        return fluxProfile.block();
	}

	@Override
	public Profile findOne(Integer id) {
		Flux<Profile> fluxProfile = webClientHelper.getWebClient().get()
            .uri("/users/" + id)
            .retrieve()
            .bodyToFlux(Profile.class);
        return fluxProfile.share().blockFirst();
	}

	@Override
	public Profile create(Profile profile) {
		Mono<Profile> fluxProfile = webClientHelper.getWebClient().post()
                .uri("/users")
                .body(Mono.just(profile), Profile.class)
                .retrieve()
                .bodyToMono(Profile.class);
        return fluxProfile.share().block();
	}

}
