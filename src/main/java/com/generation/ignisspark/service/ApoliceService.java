package com.generation.ignisspark.service;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.generation.ignisspark.model.Apolice;
import com.generation.ignisspark.model.Veiculo;

import jakarta.validation.Valid;

@Service
public class ApoliceService {

	private static final int IDADE_MAXIMA_SEM_DESCONTO = 10; // anos
	private static final BigDecimal PERCENTUAL_DESCONTO = new BigDecimal("0.20"); // 20%

	public BigDecimal calcularValorFinal1(Apolice apolice) {

		BigDecimal valorSeguro = apolice.getValorSeguro();
		Veiculo veiculo = apolice.getVeiculo();

		if (valorSeguro == null || veiculo == null)
			return valorSeguro;

		if (veiculoTemMaisDe10Anos(veiculo)) {
			BigDecimal desconto = valorSeguro.multiply(PERCENTUAL_DESCONTO);
			return valorSeguro.subtract(desconto);
		}

		return valorSeguro;
	}

	private boolean veiculoTemMaisDe10Anos(Veiculo veiculo) {
		int anoAtual = LocalDate.now().getYear();
		int idadeVeiculo = anoAtual - veiculo.getAnoFabricacao();
		return idadeVeiculo > IDADE_MAXIMA_SEM_DESCONTO;
	}

	public BigDecimal calcularValorFinal(@Valid Apolice apolice) {
		// TODO Auto-generated method stub
		return null;
	}

}