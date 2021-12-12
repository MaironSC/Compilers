import java.io.*;

enum TokenType{ NUM,SOMA, MULT,APar,FPar, EOF, SUB, DIV}

class Token{
  String lexema ="";
  TokenType token;

 Token (String l, TokenType t)
 	{ lexema=l;token = t;}	

}

class AnaliseLexica {

	BufferedReader arquivo;

	AnaliseLexica(String a) throws Exception
	{
		
	 	this.arquivo = new BufferedReader(new FileReader(a));
		
	}

	Token getNextToken() throws Exception
	{	
		Token token;
		int eof = -1;
		char currchar;
    String Palavra = "";
		int currchar1; 

			do{
				currchar1 =  arquivo.read();
        currchar = (char) currchar1;

			} while (currchar == '\n' || currchar == ' ' || currchar =='\t' || currchar == '\r');
			
			if(currchar1 != eof && currchar1 !=10)
			{
      //System.out.println(currchar);
				if (currchar >= '0' && currchar <= '9'){
          while(currchar >= '0' && currchar <= '9'){
            arquivo.mark(2); //Marca o arquivo antes de consumir o char
            Palavra += String.valueOf(currchar);
            currchar =  (char)arquivo.read();
          }
          arquivo.reset(); //Reseta pós consumir (senão iria pular um operador)
					return (new Token (Palavra, TokenType.NUM));
        }
				else{
					switch (currchar){
						case '(':
							return (new Token (currchar+"",TokenType.APar));
						case ')':
							return (new Token (currchar+"",TokenType.FPar));
						case '+':
							return (new Token (currchar+"",TokenType.SOMA));
						case '*':
							return (new Token (currchar+"",TokenType.MULT));
            case '-':
              return (new Token (currchar+"",TokenType.SUB));
            case '/':
              return (new Token (currchar+"", TokenType.DIV));
                                                        
						default: throw (new Exception("Caractere inválido: " + (currchar+"")));
					}
        }
			}
			arquivo.close();
		return (new Token(Palavra,TokenType.EOF));
	}
}
