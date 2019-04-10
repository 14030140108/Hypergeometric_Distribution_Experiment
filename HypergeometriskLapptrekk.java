/**
 * Created by EIRIK OVESEN on 05.02.2018.
 */

import java.util.ArrayList;
import java.util.Random;

public class HypergeometriskLapptrekk{
    public static void main(String[] args){
        LagOgTrekkLapper lapptrekk = new LagOgTrekkLapper();

        for(int i = 1; i < 21; i++){
            System.out.println(lapptrekk.printAttempt(i));
        }
    }
}

/**
* A hypergeometric distribution expermient to produce a data set 
* Setup: Create a pool of 100 notes
* Put a cross on 12 notes
* Pick a random note from the pool, check if it has a cross 
* If it has a cross, count it
* Remove the note regardless
* Do this 20 times
*/

class LagOgTrekkLapper{
    public LagOgTrekkLapper(){}

	private int[] lapperMedKryss = new int[]{3, 9, 14, 34, 43, 49, 55, 61, 70, 77, 82, 97} // Notes with a cross on them
	
    public ArrayList<Lapp> laglapper(){		// Makes 100 notes numbered 0-99
        ArrayList<Lapp> lapper = new ArrayList<Lapp>();
        for(int i = 0; i < 100; i++){
            Lapp lappen=new Lapp(i, false);
            int y = lappen.getNummer();
            for(int i = 0; i < lapperMedKryss.Length(); i++){ 
				if(y == lapperMedKryss[i]){			// Checks if the note is supposed to have a cross
					lappen.setKryss(true);			// Sets the cross
				}
            }
            lapper.add(lappen);						// Adds the note to the array of notes
        }
        return lapper;			// Returns the array of 100 notes
    }

    public int plukk10lapper(ArrayList<Lapp> lapper){ // Pick 10 notes
        Random rn = new Random();
        int pick;
        int hvorMangeKryss = 0;
        int max = 100;
            for(int i = 0; i < 10; i++){			
                pick = rn.nextInt(max);				// Pick a random note
                if(lapper.get(pick).isKryss()){		// Check for cross
                    hvorMangeKryss++;				// Counts number of crossed notes found
                }
                lapper.remove(pick);				// Removes the picked note.
													
                max--;								// Reduces number of possible picks
            }
        return hvorMangeKryss;
    }

    public String printAttempt(int attempt){
        ArrayList<Lapp> lapper = laglapper();
        return "Attempt: "+attempt+": "+plukk10lapper(lapper);
    }
}


class Lapp {
    private int nummer;
    private boolean kryss;

    public Lapp(int nummer, boolean kryss){
        this.nummer=nummer;
        this.kryss=kryss;
    }


    public int getNummer() {
        return nummer;
    }

    public void setNummer(int nummer) {
        this.nummer = nummer;
    }

    public boolean isKryss() {
        return kryss;
    }

    public void setKryss(boolean kryss) {
        this.kryss = kryss;
    }
}
