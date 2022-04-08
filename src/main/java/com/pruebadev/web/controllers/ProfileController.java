package com.pruebadev.web.controllers;

import javax.validation.Valid;

import com.pruebadev.web.common.Constants;
import com.pruebadev.web.models.Profile;
import com.pruebadev.web.services.users.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
@RequestMapping({"/", "/profile"})
public class ProfileController implements WebMvcConfigurer{

    @Autowired
    UserService userService;

    /**
     * Visualizar formulario inicial de registro de perfil
     * @param model
     * @return
     */
    @GetMapping({"/", "/index"})
    public String indexProfile(Model model){
        model.addAttribute("profile", new Profile());
        return "profile_tpl";
    }

    /**
     * Crear perfil de usuario y redireccionar para visualizar
     * @param profile
     * @param result
     * @param model
     * @return
     */
    @PostMapping("/create")
    public String createProfile(@Valid Profile profile, Errors errors, Model model){
        if (errors.hasErrors()) {
            return "profile_tpl";
        }
        try{
            Profile modelProfile = userService.create(profile); 
            if(modelProfile != null && modelProfile.getId() != 0){
                model.addAttribute("model", modelProfile);
                model.addAttribute("newRecord", true);    
            }else{
                model.addAttribute("error", Constants.MSG_NOCREATE_USER);
                return "error_tpl";    
            }
        }catch(Exception e){
            model.addAttribute("error", e.getMessage());
            return "error_tpl";
        }
        return "view_profile_tpl";
    }

    /**
     * Consultar un perfil de usuario por {id} del mismo y visualizar
     * @param model
     * @param id
     * @return
     */
    @GetMapping("/view/{id}")
    public String viewProfile(Model model, @PathVariable(value="id") Integer id){
        try{
            model.addAttribute("model", userService.findOne(id));
        }catch(Exception e){
            model.addAttribute("error", e.getMessage());
            return "error_tpl";
        }
        
        return "view_profile_tpl";
    }

    /**
     * Consultar todos los usuarios y listar datos en tabla 
     * @param model
     * @return
     */
    @GetMapping("/list")
    public String listProfiles(Model model){

        try{
            model.addAttribute("list", userService.findAll());
        }catch(Exception e){
            model.addAttribute("error", e.getMessage());
            return "error_tpl";
        }
        
        return "list_profile_tpl";
    }
}
