package MyDownloadFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.StringTokenizer;

// Пример из Unit 10 [Yakov Fain Intro to Java]
public class StockQuote {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.out.println("Sample Usage: java StockQuote IBM");
            System.exit(0);
        }

        // Чтение параметра командной строки
        printStockQuote(args[0]);
    }

    // Принимает в качестве аргумента листинг на бирже
    static void printStockQuote(String tradedName) throws IOException {
        String urlString = "https://query1.finance.yahoo.com/v7/finance/download/" +
                tradedName +
                "?period1=1623110400" +
                "&period2=1623196800" +
                "&interval=1d" +
                "&events=history&includeAdjustedClose=true";

        URL url = new URL(urlString);
        InputStream inputStream = url.openStream();

        // Создание временного файла
        Path tempFile = Files.createTempFile("temp-", ".tmp");
        Files.copy(inputStream, tempFile, StandardCopyOption.REPLACE_EXISTING);

        // Перенос временного файла в папку назначения
        Path target = Paths.get("D:/MyDownloads/" + tradedName + ".csv");
        Files.move(tempFile, target, StandardCopyOption.REPLACE_EXISTING);

        // Чтение всех строк из файла в список
        List<String> lines = Files.readAllLines(target, StandardCharsets.UTF_8);

        // 0-я строка является заголовком
        String csvString = lines.get(1);

        // parse the scv string
        StringTokenizer tokenizer = new StringTokenizer(csvString, ",");
        String tradeDate = tokenizer.nextToken();
        String tradeOpen = tokenizer.nextToken();
        String tradeHigh = tokenizer.nextToken();
        String tradeLow = tokenizer.nextToken();
        String tradeClose = tokenizer.nextToken();
        String tradeAdjClose = tokenizer.nextToken();
        String tradeVolume = tokenizer.nextToken();

        String finalString = "Symbol: " + tradedName +
                " Date: " + tradeDate +
                " Open: " + tradeOpen +
                " High: " + tradeHigh +
                " Low: " + tradeLow +
                " Close: " + tradeClose +
                " Adj Close: " + tradeAdjClose +
                " Volume: " + tradeVolume;

        System.out.println(finalString);
    }
}
