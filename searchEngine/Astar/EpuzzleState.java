import java.lang.annotation.Target;
import java.util.ArrayList;
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
     * @param rc,   the estimated remaining cost
     */
    public EpuzzleState(int[][] seedIn, int rc) {
        seed = seedIn;
        localCost = 1;
        estRemCost = rc;
    }

    /**
     * Returns the seed
     */
    public int[][] get_seed() {
        return seed;
    }

    /**
     * toString
     */
    public String toString() {

        String output = "Current State: \n";
        output += seed[0][0] + " " + seed[0][1] + " " + seed[0][2] + "\n";
        output += seed[1][0] + " " + seed[1][1] + " " + seed[1][2] + "\n";
        output += seed[2][0] + " " + seed[2][1] + " " + seed[2][2] + "\n";

        return output;
    }

    /**
     * goalPredicate
     * 
     * @param searcher - the current search
     */
    public boolean goalPredicate(Search searcher) {
        EpuzzleSearch esearcher = (EpuzzleSearch) searcher;
        int[][] tar = esearcher.getTarget(); // get target
        return (Arrays.deepEquals(seed, tar));
    }

    /**
     * getSuccessors
     * 
     * @param searcher - the current search
     */

    public ArrayList<SearchState> getSuccessors(Search searcher) {
        ArrayList<EpuzzleState> eslis = new ArrayList<EpuzzleState>();
        ArrayList<SearchState> slis = new ArrayList<SearchState>();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (seed[i][j] == 0) {
                    // Creates copies of the current state for movement
                    int[][] rightSeed = copyState(seed);
                    int[][] leftSeed = copyState(seed);
                    int[][] upSeed = copyState(seed);
                    int[][] downSeed = copyState(seed);

                    if (j + 1 < 3) {
                        // Moves empty to the right
                        swap(i, j, i, j + 1, rightSeed);
                        eslis.add(new EpuzzleState(rightSeed, manhattan(searcher)));
                    }

                    if (j - 1 >= 0) {
                        // Moves empty to the left
                        swap(i, j, i, j - 1, leftSeed);
                        eslis.add(new EpuzzleState(leftSeed, manhattan(searcher)));
                    }

                    if (i - 1 >= 0) {
                        // Moves empty up
                        swap(i, j, i - 1, j, upSeed);
                        eslis.add(new EpuzzleState(upSeed, manhattan(searcher)));
                    }

                    if (i + 1 < 3) {
                        // Moves empty down
                        swap(i, j, i + 1, j, downSeed);
                        eslis.add(new EpuzzleState(downSeed, manhattan(searcher)));
                    }
                }
            }

        }

        for (EpuzzleState es : eslis)
            slis.add((SearchState) es);

        return slis;
    }

    public int hamming(Search searcher) {
        EpuzzleSearch esearcher = (EpuzzleSearch) searcher;
        int[][] tar = esearcher.getTarget(); // get target
        int hamming = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tar[i][j] == seed[i][j])
                    hamming += 1;
            }
        }
        return hamming;
    }

    public int manhattan(Search searcher) {
        EpuzzleSearch esearcher = (EpuzzleSearch) searcher;
        int[][] tar = esearcher.getTarget(); // get target
        int manhattan = 0;

        for (int ti = 0; ti < 3; ti++) {
            for (int tj = 0; tj < 3; tj++) {
                for (int ci = 0; ci < 3; ci++) {
                    for (int cj = 0; cj < 3; cj++) {
                        if (tar[ti][tj] == seed[ci][cj]) {
                            manhattan += ci - ti;
                            manhattan += cj - tj;
                        }
                    }
                }
            }
        }

        return manhattan;
    }

    public boolean sameState(SearchState s2) {
        EpuzzleState es = (EpuzzleState) s2;

        return (Arrays.deepEquals(seed, es.get_seed()));
    }

    public static void swap(int ox, int oy, int nx, int ny, int[][] array) {
        int temp = array[ox][oy];
        array[ox][oy] = array[nx][ny];
        array[nx][ny] = temp;
    }

    public int[][] copyState(int[][] state) {
        int[][] copiedState = new int[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                copiedState[i][j] = state[i][j];
            }
        }
        return copiedState;
    }
}
