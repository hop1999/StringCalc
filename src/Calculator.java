class Calculator {

    public String calculate(String input) {
        String[] parts = input.split(" ");
        if (parts.length != 3) {
            throw new IllegalArgumentException("Выражение должно состоять из трех частей");
        }

        String left = parts[0];
        String right = parts[2];
        String operator = parts[1];

        if (operator.equals("*") || operator.equals("/")) {
            if (!left.matches("\"[^\"]+\"") || (Integer.parseInt(right) < 1 || Integer.parseInt(right) > 10)) {
                throw new IllegalArgumentException("Неверный формат операндов для оператора " + operator);
            }
            left = left.substring(1, left.length() - 1);
        } else {
            if (!left.startsWith("\"") || !left.endsWith("\"") || !right.startsWith("\"") || !right.endsWith("\"")) {
                throw new IllegalArgumentException("Строки должны быть заключены в двойные кавычки");
            }
            left = left.substring(1, left.length() - 1);
            right = right.substring(1, right.length() - 1);
        }

        String result;
        switch (operator) {
            case "+":
                result = left + right;
                break;
            case "-":
                result = left.replaceFirst(right, "");
                break;
            case "*":
                int repeat = Integer.parseInt(right);
                result = repeatString(left, repeat);
                break;
            case "/":
                int divisor = Integer.parseInt(right);
                result = left.substring(0, left.length() / divisor);
                break;
            default:
                throw new IllegalArgumentException("Неподдерживаемая операция: " + operator);
        }

        return result;
    }

    private String repeatString(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(s);
        }
        return sb.toString();
    }
}