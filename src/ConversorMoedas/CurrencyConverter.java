package ConversorMoedas;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CurrencyConverter {
    private static final String API_KEY = "2f7ce7c34e9440b7accb5caac6e4d784";
    private static final String API_URL = "https://openexchangerates.org/api/latest.json?app_id=" + API_KEY;

    public static double usdToBrl;
    public static double eurToBrl;
    public static double gbpToBrl;
    public static double clpToBrl;
    public static double arsToBrl;

    public static double brlToUsd;
    public static double brlToEur;
    public static double brlToGbp;
    public static double brlToClp;
    public static double brlToArs;

    public static void updateExchangeRates() throws Exception {
        String urlStr = API_URL + "&symbols=USD,EUR,GBP,CLP,ARS,BRL";
        URL url = new URL(urlStr);

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");

        BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

        String output;
        StringBuilder response = new StringBuilder();
        while ((output = br.readLine()) != null) {
            response.append(output);
        }

        conn.disconnect();

        // Parse response and update exchange rates
        String[] currencies = response.toString().split("\"rates\":\\{")[1].split("\\}")[0].split(",");
        for (String currency : currencies) {
            String[] parts = currency.split(":");
            String code = parts[0].replaceAll("\"", "");
            double rate = Double.parseDouble(parts[1]);
            switch (code) {
                case "USD":
                    usdToBrl = rate;
                    brlToUsd = 1.0 / rate;
                    break;
                case "EUR":
                    eurToBrl = rate;
                    brlToEur = 1.0 / rate;
                    break;
                case "GBP":
                    gbpToBrl = rate;
                    brlToGbp = 1.0 / rate;
                    break;
                case "CLP":
                    clpToBrl = rate;
                    brlToClp = 1.0 / rate;
                    break;
                case "ARS":
                    arsToBrl = rate;
                    brlToArs = 1.0 / rate;
                    break;
            }
        }
    }

    public static double convert(double amount, String fromCurrency, String toCurrency) {
        double fromRate = 0.0;
        double toRate = 0.0;

        switch (fromCurrency) {
            case "USD":
                fromRate = usdToBrl;
                break;
            case "EUR":
                fromRate = eurToBrl;
                break;
            case "GBP":
                fromRate = gbpToBrl;
                break;
            case "CLP":
                fromRate = clpToBrl;
                break;
            case "ARS":
                fromRate = arsToBrl;
                break;
            case "BRL":
                fromRate = 1.0;
                break;
        }

        switch (toCurrency) {
            case "USD":
                toRate = brlToUsd;
                break;
            case "EUR":
                toRate = brlToEur;
                break;
            case "GBP":
                toRate = brlToGbp;
                break;
            case "CLP":
                toRate = brlToClp;
                break;
            case "ARS":
                toRate = brlToArs;
                break;
            case "BRL":
                toRate = 1.0;
                break;
        }

        return amount * toRate / fromRate;
    }
}