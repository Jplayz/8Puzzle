import java.util.ArrayList;
import java.util.Map;
import java.util.Arrays;

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
        return (Arrays.deepEquals(seed, tar));
    }
  /**
   * getSuccessors
   * 
   * @param searcher - the current search
   */

    public ArrayList<SearchState> getSuccessors(Search searcher){
        EpuzzleSearch eSearch = (EpuzzleSearch) searcher;
        int[][] currentState = eSearch.getSeed();

        ArrayList<EpuzzleState> eslis = new ArrayList<EpuzzleState>(); 
        ArrayList<SearchState> slis = new ArrayList<SearchState>();

        // Moves 0,0 right
        if (currentState[0][0] == 0){
            int[][] newSeed = new int[3][3];
            System.arraycopy(currentState, 0, newSeed, 0, seed.length);
            newSeed[0][0] = currentState[0][1];
            newSeed[0][1] = 0;
            eslis.add(new EpuzzleState(newSeed));
        }

        // Moves 0,0 down
        if (currentState[0][0] == 0){
            int[][] newSeed = new int[3][3];
            System.arraycopy(currentState, 0, newSeed, 0, seed.length);
            newSeed[0][0] = currentState[1][0];
            newSeed[1][0] = 0;
            eslis.add(new EpuzzleState(newSeed));
        }

        // Moves 0,1 right
        if (currentState[0][1] == 0){
            int[][] newSeed = new int[3][3];
            System.arraycopy(currentState, 0, newSeed, 0, seed.length);
            newSeed[0][1] = currentState[0][2];
            newSeed[0][2] = 0;
            eslis.add(new EpuzzleState(newSeed));
        }

        // Moves 0,2
        if (currentState[0][1] == 0){
            int[][] newSeed = new int[3][3];
            System.arraycopy(currentState, 0, newSeed, 0, seed.length);
            newSeed[0][1] = currentState[0][0];
            newSeed[0][0] = 0;
            eslis.add(new EpuzzleState(newSeed));
        }

        if (currentState[0][1] == 0){
            int[][] newSeed = new int[3][3];
            System.arraycopy(currentState, 0, newSeed, 0, seed.length);
            newSeed[0][1] = currentState[0][2];
            newSeed[0][2] = 0;
            eslis.add(new EpuzzleState(newSeed));
        }

        if (currentState[0][2] == 0){
            int[][] newSeed = new int[3][3];
            System.arraycopy(currentState, 0, newSeed, 0, seed.length);
            newSeed[0][2] = currentState[1][2];
            newSeed[1][2] = 0;
            eslis.add(new EpuzzleState(newSeed));
        }

        if (currentState[0][2] == 0){
            int[][] newSeed = new int[3][3];
            System.arraycopy(currentState, 0, newSeed, 0, seed.length);
            newSeed[0][2] = currentState[0][1];
            newSeed[0][1] = 0;
            eslis.add(new EpuzzleState(newSeed));
        }

        if (currentState[1][0] == 0){
            int[][] newSeed = new int[3][3];
            System.arraycopy(currentState, 0, newSeed, 0, seed.length);
            newSeed[1][0] = currentState[0][0];
            newSeed[0][0] = 0;
            eslis.add(new EpuzzleState(newSeed));
        }

        if (currentState[1][0] == 0){
            int[][] newSeed = new int[3][3];
            System.arraycopy(currentState, 0, newSeed, 0, seed.length);
            newSeed[1][0] = currentState[2][0];
            newSeed[2][0] = 0;
            eslis.add(new EpuzzleState(newSeed));
        }

        if (currentState[1][0] == 0){
            int[][] newSeed = new int[3][3];
            System.arraycopy(currentState, 0, newSeed, 0, seed.length);
            newSeed[1][0] = currentState[1][1];
            newSeed[1][1] = 0;
            eslis.add(new EpuzzleState(newSeed));
        }

        if (currentState[1][1] == 0){
            int[][] newSeed = new int[3][3];
            System.arraycopy(currentState, 0, newSeed, 0, seed.length);
            newSeed[1][1] = currentState[1][2];
            newSeed[1][2] = 0;
            eslis.add(new EpuzzleState(newSeed));
        }

        if (currentState[1][1] == 0){
            int[][] newSeed = new int[3][3];
            System.arraycopy(currentState, 0, newSeed, 0, seed.length);
            newSeed[1][1] = currentState[0][1];
            newSeed[0][1] = 0;
            eslis.add(new EpuzzleState(newSeed));
        }

        if (currentState[1][1] == 0){
            int[][] newSeed = new int[3][3];
            System.arraycopy(currentState, 0, newSeed, 0, seed.length);
            newSeed[1][1] = currentState[1][0];
            newSeed[1][2] = 0;
            eslis.add(new EpuzzleState(newSeed));
        }

        if (currentState[1][1] == 0){
            int[][] newSeed = new int[3][3];
            System.arraycopy(currentState, 0, newSeed, 0, seed.length);
            newSeed[1][1] = currentState[2][1];
            newSeed[2][1] = 0;
            eslis.add(new EpuzzleState(newSeed));
        }

        if (currentState[1][2] == 0){
            int[][] newSeed = new int[3][3];
            System.arraycopy(currentState, 0, newSeed, 0, seed.length);
            newSeed[1][2] = currentState[2][2];
            newSeed[2][2] = 0;
            eslis.add(new EpuzzleState(newSeed));
        }

        if (currentState[1][2] == 0){
            int[][] newSeed = new int[3][3];
            System.arraycopy(currentState, 0, newSeed, 0, seed.length);
            newSeed[1][2] = currentState[0][2];
            newSeed[0][2] = 0;
            eslis.add(new EpuzzleState(newSeed));
        }
        if (currentState[1][2] == 0){
            int[][] newSeed = new int[3][3];
            System.arraycopy(currentState, 0, newSeed, 0, seed.length);
            newSeed[1][2] = currentState[1][1];
            newSeed[1][1] = 0;
            eslis.add(new EpuzzleState(newSeed));
        }

        if (currentState[2][0] == 0){
            int[][] newSeed = new int[3][3];
            System.arraycopy(currentState, 0, newSeed, 0, seed.length);
            newSeed[2][0] = currentState[1][0];
            newSeed[1][0] = 0;
            eslis.add(new EpuzzleState(newSeed));
        }

        if (currentState[2][0] == 0){
            int[][] newSeed = new int[3][3];
            System.arraycopy(currentState, 0, newSeed, 0, seed.length);
            newSeed[2][0] = currentState[2][1];
            newSeed[2][1] = 0;
            eslis.add(new EpuzzleState(newSeed));
        }

        if (currentState[2][1] == 0){
            int[][] newSeed = new int[3][3];
            System.arraycopy(currentState, 0, newSeed, 0, seed.length);
            newSeed[2][1] = currentState[2][0];
            newSeed[2][0] = 0;
            eslis.add(new EpuzzleState(newSeed));
        }

        if (currentState[2][1] == 0){
            int[][] newSeed = new int[3][3];
            System.arraycopy(currentState, 0, newSeed, 0, seed.length);
            newSeed[2][1] = currentState[2][2];
            newSeed[2][2] = 0;
            eslis.add(new EpuzzleState(newSeed));
        }

        if (currentState[2][1] == 0){
            int[][] newSeed = new int[3][3];
            System.arraycopy(currentState, 0, newSeed, 0, seed.length);
            newSeed[2][1] = currentState[1][1];
            newSeed[1][1] = 0;
            eslis.add(new EpuzzleState(newSeed));
        }

        if (currentState[2][2] == 0){
            int[][] newSeed = new int[3][3];
            System.arraycopy(currentState, 0, newSeed, 0, seed.length);
            newSeed[2][2] = currentState[1][2];
            newSeed[1][2] = 0;
            eslis.add(new EpuzzleState(newSeed));
        }

        if (currentState[2][2] == 0){
            int[][] newSeed = new int[3][3];
            System.arraycopy(currentState, 0, newSeed, 0, seed.length);
            newSeed[2][2] = currentState[2][1];
            newSeed[2][1] = 0;
            eslis.add(new EpuzzleState(newSeed));
        }


        for (EpuzzleState es : eslis)
            slis.add((SearchState) es);

        return slis;
    }

    public boolean sameState(SearchState s2) {
        EpuzzleState es = (EpuzzleState) s2;
    
        return (Arrays.deepEquals(seed, es.get_seed()));
      }

}
