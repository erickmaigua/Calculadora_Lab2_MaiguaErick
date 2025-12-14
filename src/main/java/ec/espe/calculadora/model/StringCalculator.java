package ec.espe.calculadora.model;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    public int add(String numbers) {
        if (numbers == null || numbers.isEmpty()) return 0;

        String delimiterRegex = "[,\n]";
        String data = numbers;

        if (numbers.startsWith("//")) {
            int idx = numbers.indexOf('\n');
            String customDelimiter = numbers.substring(2, idx);
            delimiterRegex = java.util.regex.Pattern.quote(customDelimiter);
            data = numbers.substring(idx + 1);
        }

        String[] parts = data.split(delimiterRegex);
        int sum = 0;
        List<Integer> negatives = new ArrayList<>();

        for (String p : parts) {
            if (p.trim().isEmpty()) continue;
            int n = Integer.parseInt(p.trim());
            if (n < 0) negatives.add(n);
            else sum += n;
        }

        if (!negatives.isEmpty())
            throw new IllegalArgumentException("Negativos no permitidos: " + negatives);

        return sum;
    }
}
