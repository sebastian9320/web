package com.pruebadev.web.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Profile {
    

	private Integer id;

	@NotEmpty(message="Este campo es requerido.")
  	@Size(min = 3,max = 25, message = "Nombre debe tener entre 3 y 40 caracteres")
    private String nombre;

	@NotEmpty(message="Este campo es requerido.")
  	@Size(min = 3,max = 40, message = "Apellidos debe tener entre 3 y 40 caracteres")
	private String apellidos;  

	@NotEmpty(message="Este campo es requerido.")
  	@Email(regexp = "^(.+)@(.+)$", message ="Correo electrónico no válido")
    private String email;  

	@Size(min = 10,max = 10, message="Número de teléfono debe tener 10 dígitos")
    private String numeroTelefono;
    
	private String ciudad;
    
	private String pais;

	public Profile(){}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumeroTelefono() {
		return numeroTelefono;
	}

	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

    
    
}
