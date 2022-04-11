import java.util.ArrayList;
import java.util.Map;

/**
* EpuzzleState.java
* State in the Epuzzle problem
*/

public class EpuzzleState extends SearchState {
    private int[][] seed;

    /**
   * constructor
   * 
   * @param seed, the seed being input
   */
    public  EpuzzleState(int[][] seedIn){
        seed = seedIn;
    }
    
    /**
   * Returns the seed
   */ 
    public int[][] get_seed(){
        return seed;
    }

    /**
   * toString
   */
    public String toString() {
        String output = "Current State: \n";
        output += seed[0][0]+" "+seed[0][1]+" "+seed[0][2]+"\n";
        output += seed[1][0]+" "+seed[1][1]+" "+seed[1][2]+"\n";
        output += seed[2][0]+" "+seed[2][1]+" "+seed[2][2]+"\n";

        return output;
    }

    /**
   * goalPredicate
   * 
   * @param searcher - the current search
   */
    public boolean goalPredicate(Search searcher) {
        EpuzzleSearch jsearcher = (EpuzzleSearch) searcher;
        int[][] tar = jsearcher.getTarget(); // get target 
        return (seed == tar);
    }

    public ArrayList<SearchState> getSuccessors(Search searcher){
        EpuzzleSearch eSearch = (EpuzzleSearch) searcher;
        int[][] currentState = eSearch.getSeed();

        ArrayList<EpuzzleState> eslis = new ArrayList<EpuzzleState>(); 
        ArrayList<SearchState> slis = new ArrayList<SearchState>();

        if (currentState[0][0] == 0){
            int[][] newSeed = new int[3][3];
            System.arraycopy(currentState, 0, newSeed, 0, seed.length);
            newSeed[0][0] = currentState[0][1];
            newSeed[0][1] = 0;
            eslis.add(new EpuzzleState(newSeed));
        }

        for (EpuzzleState es : eslis)
            slis.add((SearchState) es);

        return slis;
    }

}
