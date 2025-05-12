import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner (System.in);
			boolean sonIguales=false;
			//1 - Obten la instancia con algoritmo MD5 ---DONE---
			MessageDigest md = MessageDigest.getInstance("MD5");
			
			System.out.print("Introduzca la password: ");
			byte[] pwdByte = sc.nextLine().getBytes();
			//2 - Actualiza la instancia ---DONE---
			
			md.update(pwdByte);

			//3 - Calcula el resumen ---DONE---
			byte[] resumenPwd = md.digest();
			do {
				System.out.print("Repetir password: ");
				pwdByte = sc.nextLine().getBytes();
				//4 - Limpia la instancia ---DONE---
				md.reset();
				
				//5 - Actualiza la instancia ---DONE---
				md.update(pwdByte);
				
				//6 - Calcula el resumen ---DONE---
				byte[] resumenPwdRepetir = md.digest();
				
				sonIguales = Arrays.equals(resumenPwd,resumenPwdRepetir);
				if (!sonIguales) {
					System.out.println("Password incorrecta");
				}
			} while (!sonIguales);
			System.out.println("Fin del programa");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}