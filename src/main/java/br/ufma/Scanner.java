package br.ufma;

public class Scanner {
    private byte[] input;
    private int current;

    public Scanner(byte[] input) {
        this.input = input;
        this.current = 0;
    }

    private char peek() {
        if (current < input.length)
            return (char) input[current];
        return '\0';
    }

    private void advance() {
        char ch = peek();
        if (ch != '\0') {
            current++;
        }
    }

    private boolean isAlpha(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == '_';
    }

    private boolean isAlphaNumeric(char c) {
        return isAlpha(c) || Character.isDigit(c);
    }

    private Token identifier() {
        int start = current;
        while (isAlphaNumeric(peek()))
            advance();
        String id = new String(input, start, current - start);
        return new Token(TokenType.IDENT, id);
    }

    private void skipWhitespace() {
        char ch = peek();
        while (ch == ' ' || ch == '\r' || ch == '\t' || ch == '\n') {
            advance();
            ch = peek();
        }
    }

    private Token number() {
        int start = current;
        while (Character.isDigit(peek())) {
            advance();
        }
        String n = new String(input, start, current - start);
        return new Token(TokenType.NUMBER, n);
    }

    private char peekNext() {
        if (current + 1 < input.length)
            return (char) input[current + 1];
        return '\0';
    }

    private char peekNextNext() {
        if (current + 2 < input.length)
            return (char) input[current + 2];
        return '\0';
    }

    private char peekNextNextNext() {
        if (current + 3 < input.length)
            return (char) input[current + 3];
        return '\0';
    }

    private char peekNextNextNextNext() {
        if (current + 4 < input.length)
            return (char) input[current + 4];
        return '\0';
    }

    public Token nextToken() {
        skipWhitespace();
        char ch = peek();
        if (isAlpha(ch)) {
            if (ch == 'l' && peekNext() == 'e' && peekNextNext() == 't') {
                advance();
                advance();
                advance();
                return new Token(TokenType.LET, "let");
            }
            if (ch == 'p' && peekNext() == 'r' && peekNextNext() == 'i' && peekNextNextNext() == 'n'
                    && peekNextNextNextNext() == 't') {
                advance();
                advance();
                advance();
                advance();
                advance();
                return new Token(TokenType.PRINT, "print"); // Adicionei o reconhecimento de "print"
            }
            return identifier();
        } else if (ch == '0') {
            advance();
            return new Token(TokenType.NUMBER, Character.toString(ch));
        } else if (Character.isDigit(ch)) {
            return number();
        }
        switch (ch) {
            case '+':
                advance();
                return new Token(TokenType.PLUS, "+");
            case '-':
                advance();
                return new Token(TokenType.MINUS, "-");
            case '=':
                advance();
                return new Token(TokenType.EQ, "=");
            case ';':
                advance();
                return new Token(TokenType.SEMICOLON, ";");
            case '\0':
                return new Token(TokenType.EOF, "EOF");
            default:
                throw new Error("lexical error at " + ch);
        }
    }

    public static void main(String[] args) {
        String input = "let a = 42 + 5; print a;";
        Scanner scan = new Scanner(input.getBytes());
        for (Token tk = scan.nextToken(); tk.type != TokenType.EOF; tk = scan.nextToken()) {
            System.out.println(tk);
        }
    }
}