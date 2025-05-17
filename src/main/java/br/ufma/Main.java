package br.ufma;

public class Main {
    public static void main(String[] args) {
        String input = "8+5-7+9";
        Scanner scanner = new Scanner(input.getBytes());
        Parser p = new Parser(input.getBytes());
        p.parse();
    }
}