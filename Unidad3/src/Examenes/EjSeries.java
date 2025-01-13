package Examenes;

import java.util.Scanner;

public class EjSeries 
{

	public static void main(String[] args) 
	{
		/*int[] serieLarga= {3, 5, 4, 7, 8, 9, 2, 3, 6, 4, 7, 8, 9, 6, 4, 3, 1, 8, 6, 5, 3, 8};
		int[] serieCorta= {8, 9, 6, 4, 3, 1};
		int tamanioLarga=serieLarga.length;
		int tamanioCorta=serieCorta.length;
		*/
		int[] serieLarga=new int[100];
		int[] serieCorta=new int[100];
		int tamanioLarga=0;
		int tamanioCorta=0;
		try(Scanner sc=new Scanner(System.in)){
			
			System.out.println("Introduzca datos de la serie larga (para con 0): ");
			int dato=sc.nextInt();
			while(dato!=0 && tamanioLarga<serieLarga.length) {
				serieLarga[tamanioLarga]=dato;
				tamanioLarga++;
				dato=sc.nextInt();
			}
			
			System.out.println("Introduzca datos de la serie corta (para con 0): ");
			dato=sc.nextInt();
			while(dato!=0 && tamanioCorta<serieCorta.length) {
				serieCorta[tamanioCorta]=dato;
				tamanioCorta++;
				dato=sc.nextInt();
			}
		}
		boolean encontrada=false;
		int i;
		for(i=0;i<tamanioLarga && !encontrada;i++) {
			int j=0;
			int iaux=i;
			while(iaux<tamanioLarga && j<tamanioCorta && serieLarga[iaux]==serieCorta[j]) {
				//System.out.println(serieLarga[iaux]+" coincide");
				iaux++;
				j++;
			}
			if(j==tamanioCorta) {
				encontrada=true;
			}
		}
		if(encontrada) {
			System.out.println("Se ha encontrado desde la posición "+(i-1));
		} else {
			System.out.println("No se ha encontrado");
		}
	}

}
