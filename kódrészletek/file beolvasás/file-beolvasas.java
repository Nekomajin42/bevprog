package beolvasás;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Beolvasás {

	public static void main(String[] args) throws FileNotFoundException {

		// 0. lépés -> A file megnyitása (a be.txt érettségizők adatait tartalmazza)
		File be = new File("be.txt");
		Scanner sc = new Scanner(be);

		// 1. lépés
		String sor;

		// 2. lépés
		String[] tömb;

		// 3. lépés
		String név, nem;
		String[] születésidátum;
		int év, hónap, nap;
		boolean emelt;

		// 4. lépés
		Személy érettségiző;

		// 5. lépés
		ArrayList<Személy> érettségizők = new ArrayList<>();

		while (sc.hasNextLine()) {

			// 1. lépés -> Egy sor beolvasása
			sor = sc.nextLine();

			// 2. lépés -> A sor feldarabolása a megadott határolókarater mentén
			tömb = sor.split(";");

			// 3. lépés -> Az adatok konvertálása a megfelelő típusra
			név = tömb[0];
			nem = tömb[1].equals("0") ? "férfi" : "nő";
			
			születésidátum = tömb[2].split(".");
			év = Integer.parseInt(születésidátum[0]);
			hónap = Integer.parseInt(születésidátum[1]);
			nap = Integer.parseInt(születésidátum[2]);
			
			emelt = tömb[3].equals("igen") ? true : false;
			
			// 4. lépés -> Az objektum létrehozása
			érettségiző = new Személy(név, nem, év, hónap, nap, emelt);
			
			// 5. lépés -> Az objektum hozzáadása a listához
			érettségizők.add(érettségiző);
		}
	}
}

class Személy {

	String név, nem;
	int év, hónap, nap;
	boolean emelt;

	public Utazas(String név, String nem, int év, int hónap, int nap, boolean emelt) {
		this.név = név;
		this.nem = nem;
		this.év = év;
		this.hónap = hónap;
		this.nap = nap;
		this.emelt = emelt;
	}
}
