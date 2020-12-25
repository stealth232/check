package by.blintsov.check.parser;

import by.blintsov.check.exception.ProductException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArgsParser {

    private static final String DELIMITER = "\\s";

    public List<String> parsParams(String[] args) throws ProductException {
        List<String> products;
        if (args[0].contains("txt") || args[0].contains("xml")) {
            String filePath = args[0];
            try (FileReader fileReader = new FileReader(filePath);
                 BufferedReader bufferedReader = new BufferedReader(fileReader)) {
                products = Arrays.asList(bufferedReader.readLine().split(DELIMITER));
            } catch (FileNotFoundException e) {
                throw new ProductException("File not found: " + filePath, e);
            } catch (IOException e) {
                throw new ProductException("File reading error: " + filePath, e);
            }
        } else {
            products = Arrays.stream(args).collect(Collectors.toList());
        }

        return products;
    }

    public List<String> parsParams(String filePath) throws ProductException {

        List<String> products;
        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            products = Arrays.asList(bufferedReader.readLine().split(DELIMITER));
        } catch (FileNotFoundException e) {
            throw new ProductException("File not found: " + filePath, e);
        } catch (IOException e) {
            throw new ProductException("File reading error: " + filePath, e);
        }
        return products;
    }

}
