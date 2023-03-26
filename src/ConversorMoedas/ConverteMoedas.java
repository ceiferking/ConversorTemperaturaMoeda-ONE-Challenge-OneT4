package ConversorMoedas;

import java.text.DecimalFormat;

import javax.swing.*;

public class ConverteMoedas {
    DecimalFormat df = new DecimalFormat("#.00000");
    
    public void converterReaisParaDolares(double valorRecebido){
        double moedaDolar = valorRecebido / CurrencyConverter.brlToUsd;
        moedaDolar = (double) Math.round(moedaDolar * 100d) / 100;
        df.format(moedaDolar);
        JOptionPane.showMessageDialog(null, "Você tem $ " + moedaDolar + " Dólares");
    }

    public void converterReaisParaEuros(double valorRecebido){
        double moedaEuro = valorRecebido / CurrencyConverter.brlToEur;
        moedaEuro = (double) Math.round(moedaEuro * 100d) / 100;
        df.format(moedaEuro);
        JOptionPane.showMessageDialog(null, "Você tem $ " + moedaEuro + " Euros");
    }

    public void converterReaisParaLibras(double valorRecebido){
        double moedaLibra = valorRecebido / CurrencyConverter.brlToGbp;
        moedaLibra = (double) Math.round(moedaLibra * 100d) / 100;
        JOptionPane.showMessageDialog(null, "Você tem $ " + moedaLibra + " Libras Esterlinas");
    }

    public void converterReaisParaPesosArgentinos(double valorRecebido){
        double moedaPesoArgentino = valorRecebido / CurrencyConverter.brlToArs;
        moedaPesoArgentino = (double) Math.round(moedaPesoArgentino * 100d) / 100;
        JOptionPane.showMessageDialog(null, "Você tem $ " + moedaPesoArgentino + "Pesos Argentinos");
    }

    public void converterReaisParaPesosChilenos(double valorRecebido){
        double moedaPesoChileno = valorRecebido / CurrencyConverter.brlToClp;
        moedaPesoChileno = (double) Math.round(moedaPesoChileno * 100d) / 100;
        df.format(moedaPesoChileno);
        JOptionPane.showMessageDialog(null, "Você tem $ " + moedaPesoChileno + " Pesos Chilenos");
    }

}
