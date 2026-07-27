package com.generation.ignisspark.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

	@Entity
	@Table(name = "tb_veiculos")
	public class Veiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "O tipo do veículo é obrigatório!")
	@Size(max = 30, message = "O tipo deve possuir no máximo 30 caracteres!")
	@Column(length = 30, nullable = false)
	private String tipo;

	@NotBlank(message = "A marca é obrigatória!")
    @Size(max = 50, message = "A marca deve possuir no máximo 50 caracteres!")
    @Column(length = 50, nullable = false)
    private String marca;

	@NotBlank(message = "O modelo é obrigatório!")
    @Size(max = 50, message = "O modelo deve possuir no máximo 50 caracteres!")
    @Column(length = 50, nullable = false)
    private String modelo;

	@NotNull(message = "O ano de fabricação é obrigatório!")
    @Min(value = 1900, message = "O ano de fabricação é inválido!")
    @Max(value = 2100, message = "O ano de fabricação é inválido!")
    @Column(name = "ano_fabricacao", nullable = false)
    private Integer anoFabricacao;

	@Size(max = 10, message = "A placa deve possuir no máximo 07 caracteres!")
    @Column(length = 07, unique = true)
    private String placa;

	@NotNull(message = "O valor de tabela é obrigatório!")
	private BigDecimal valorTabela;

    @ManyToOne
    @JsonIgnoreProperties("veiculos")
    private Cliente cliente;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Integer getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(Integer anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public BigDecimal getValorTabela() {
		return valorTabela;
	}

	public void setValorTabela(BigDecimal valorTabela) {
		this.valorTabela = valorTabela;
	}

    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

	
}