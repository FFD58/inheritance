package ru.fafurin.lesson2.task6;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CurrencyLoader {
    private String url;

    private final String CBR_URI = "https://www.cbr.ru/scripts/XML_daily.asp?date_req=%s";

    private URI uri;

    private String date;
    private Currency currency;

    public CurrencyLoader(String date, Currency currency) {
        this.url = String.format(CBR_URI, date);
        try {
            this.uri = new URI(this.url);
        } catch (URISyntaxException e) {
            System.out.println(e.getMessage());
        }
        this.date = date;
        this.currency = currency;
    }

    public CurrencyLoader(Date date, Currency currency) {
        String dateStr = new SimpleDateFormat("dd/MM/yyyy").format(date);
        this.url = String.format(CBR_URI, dateStr);
        this.date = dateStr;
        this.currency = currency;
    }

    public CurrencyLoader(String day, String month, String year, Currency currency) {
        this.url = String.format("https://www.cbr.ru/scripts/XML_daily.asp?date_req=%s/%s/%s", day, month, year);
        this.date = day + "." + month + "." + year;
        this.currency = currency;
    }

    public void writeCurrencyQuotesByDateToFile() {
        String source = downloadWebPage();
        String filename = this.currency.getTitle() + this.date;
        filename = filename.replace(" ", "").replace("/", "-");
        if (source.contains(this.currency.getId())) {
            String result = this.formatString(source, this.currency.getId());
            if (result.contains("Currency quote not found!")) {
                result = String.format("%s: no data available", this.date);
                this.setStringToFile(filename, result);
                System.out.printf("%s quote for %s not found!\n", this.currency.getTitle(), this.date);
            } else {
                this.setStringToFile(filename, result);
                System.out.printf("%s quote for %s successfully saved to file %s\n", this.currency.getTitle(), this.date, filename);
            }
        }
    }

    private String formatString(String source, String currentValueId) {
        if (source.contains(currentValueId)) {
            String date = source.substring(source.indexOf("Date=") + 6, source.indexOf("Date=") + 16);
            int startValueIndex = source.indexOf("<Value>", source.indexOf(currentValueId)) + "<Value>".length();
            int endValueIndex = source.indexOf("/Value", startValueIndex) - 1;
            String value = source.substring(startValueIndex, endValueIndex);
            return date + ": " + value;
        } else return "Currency quote not found!";
    }

    private String downloadWebPage() {
        StringBuilder res = new StringBuilder();
        try {
            String line;
            URLConnection urlConnection = this.uri.toURL().openConnection();
            InputStream is = urlConnection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                res.append(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return res.toString();
    }

    private void setStringToFile(String filename, String source) {
        try {
            FileWriter writer = new FileWriter(filename, true);
            BufferedWriter bufferWriter = new BufferedWriter(writer);
            bufferWriter.write(source);
            bufferWriter.write("\n");
            bufferWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
