package br.ufma;

public class Parser {
    private Scanner scan;
    private Token currentToken;

    public Parser(byte[] input) {
        scan = new Scanner(input);
        currentToken = scan.nextToken();
    }

    private void nextToken() {
        currentToken = scan.nextToken();
    }

    private void matchToken(TokenType t) {
        if (currentToken.type == t) {
            nextToken();
        } else {
            throw new Error("syntax error");
        }
    }

    void digit() {
        if (currentToken.type == TokenType.NUMBER) {
            System.out.println("push " + currentToken.lexeme);
            matchToken(TokenType.NUMBER);
        } else {
            throw new Error("syntax error");
        }
    }

    void oper() {
        if (currentToken.type == TokenType.PLUS) {
            matchToken(TokenType.PLUS);
            digit();
            System.out.println("add");
            oper();
        } else if (currentToken.type == TokenType.MINUS) {
            matchToken(TokenType.MINUS);
            digit();
            System.out.println("sub");
            oper();
        }
    }

    void expr() {
        digit();
        oper();
    }

    public void parse() {
        expr();
    }
}