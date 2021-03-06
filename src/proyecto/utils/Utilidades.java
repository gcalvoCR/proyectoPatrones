package proyecto.utils;

public class Utilidades {

	public static int getIntFromChar(char letra) {
		char letter = Character.toUpperCase(letra);
		switch (letter) {
		case 'A':
			return 0;
		case 'B':
			return 1;
		case 'C':
			return 2;
		case 'D':
			return 3;
		case 'E':
			return 4;
		case 'F':
			return 5;
		case 'G':
			return 6;
		case 'H':
			return 7;
		default:
			break;
		}
		return -1;
	}

	public static char getCharFromInt(int numero) {
		switch (numero) {
		case 0:
			return 'A';
		case 1:
			return 'B';
		case 2:
			return 'C';
		case 3:
			return 'D';
		case 4:
			return 'E';
		case 5:
			return 'F';
		case 6:
			return 'G';
		case 7:
			return 'H';
		default:
			break;
		}
		return 'Z';
	}

}
