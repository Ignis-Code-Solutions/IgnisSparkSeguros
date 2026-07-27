package com.generation.ignisspark.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O atributo nome é obrigatório!")
	@Size(min = 5, max = 255, message = "O atributo nome deve ter no mínimo 5 e no máximo 255 caracteres")
	private String nome;
	
	@NotBlank(message = "O atributo CPF é obrigatório!")
	@Size(min = 11, max = 14, message = "O atributo CPF deve ter no mínimo 11 e no máximo 14 caracteres")
	private String cpf;
	
	@NotNull(message = "O atributo data de nascimento é obrigatório!")
	@JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate data_nascimento;
	
	@NotBlank(message = "O atributo telefone é obrigatório!")
	@Size(min = 11, max = 15, message = "O atributo telefone deve ter no mínimo 11 e no máximo 15 caracteres")
	private String telefone;
	
	@Email(message = "E-mail inválido!")
	@NotBlank(message = "O atributo E-mail é obrigatório!")
	private String email;
	
	@NotBlank(message = "O atributo endereço é obrigatório!")
	@Size(min = 10, max = 255, message = "O atributo endereço deve ter no mínimo 10 e no máximo 255 caracteres")
	private String endereco;

	@JoinColumn(name = "usuario_id")
	@JsonIgnoreProperties("cliente")
	private Usuario usuario;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties(value = "cliente", allowSetters = true)
	private List<Apolice> apolice;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties(value = "cliente", allowSetters = true)
	private List<Veiculo> veiculo;

	public Long getId() {
		return id;
	}

	public List<Apolice> getApolice() {
		return apolice;
	}

	public void setApolice(List<Apolice> apolice) {
		this.apolice = apolice;
	}

	public List<Veiculo> getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(List<Veiculo> veiculo) {
		this.veiculo = veiculo;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(LocalDate data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
}
