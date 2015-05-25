package br.com.waiso.anhembi.facil.calculartemperatura;

public class Test {
	
	public static void main(String[] args) {

		calcularTemperaturas(new int[]{8, 20, 30, 50, 40, 20, -10}, 4);
		
		calcularTemperaturas(new int[]{-5, -12, 0, 6}, 2);
		
		calcularTemperaturas(new int[]{35, -35, 5, 100, 100, 50, 50}, 4);
		
		calcularTemperaturas(new int[]{35, -35}, 4);
	}
	
	/**
	 * 
	 * @param valores
	 * @param intervalo
	 */
	private static void calcularTemperaturas(int valores[], int intervalo) {
		try {
			if (valores.length <= intervalo) {
				System.out.println("O intervalo não pode ser maior que a quantidade de temperatura, pois não é possível fazer a média.");
			} else {
				int[] medias = calcularMedias(valores, intervalo);
				int max = encontrarMax(medias);
				int min = encontrarMin(medias);
				
				imprimir(medias, max, min);
			}
		} catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	/**
	 * 
	 * @param valores
	 * @param intervalo
	 * @return As médias calculadas a partir dos valores e intervalo das mediçoes
	 */
	private static int[] calcularMedias(int valores[], int intervalo) {
		int qtdeMedias = (valores.length-intervalo) + 1;
		int[] medias = new int[qtdeMedias];
		for (int i = 0; i < qtdeMedias; i++) {
			int soma = 0;
			for (int x = i; x < i+intervalo; x++) {
				soma += valores[x];
			}
			int media = soma/intervalo;
			medias[i] = media;
		}
		return medias;
	}
	
	/**
	 * 
	 * Método para encontrar o maior valor calculado das médias
	 * 
	 * @param valores
	 * @return O maior valor encontrado no Array
	 */
	private static int encontrarMax(int valores[]) {
		int max = valores[0];
		for (int i : valores) {
			if (i > max) {
				max = i;
			}
		}
		return max;
	}
	
	/**
	 * 
	 * Método para encontrar o menor valor calculado das médias
	 * 
	 * @param valores
	 * @return O menor valor encontrado no Array
	 */
	private static int encontrarMin(int valores[]) {
		int min = valores[0];
		for (int i : valores) {
			if (i < min) {
				min = i;
			}
		}
		return min;
	}
	
	/**
	 * 
	 * @param medias
	 * @param max
	 * @param min
	 * @param tarefa
	 */
	private static void imprimir(int[] medias, int max, int min) {
		System.out.println("***** Teste *****\n");
		for (int i : medias) {
			System.out.println("Média: " + i);
		}
		System.out.println("\nMenor: " + min);
		System.out.println("\nMaior: " + max);
		System.out.println("--------------------\n");
	}
	
}