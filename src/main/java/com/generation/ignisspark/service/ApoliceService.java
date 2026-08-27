package com.generation.ignisspark.service;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.generation.ignisspark.model.Apolice;
import com.generation.ignisspark.model.Veiculo;

@Service
public class ApoliceService {

    private static final int IDADE_MAXIMA_COM_DESCONTO = 10;
    private static final BigDecimal FATOR_DESCONTO = new BigDecimal("0.80"); // 20% de desconto (paga 80% do valor)

    public BigDecimal calcularValorFinal(Apolice apolice) {
        if (apolice == null || apolice.getValorSeguro() == null || apolice.getVeiculo() == null) {
            return BigDecimal.ZERO;
        }

        BigDecimal valorSeguro = apolice.getValorSeguro();
        Veiculo veiculo = apolice.getVeiculo();

        // Se tiver até 10 anos de uso, aplica o desconto
        if (veiculoTemAte10Anos(veiculo)) {
            return valorSeguro.multiply(FATOR_DESCONTO);
        }

        return valorSeguro;
    }

    private boolean veiculoTemAte10Anos(Veiculo veiculo) {
        if (veiculo.getAnoFabricacao() == null) {
            return false;
        }

        int anoAtual = LocalDate.now().getYear();
        int idadeVeiculo = anoAtual - veiculo.getAnoFabricacao();

        // Operador <= para garantir desconto até 10 anos de uso
        return idadeVeiculo <= IDADE_MAXIMA_COM_DESCONTO;
    }
}