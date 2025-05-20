<h1 align="center">💻 Compilador/Interpretador Simplificado em Java</h1>

<p align="center">
  Projeto acadêmico de um compilador e interpretador para uma linguagem fictícia simplificada, desenvolvido em Java.
</p>

<hr>

<h2>📖 Sobre o Projeto</h2>
<p>
  Este projeto implementa um compilador e interpretador simplificado, com o objetivo de praticar os fundamentos da construção de linguagens de programação. A linguagem criada permite declarar variáveis, realizar operações aritméticas e imprimir valores.
</p>

<h2>🧠 Funcionalidades</h2>
<ul>
  <li><strong>Análise Léxica:</strong> Identifica tokens como palavras-chave, identificadores, números e operadores.</li>
  <li><strong>Análise Sintática:</strong> Verifica a estrutura gramatical do código e gera uma lista de comandos intermediários.</li>
  <li><strong>Variáveis:</strong> Suporte à declaração com <code>let</code> e atribuição.</li>
  <li><strong>Operações Aritméticas:</strong> Suporte a adição (<code>+</code>) e subtração (<code>-</code>).</li>
  <li><strong>Impressão:</strong> Comando <code>print</code> para exibir resultados no console.</li>
  <li><strong>Interpretador:</strong> Executa os comandos intermediários simulando a execução do programa.</li>
</ul>

<h2>📁 Estrutura do Projeto</h2>
<ul>
    <li><code>src/</code> - Contém todos os arquivos fonte do compilador</li>
  <li><code>Main.java</code> - Ponto de entrada da aplicação</li>
  <li><code>Parser.java</code> - Executa a análise sintática e gera os comandos intermediários</li>
  <li><code>Interpreter.java</code> - Responsável por interpretar e executar os comandos</li>
</ul>

<h2>🚀 Como Executar</h2>

<ol>
  <li>Clone o repositório:</li>
  <pre><code>git clone https://github.com/seu-usuario/compilador-simplificado-java.git</code></pre>

  <li>Compile o projeto (use o terminal na pasta <code>src</code>):</li>
  <pre><code>javac *.java</code></pre>

  <li>Execute a aplicação:</li>
  <pre><code>java Main</code></pre>
</ol>

<h2>📝 Exemplo de Código</h2>

<pre><code>let x = 10;
let y = 5;
let z = x + y;
print(z);</code></pre>

<h2>📌 Observações</h2>
<ul>
  <li>Este projeto tem fins didáticos e não possui todas as regras de uma linguagem real.</li>
  <li>Erros são tratados de forma básica.</li>
</ul>

<h2>👨‍🎓 Autor</h2>
<p>
  Desenvolvido por <strong>Hudson</strong> para fins acadêmicos.<br>
  Curso: Engenharia da Computação<br>
  Disciplina: Compiladores
</p>


