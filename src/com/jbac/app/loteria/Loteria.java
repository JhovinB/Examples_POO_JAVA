package com.jbac.app.loteria;

public class Loteria {
	public static void main(String[] args) {
		
		int generados=0;//Declaracion y Inicializacion
		int []nums = new int[6];
		int n;//Declaracion
		
		do {
			//Generamos el numero aleatorio entre 1-49
			n=(int) (Math.random()*49+1);
			//Si no esta repetido, lo guardamos en el array
			if (!repetido(n,nums,generados)) {
				nums[generados]=n;
				generados++;
			}
		} while (generados<6);
		
		ordenar(nums);
		mostrar(nums);
	}
	private static boolean repetido(int n, int[] nums, int generados) {
		boolean res = false;
		for (int i = 0; i < generados; i++) {
			if (n==nums[i]) {
				res=true;
				break;
			}
		}
		return res;
	}
	public static void ordenar(int []nums) {
		int aux;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i; j < nums.length; j++) {
				if (nums[j]<nums[i]) {
					aux=nums[i];
					nums[i]=nums[j];
					nums[j]=aux;
				}
			}
		}
	}
	public static void mostrar(int [] nums) {
		for (int num:nums) {
			System.out.print(num+",");
		}
	}
}
