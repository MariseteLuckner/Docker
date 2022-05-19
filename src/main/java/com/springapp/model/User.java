package com.springapp.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "USERS", uniqueConstraints = {
		@UniqueConstraint(columnNames = "email") })
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotBlank(message = "O nome é obrigatório")
	@Pattern(regexp = "^[A-Z]+(.)*")
	private String username;

	@ApiModelProperty(example = "email@dominio.com")
	@NotBlank(message = "O email é obrigatório")
	@Email(message = "Campo inválido.")
	@Column(unique = true)
	private String email;

	@NotBlank(message = "A senha é obrigatório")
	@Size(min = 8, message = "Campo inválido")
	private String password;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	@Column(updatable = false)
    private LocalDateTime createdAt;
}
