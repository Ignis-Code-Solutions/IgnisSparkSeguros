package com.generation.ignisspark.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_apolice")
public class Apolice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "O atributo número da apólice é obrigatório")
	@Size(max = 30, message = "O número da apólice deve ter no máximo 30 caracteres")
	@Column(length = 30, unique = true)
	private String numeroApolice;

	@NotNull(message = "O atributo data de início é obrigatório")
	private LocalDate dataInicio;

	@NotNull(message = "O atributo data de fim é obrigatório")
	private LocalDate dataFim;

	@NotBlank(message = "O atributo tipo de cobertura é obrigatório")
	private String tipoCobertura; // Básica, Intermediária, Completa

	@NotNull(message = "O atributo valor do seguro é obrigatório")
	private BigDecimal valorSeguro;

	@NotBlank(message = "O atributo status é obrigatório")
	private String status; // Ativo, Cancelado, Vencido

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "veiculo_id", unique = true)
	private Veiculo veiculo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumeroApolice() {
		return numeroApolice;
	}

	public void setNumeroApolice(String numeroApolice) {
		this.numeroApolice = numeroApolice;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataFim() {
		return dataFim;
	}

	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}

	public String getTipoCobertura() {
		return tipoCobertura;
	}

	public void setTipoCobertura(String tipoCobertura) {
		this.tipoCobertura = tipoCobertura;
	}

	public BigDecimal getValorSeguro() {
		return valorSeguro;
	}

	public void setValorSeguro(BigDecimal valorSeguro) {
		this.valorSeguro = valorSeguro;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

}
