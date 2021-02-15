import java.util.Scanner;
import java.util.Random;

public class Main {

    /// MAIN ///
    
	public static void main(String[] args) {
	    ///Declarações
	    int opcao=0, verificar=1, ano, mes;
	    double[][][] temperaturas = new double [10][12][31];
	    Random random = new Random();
	    Scanner ler = new Scanner(System.in);
	    
	    //CADASTRO AUTOMATICO 1/2020
	    for(int i=0;i<=30; i++){
	        temperaturas[9][0][i] = random.nextInt(40);
	    }

	    //Instruções
	    System.out.println("Seja bem vindo(a). Escolha uma das opções a seguir: \n");
	    do {
	        mes=0;
	        ano=0;
	        menu();
	        opcao = ler.nextInt();
	        switch(opcao) {
	            case 1:
	                mes = entradaMes();
	                ano = entradaAno();
	                System.out.println("Informe as temperaturas: ");
	                for(int i=0; i<= qntdDiasMes(mes, ano)-1; i++) {
	                    temperaturas[ano][mes-1][i] = ler.nextDouble();
	                }
	                System.out.println("Todas as temperaturas de "+mes+"/"+transformarAno(ano)+" foram armazenadas.");
	                break;
	            case 2:
	                mes = entradaMes();
	                ano = entradaAno();
	                calculoMedia(mes, ano, temperaturas);
	                break;
	            case 3:
	                mes = entradaMes();
	                ano = entradaAno();
	                calculoMinimo(mes, ano, temperaturas);
	                break;
	            case 4:
	                mes = entradaMes();
	                ano = entradaAno();
	                calculoMaximo(mes, ano, temperaturas);
	                break;
	            case 5:
	                mes = entradaMes();
	                ano = entradaAno();
	                System.out.println("Temperatura de todos os dias: ");
	                for(int i=0; i<=qntdDiasMes(mes,ano)-1; i++) {
	                    System.out.println("Dia "+(i+1)+": "+temperaturas[ano][mes-1][i]);
	                }
	                calculoMedia(mes, ano, temperaturas);
	                calculoMinimo(mes, ano, temperaturas);
	                calculoMaximo(mes, ano, temperaturas);
	                break;
	            case 6:
	                verificar = 0;
	                break;
	            default:
	                System.out.println("Insira uma opcao valida.");
	        }
	    } while (verificar != 0);
	}
	    /// FUNCOES ///
    public static void menu () {
        System.out.println("----------------------------------------");
        System.out.println("1- Entrada de temperaturas.");
        System.out.println("2- Cálculo da temperatura média.");
        System.out.println("3- Cálculo da temperatura mínima.");
        System.out.println("4- Cálculo da temperatura máxima.");
        System.out.println("5- Relatório meteorológico.");
        System.out.println("6- Finalizar programa.");
        System.out.println("----------------------------------------\n"); 
    }
    
    public static int entradaMes () {
        int mes, verificar=1;
        Scanner ler = new Scanner(System.in);
        System.out.println("Primeiramente, insira o mes");
	    do {
	        mes = ler.nextInt();
            if (mes >= 1 && mes <= 12) {
	            verificar = 0;
	        } else {
	            System.out.println("Insira uma data valida.");
	        }    
	    } while (verificar != 0);
	    return mes;
    }
    
    public static int entradaAno () {
        int ano, verificar=1;
	    Scanner ler = new Scanner(System.in);
        System.out.println("Agora o ano desejado");
	    do {
	        ano = ler.nextInt();
	        if (ano == 2011) {ano = 0;}
            else if (ano == 2012) {ano = 1;}
            else if (ano == 2013) {ano = 2;}
            else if (ano == 2014) {ano = 3;}
            else if (ano == 2015) {ano = 4;}
            else if (ano == 2016) {ano = 5;}
            else if (ano == 2017) {ano = 6;}
            else if (ano == 2018) {ano = 7;}
            else if (ano == 2019) {ano = 8;}
            else if (ano == 2020) {ano = 9;}
	        if (ano >= 0 && ano <= 9) {
	            verificar = 0;
	        } else {
	            System.out.println("Insira uma data valida.");
	        }
	    } while (verificar != 0);
	    return ano;
    }
    
    public static int transformarAno (int ano) {
        if (ano == 0) {return 2011;}
        else if (ano == 1) {return 2012;}
        else if (ano == 2) {return 2013;}
        else if (ano == 3) {return 2014;}
        else if (ano == 4) {return 2015;}
        else if (ano == 5) {return 2016;}
        else if (ano == 6) {return 2017;}
        else if (ano == 7) {return 2018;}
        else if (ano == 8) {return 2019;}
        else {return 2020;}
    }
    
    public static int qntdDiasMes (int mes, int ano) {
        transformarAno(ano);
        if (mes == 2) {
            if(((ano % 400) == 0) || (((ano % 4) == 0) && ((ano % 100) != 0))) {
                return 29;
            } else {
                return 28;
            }
        } else if(mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10|| mes == 12) {
            return 31;
        } else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
            return 30;
        } else {
            return 0;
        }
    }
    
    public static void calculoMedia (int mes, int ano, double temperaturas[][][]) {
        double media=0;
        for(int i=0; i<=qntdDiasMes(mes,ano)-1; i++) {
	        media +=  temperaturas[ano][mes-1][i];
	    }
	    media = media/qntdDiasMes(mes,ano);
	    System.out.println("A media de temperaturas de "+mes+"/"+transformarAno(ano)+" foi de "+media);
    }
    
    public static void calculoMinimo (int mes, int ano, double temperaturas[][][]) {
        double minimo=0;
        minimo = temperaturas[ano][mes-1][0];
	    for(int i=1; i<=qntdDiasMes(mes,ano)-1; i++) {
	        if(minimo > temperaturas[ano][mes-1][i]) {
	            minimo = temperaturas[ano][mes-1][i];
	        }
	    }
	    System.out.println("A temperatura minima foi de "+minimo+" graus e ocorreu em ");
	    for(int i=0; i<=qntdDiasMes(mes,ano)-1; i++) {
	        if(minimo == temperaturas[ano][mes-1][i]) {
	            System.out.println(i+1+"/"+mes+"/"+transformarAno(ano));
	        }
	    }
    }
    
    public static void calculoMaximo (int mes, int ano, double temperaturas[][][]) {
        double maximo=0;
        maximo = temperaturas[ano][mes-1][0];
	    for(int i=1; i<=qntdDiasMes(mes,ano)-1; i++) {
	        if(maximo < temperaturas[ano][mes-1][i]) {
	            maximo = temperaturas[ano][mes-1][i];
	        }
	    }
	    System.out.println("A temperatura maxima foi de "+maximo+" graus e ocorreu em ");
	    for(int i=0; i<=qntdDiasMes(mes,ano)-1; i++) {
	        if(maximo == temperaturas[ano][mes-1][i]) {
	            System.out.println(i+1+"/"+mes+"/"+transformarAno(ano));
	        }
	    }
    }
}







