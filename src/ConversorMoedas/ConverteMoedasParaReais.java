package ConversorMoedas;

import javax.swing.*;

public class ConverteMoedasParaReais {

    public void converterDolaresParaReais(double valorRecebido){
        double moedaDolar = valorRecebido * CurrencyConverter.usdToBrl;
        moedaDolar = (double) Math.round(moedaDolar * 100d) / 100;
        JOptionPane.showMessageDialog(null, "Você tem $ " + moedaDolar + " Reais");
    }

    public void converterEurosParaReais(double valorRecebido){
        double moedaEuro = valorRecebido * CurrencyConverter.eurToBrl;
        moedaEuro = (double) Math.round(moedaEuro * 100d) / 100;
        JOptionPane.showMessageDialog(null, "Você tem $ " + moedaEuro + " Reais");
    }

    public void converterLibrasParaReais(double valorRecebido){
        double moedaLibra = valorRecebido * CurrencyConverter.gbpToBrl;
        moedaLibra = (double) Math.round(moedaLibra * 100d) / 100;
        JOptionPane.showMessageDialog(null, "Você tem $ " + moedaLibra + " Reais");
    }
    public void converterPesosArgentinosParaReais(double valorRecebido){
        double moedaPesoArgentino = valorRecebido * CurrencyConverter.arsToBrl;
        moedaPesoArgentino = (double) Math.round(moedaPesoArgentino * 100d) / 100;
        JOptionPane.showMessageDialog(null, "Você tem $" + moedaPesoArgentino + " Reais");
    }

    public void converterPesosChilenosParaReais(double valorRecebido){
        double moedaPesoChileno = valorRecebido * CurrencyConverter.brlToClp;
        moedaPesoChileno = (double) Math.round(moedaPesoChileno * 100d) / 100;
        JOptionPane.showMessageDialog(null, "Você tem $" + moedaPesoChileno + " Reais");
    }

}
