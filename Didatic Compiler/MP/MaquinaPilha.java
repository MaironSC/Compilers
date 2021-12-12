
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

class MaquinaPilha{

  public static void main(String[] args) {
      Stack <Float> pilha = new Stack<Float>();

      try {
        FileReader arq = new FileReader(args[0]);
        Scanner ler = new Scanner(arq);

        while (ler.hasNextLine()) {
          String linha = ler.nextLine();
          String[] quebra = linha.split(" ");
          if(quebra[0].equals("PUSH")){
            pilha.push(Float.parseFloat(quebra[1]));
          }
          if(quebra[0].equals("SUM")){
            float y=pilha.pop();
            float x=pilha.pop();
            float resultado = x+y;
            pilha.push(resultado);
          }
          if(quebra[0].equals("SUB")){
            float y = pilha.pop();
            float x = pilha.pop();
            float resultado = x-y;
            pilha.push(resultado);
          }
          if(quebra[0].equals("MULT")){
            float y = pilha.pop();
            float x = pilha.pop();
            float resultado = x*y;
            pilha.push(resultado);
          }
          if(quebra[0].equals("DIV")){
            float y = pilha.pop();
            float x = pilha.pop();
            float resultado = x/y;
            pilha.push(resultado);
          }
        }
        arq.close();
        float resultadoF = pilha.pop();
        System.out.println(resultadoF);
      } catch (IOException e) {
          System.err.printf("Erro na abertura do arquivo: %s.\n",
            e.getMessage());
      }
  }
}
