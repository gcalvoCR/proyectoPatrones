package proyecto.utils;

public class Utilidades {

	public static int getIntFromChar(char letra) {
		switch (letra) {
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
}
