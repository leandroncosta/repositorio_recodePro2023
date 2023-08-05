programa {
    	cadeia matriz[50][50]
    	cadeia matrizDestino[50][50]
		inteiro index , linha, coluna
		cadeia opcaoSimOuNao
		inteiro opcao
		inteiro opcaoCadastro
		inteiro opcaoConsulta
		
		
	funcao inicio() {
	    
	    matriz[0][0] = "Nome"
	    matriz[0][1]= "CPF"
	    matriz[0][2]= "E-mail"
	    matriz[0][3]= "Telefone"
	    
	     matrizDestino[0][0] = "País"
	    matrizDestino[0][1]= "Estado"
	    matrizDestino[0][2]= "Cidade"
	   
	    
	    index = 1
	
	 escreva("Seja bem vindo a nossa agência ViajeMais!\n 1 - Cadastre \n 2 - Consulta\n\n")
	 leia(opcao)
	 
	 escolha(opcao){
	     caso 1 :
           cadastre()
           pare
	   caso 2: 
    	   consultar()
    	   pare
    	
    	caso contrario :
    	    escreva("Opção inválida, tente novamente.\n\n")
    	    inicio()
    	    pare
    	
	 }
 }
     
    funcao obterDados (){
    	       	para(linha = index;linha <= 3; linha++){
    		    para(coluna = 0; coluna <= 3; coluna++){
    		        
    		        se(coluna == 0) {
    		        escreva("Informe seu nome: ")
    		        leia(matriz[linha][coluna])
    		        }
    		        
    		         se(coluna == 1) {
    		        escreva("Informe seu cpf: ")
    		        leia(matriz[linha][coluna])
    		        }
    		        
    		         se(coluna == 2) {
    		        escreva("Informe seu E-mail: ")
    		        leia(matriz[linha][coluna])
    		        }
    		        
    		         se(coluna == 3) {
    		        escreva("Informe seu telefone: ")
    		        leia(matriz[linha][coluna])
    		        escreva("\n\n")
    		        }
    		        
    		        se(coluna == 3) {
    		            retorne
    		        }
    		       
    		    }
    		    
    		}
    	   }
    	   
    funcao obterDadosDestino (){
        para(linha = index;linha <= 3; linha++){
    		    para(coluna = 0; coluna <= 3; coluna++){
    		        
    		        se(coluna == 0) {
    		        escreva("Pais: ")
    		        leia(matrizDestino[linha][coluna])
    		        }
    		        
    		         se(coluna == 1) {
    		        escreva("Estado: ")
    		        leia(matrizDestino[linha][coluna])
    		        }
    		        
    		         se(coluna == 2) {
    		        escreva("Cidade: ")
    		        leia(matrizDestino[linha][coluna]) 
    		         escreva("\n\n")
    		        }
    		        
    		       
    		        se(coluna == 2){
    		            retorne
    		        }
    		       
    		    }
    		 
    		}
    }
    
    funcao cadastreMais (){
           escreva("Deseja cadastrar mais ? (y/n) ")
    	   leia(opcaoSimOuNao)
    	        se(opcaoSimOuNao == "y"){
    	            index = index + 1
    	            cadastre()
    	        }senao se (opcaoSimOuNao == "n"){
    	            consultar()
    	        } senao {
    	            escreva("opcão inválida, tente novamente")
    	            cadastreMais()
    	        }
    }
    
    funcao cadastre (){
      escreva("\nQual tipo de cadastro?\n 1 - Cliente \n 2 - Destino\n\n")
      leia(opcaoCadastro)
      escolha(opcaoCadastro){
          caso 1 :
           cadastreCliente()
          pare
          caso 2 :
          cadastreDestino()
          pare
    	caso contrario :
    	    escreva("Opção inválida, tente novamente.\n\n")
    	    cadastre()
    	    pare
      }
    }
    
    funcao cadastreCliente (){
         escreva("\nSeja bem vindo a nossa agência ViajeMais!\npara começarmos, precisaremos de algumas informações\n\n")
         obterDados()
         cadastreMais()
    }
    
    funcao cadastreDestino (){
        escreva("\nSeja bem vindo a nossa agência ViajeMais!\npara começarmos, precisaremos de algumas informações\n\n")
         obterDadosDestino()
         cadastreMais()
    }
    
    funcao consultar (){
         escreva("\nConsulte os dados \n 1 - Cliente \n 2 - Destino\n\n")
      leia(opcaoConsulta)
      escolha(opcaoConsulta){
          caso 1 :
           consultarCliente()
          pare
          caso 2 :
          consultarDestino()
          pare
          
    	caso contrario :
    	    escreva("Opção inválida, tente novamente.\n\n")
    	    consultar()
    	    pare
      }
      
       escreva("Consultar novamente? (y/n) ")
        leia(opcaoSimOuNao)
        
            se(opcaoSimOuNao == "y"){
    	            consultar()
    	        }
    }
    
    funcao consultarCliente (){
           escreva("\n")
			para(linha = 0; linha <= 3; linha++){
			     
    		       para(coluna = 0; coluna <= 3; coluna++){
        		        se (coluna == 3 ){
        		            escreva(matriz[linha][coluna], "\n")
        		          }
        		          
        		        se (coluna <= 2 ){
        		            escreva(" ", matriz[linha][coluna], "          ")
        		        }
		 
		           }
	        }
    }
    
    funcao consultarDestino(){
           escreva("\n")
			para(linha = 0; linha <= 3; linha++){
			     
    		       para(coluna = 0; coluna <= 3; coluna++){
        		        se (coluna == 3 ){
        		            escreva(matrizDestino[linha][coluna], "\n")
        		          }
        		          
        		        se (coluna <= 2 ){
        		            escreva(" ", matrizDestino[linha][coluna], "          ")
        		        }
		 
		           }
	        }
    }
}


