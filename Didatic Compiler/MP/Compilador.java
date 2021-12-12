import java.io.FileWriter;
class Compilador{

	public static void main(String[]args)
	{	
		ArvoreSintatica arv=null;
	
		try{

			AnaliseLexica al = new AnaliseLexica(args[0]);
			Parser as = new Parser(al);
		
			arv = as.parseProg();
			CodeGen backend = new CodeGen();
			String codigo = backend.geraCodigo(arv);

      FileWriter escritor = new FileWriter("arquivoDeEntrada");
      escritor.write(codigo);
      escritor.close();
			System.out.println(codigo);

		}catch(Exception e)
		{			
			System.out.println("Erro de compilação:\n" + e);
		}



	}
}
