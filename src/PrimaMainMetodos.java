import java.util.Scanner;

/**
 * Clase para <strong>calcular las primas de los empleados</strong>. El programa
 * <b>solicita</b> los datos por consola y <u>retorna la prima que le
 * corresponde</u>. Al terminar, da la oportunidad de seguir calculando nuevas
 * primas.
 * 
 * @author Alexis Casta�o Verdes
 * @version 1.0
 * @since 21/04/2022
 *
 */
public class PrimaMainMetodos {

	static Scanner teclado = new Scanner(System.in);

	/** Inicia el programa */
	public static void main(String[] args) {

		int numEmple;
		String nomEmple;
		int meses;
		char esDirectivo;
		char respuesta;

		do {
			System.out.println("\nDATOS  EMPLEADO/A");
			numEmple = leerNumEmple();
			nomEmple = leerNomEmple();
			meses = leerMeses();
			esDirectivo = leerEsDirectivo();
			System.out.println("\n\tLe corresponde la prima " + hallarPrima(esDirectivo, meses));

			System.out.println("\n�CALCULAR MAS PRIMAS? (S/N): ");
			respuesta = teclado.nextLine().toUpperCase().charAt(0);
		} while (respuesta == 'S');
	}

	/**
	 * Retorna la prima correcta para una persona a partir del n�mero de meses
	 * trabajados y el flag esDirectivo
	 * 
	 * @param esDirectivo +/-
	 * @param meses       meses trabajados
	 * @return La prima
	 */
	public static String hallarPrima(char esDirectivo, int meses) {
		if (esDirectivo == '+') // ES DIRECTIVO
			if (meses >= 12)
				return "P1";
			else
				return "P3";
		else // NO ES DIRECTIVO
		if (meses >= 12)
			return "P2";
		else
			return "P4";
	}

	/**
	 * Pregunta al usuario su n�mero de empleado, si est� comprendido entre 100 y
	 * 999 lo obtiene y lo retorna.
	 * 
	 * @return n�mero de empleado
	 */
	public static int leerNumEmple() {
		int numEmple;
		do {
			System.out.println("N�MERO [100-999]: ");
			numEmple = teclado.nextInt();
		} while (numEmple < 100 || numEmple > 999);
		teclado.nextLine();
		return numEmple;
	}

	/**
	 * Solicita y retorna el nombre del empleado. Si el nombre facilitado excede los
	 * 10 caracteres, volver� a solicitar un nombre v�lido.
	 * 
	 * @return el nombre del empleado
	 */
	public static String leerNomEmple() {
		String nomEmple;
		do {
			System.out.println("NOMBRE (max 10 caracteres): ");
			nomEmple = teclado.nextLine();
		} while (nomEmple.length() > 10);
		return nomEmple;
	}

	/**
	 * Solicita y retorna n�mero de meses trabajados. Si el n�mero facilitado es
	 * menos de 0, volver� a solicitar un n�mero v�lido.
	 * 
	 * @return los meses trabajados
	 */
	public static int leerMeses() {
		int meses;
		do {
			System.out.println("MESES DE TRABAJO: ");
			meses = teclado.nextInt();
		} while (meses < 0);
		teclado.nextLine();
		return meses;
	}

	/**
	 * Solicita y retorna si una persona es un directivo. Si el valor introducido no
	 * es v�lido, volver� a solicitar un n�mero v�lido.Los valores v�lidos son + y -
	 * 
	 * @return Flag direcci�n, positivo o negativo
	 */
	public static char leerEsDirectivo() {
		char esDirectivo;
		do {
			System.out.println("�ES DIRECTIVO? (+/-): ");
			esDirectivo = teclado.nextLine().charAt(0);
		} while (esDirectivo != '+' && esDirectivo != '-');
		return esDirectivo;
	}
}
