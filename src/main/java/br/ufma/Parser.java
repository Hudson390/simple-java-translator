package br.ufma;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {

    private Scanner scan;
    private Token currentToken;
    private List<String> outputCommands = new ArrayList<>();

    public Parser(byte[] input) {
        scan = new Scanner(input);
        currentToken = scan.nextToken();
    }

    private void nextToken() {
        currentToken = scan.nextToken();
    }

    private void match(TokenType t) {
        if (currentToken.type == t) {
            nextToken();
        } else {
            throw new Error("syntax error");
        }
    }

    void emit(String command) {
        outputCommands.add(command);
    }

    void number() {
        emit("push " + currentToken.lexeme);
        match(TokenType.NUMBER);
    }

    void expr() {
        term();
        oper();
    }

    void oper() {
        if (currentToken.type == TokenType.PLUS) {
            match(TokenType.PLUS);
            term();
            emit("add");
            oper();
        } else if (currentToken.type == TokenType.MINUS) {
            match(TokenType.MINUS);
            term();
            emit("sub");
            oper();
        }
    }

    void term() {
        if (currentToken.type == TokenType.NUMBER)
            number();
        else if (currentToken.type == TokenType.IDENT) {
            emit("push " + currentToken.lexeme);
            match(TokenType.IDENT);
        } else {
            throw new Error("syntax error");
        }
    }

    void letStatement() {
        match(TokenType.LET);
        String id = currentToken.lexeme;
        match(TokenType.IDENT);
        match(TokenType.EQ);
        expr();
        emit("pop " + id);
        match(TokenType.SEMICOLON);
    }

    void printStatement() {
        match(TokenType.PRINT);
        expr();
        emit("print");
        match(TokenType.SEMICOLON);
    }

    void statement() {
        if (currentToken.type == TokenType.PRINT) {
            printStatement();
        } else if (currentToken.type == TokenType.LET) {
            letStatement();
        } else {
            throw new Error("syntax error");
        }
    }

    void statements() {
        while (currentToken.type != TokenType.EOF) {
            statement();
        }
    }

    public void parse() {
        statements();
    }

    public String getOutput() {
        return outputCommands.stream().collect(Collectors.joining(System.getProperty("line.separator")));
    }

    public static void main(String[] args) {
        String input = """
                let a = 42 + 5 - 8;
                let b = 56 + 8;
                print a + b + 6;
                    """;
        Parser p = new Parser(input.getBytes());
        p.parse();
        System.out.println("--- Parser Output ---");
        System.out.println(p.getOutput());
    }
}