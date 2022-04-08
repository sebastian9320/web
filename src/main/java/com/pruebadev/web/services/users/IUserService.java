package com.pruebadev.web.services.users;

import com.pruebadev.web.models.Profile;

public interface IUserService {
    //Flux<Profile>
    //Mono<Profile> 
    public Profile[] findAll();
    
    public Profile findOne(Integer id);

    public Profile create(Profile profile);

}
