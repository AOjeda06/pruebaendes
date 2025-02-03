package paquetedeprueba;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ClaseDePrueba {
	// Crear TreeMaps para los números y estrellas
	// static TreeMap<Integer, Integer> numeros = new TreeMap<>();
	//static TreeMap<Integer, Integer> estrellas = new TreeMap<>();
	// Escaner
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int ans;

		do {
			// Menú
			System.out.println("1. Introducir números y estrellas del último sorteo");
			System.out.println("2. Ver estadísticas");
			System.out.println("0. Salir");
			System.out.println("Cambio Roberto");
			ans = scanner.nextInt();

			// Acción seleccionada
			switch (ans) {
			case 1 -> introducirDatos();
			case 2 -> verEstadisticas();
			}

		} while (ans != 0);
	}

	public static void introducirDatos() {
		// Variables para los números y las estrellas
		int[] numerosSorteo = new int[5];
		int[] estrellasSorteo = new int[2];

		// Pedir los números
		System.out.println("Introduce los 5 números del último sorteo:");
		for (int i = 0; i < 5; i++) {
			numerosSorteo[i] = scanner.nextInt();
			actualizarConteo(numeros, numerosSorteo[i]);
		}

		// Pedir las estrellas
		System.out.println("Introduce las 2 estrellas del último sorteo:");
		for (int i = 0; i < 2; i++) {
			estrellasSorteo[i] = scanner.nextInt();
			actualizarConteo(estrellas, estrellasSorteo[i]);
		}
	}

	public static void actualizarConteo(TreeMap<Integer, Integer> mapa, int numero) {
		// Añade los nuevos numeros o actualiza los existentes
		if (mapa.containsKey(numero)) {
			mapa.put(numero, mapa.get(numero) + 1);
		} else {
			mapa.put(numero, 1);
		}
	}

	public static void verEstadisticas() {
		// Mostrar estadísticas de números
		System.out.println("Estadísticas de números:");
		for (Map.Entry<Integer, Integer> entry : numeros.entrySet()) {
			System.out.println("Número " + entry.getKey() + ": " + entry.getValue() + " veces");
		}

		// Mostrar estadísticas de estrellas
		System.out.println("Estadísticas de estrellas:");
		for (Map.Entry<Integer, Integer> entry : estrellas.entrySet()) {
			System.out.println("Estrella " + entry.getKey() + ": " + entry.getValue() + " veces");
		}
	}
}
