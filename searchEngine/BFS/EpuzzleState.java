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
        int[][] currentState = seed;

        ArrayList<EpuzzleState> eslis = new ArrayList<EpuzzleState>(); 
        ArrayList<SearchState> slis = new ArrayList<SearchState>();

          // If empty is top left
        if (currentState[0][0] == 0){
            // Creates copies of the current state for movement
            int[][] rightSeed = copyState(currentState);
            int[][] downSeed = copyState(currentState);
    
            // Moves empty to the right
            swap(0, 0, 0, 1, rightSeed);
            eslis.add(new EpuzzleState(rightSeed));

            // Moves empty down
            swap(0, 0, 1, 0, downSeed);
            eslis.add(new EpuzzleState(downSeed));
            
        }

        // If empty is in top middle
        if (currentState[0][1] == 0){
            // Creates copies of the current state for movement
            int[][] rightSeed = copyState(currentState);
            int[][] leftSeed = copyState(currentState);
            int[][] downSeed = copyState(currentState);
    
            // Moves empty to the right
            swap(0, 1, 0, 2, rightSeed);
            eslis.add(new EpuzzleState(rightSeed));

            // Moves empty to the left
            swap(0, 1, 0, 0, leftSeed);
            eslis.add(new EpuzzleState(leftSeed));

            // Moves empty down
            swap(0, 1, 1, 1, downSeed);
            eslis.add(new EpuzzleState(downSeed));
            
        }

        // If empty is in top right
        if (currentState[0][2] == 0){
            // Creates copies of the current state for movement
            int[][] leftSeed = copyState(currentState);
            int[][] downSeed = copyState(currentState);

            // Moves empty to the left
            swap(0, 2, 0, 1, leftSeed);
            eslis.add(new EpuzzleState(leftSeed));

            // Moves empty down
            swap(0, 2, 1, 2, downSeed);
            eslis.add(new EpuzzleState(downSeed));
            
        }

        // If empty is in middle left
        if (currentState[1][0] == 0){
            // Creates copies of the current state for movement
            int[][] rightSeed = copyState(currentState);
            int[][] upSeed = copyState(currentState);
            int[][] downSeed = copyState(currentState);
    
            // Moves empty to the right
            swap(1, 0, 1, 1, rightSeed);
            eslis.add(new EpuzzleState(rightSeed));

            // Moves empty up
            swap(1, 0, 0, 0, upSeed);
            eslis.add(new EpuzzleState(upSeed));

            // Moves empty down
            swap(1, 0, 2, 0, downSeed);
            eslis.add(new EpuzzleState(downSeed));
            
        }

        // If empty is in middle,middle
        if (currentState[1][1] == 0){
            // Creates copies of the current state for movement
            int[][] rightSeed = copyState(currentState);
            int[][] leftSeed = copyState(currentState);
            int[][] upSeed = copyState(currentState);
            int[][] downSeed = copyState(currentState);
    
            // Moves empty to the right
            swap(1, 1, 1, 2, rightSeed);
            eslis.add(new EpuzzleState(rightSeed));

            // Moves empty to the left
            swap(1, 1, 1, 0, leftSeed);
            eslis.add(new EpuzzleState(leftSeed));
            
            // Moves empty up
            swap(1, 1, 0, 1, upSeed);
            eslis.add(new EpuzzleState(upSeed));

            // Moves empty down
            swap(1, 1, 2, 1, downSeed);
            eslis.add(new EpuzzleState(downSeed));
    
        }

        // If empty is in middle,right
        if (currentState[1][2] == 0){
            // Creates copies of the current state for movement
            int[][] leftSeed = copyState(currentState);
            int[][] upSeed = copyState(currentState);
            int[][] downSeed = copyState(currentState);
    
            // Moves empty to the left
            swap(1, 2, 1, 1, leftSeed);
            eslis.add(new EpuzzleState(leftSeed));
            
            // Moves empty up
            swap(1, 2, 0, 2, upSeed);
            eslis.add(new EpuzzleState(upSeed));

            // Moves empty down
            swap(1, 2, 2, 2, downSeed);
            eslis.add(new EpuzzleState(downSeed));
            
        } 

        // If empty is in bottom left
        if (currentState[2][0] == 0){
            // Creates copies of the current state for movement
            int[][] rightSeed = copyState(currentState);
            int[][] upSeed = copyState(currentState);

            // Moves empty to the right
            swap(2, 0, 2, 1, rightSeed);
            eslis.add(new EpuzzleState(rightSeed));
            
            // Moves empty up
            swap(2, 0, 1, 0, upSeed);
            eslis.add(new EpuzzleState(upSeed));
        } 

        // If empty is in bottom middle
        if (currentState[2][1] == 0){
            // Creates copies of the current state for movement
            int[][] rightSeed = copyState(currentState);
            int[][] leftSeed = copyState(currentState);
            int[][] upSeed = copyState(currentState);

            // Moves empty to the right
            swap(2, 1, 2, 2, rightSeed);
            eslis.add(new EpuzzleState(rightSeed));
    
            // Moves empty to the left
            swap(2, 1, 2, 0, leftSeed);
            eslis.add(new EpuzzleState(leftSeed));
            
            // Moves empty up
            swap(2, 1, 1, 1, upSeed);
            eslis.add(new EpuzzleState(upSeed));
        }

        // If empty is in bottom right
        if (currentState[2][2] == 0) {
            // Creates copies of the current state for movement
            int[][] leftSeed = copyState(currentState);
            int[][] upSeed = copyState(currentState);
    
            // Moves empty to the left
            swap(2, 2, 2, 1, leftSeed);
            eslis.add(new EpuzzleState(leftSeed));
            
            // Moves empty up
            swap(2, 2, 1, 2, upSeed);
            eslis.add(new EpuzzleState(upSeed));

        } 

        for (EpuzzleState es : eslis)
            slis.add((SearchState) es);

        return slis;
    }

    public boolean sameState(SearchState s2) {
        EpuzzleState es = (EpuzzleState) s2;
    
        return (Arrays.deepEquals(seed, es.get_seed()));
      }

    public static void swap(int ox, int oy, int nx, int ny, int[][] array){
        int temp = array[ox][oy];
        array[ox][oy] = array[nx][ny];
        array[nx][ny] = temp;
      }
    

    public static void printArray(int[][] array){
        System.out.println("|"+array[0][0]+" "+array[0][1]+" "+array[0][2]+"|");
        System.out.println("|"+array[1][0]+" "+array[1][1]+" "+array[1][2]+"|");
        System.out.println("|"+array[2][0]+" "+array[2][1]+" "+array[2][2]+"|");
        System.out.println();
    }
    
    public int[][] copyState(int[][] state){
        int[][] copiedState = new int[3][3];

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                copiedState[i][j] = state[i][j];
            }
        }        
        return copiedState;
    }
}
