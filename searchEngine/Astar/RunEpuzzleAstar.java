public class RunEpuzzleAstar {
    public static void main(String[] arg) {
         int s = 23456;
        EpuzzGen gen = new EpuzzGen(s);

        int d = 13;
        int[][] puzz = gen.puzzGen(d); 

       // System.out.println(puzz[0][0]+" "+puzz[0][1]+" "+puzz[0][2]);
        //System.out.println(puzz[1][0]+" "+puzz[1][1]+" "+puzz[1][2]);
        //System.out.println(puzz[2][0]+" "+puzz[2][1]+" "+puzz[2][2]);

        //int[][] puzz = new int[][] { { 1, 0, 3 }, { 4, 2, 6 }, { 7, 5, 8 } };
        int[][] tar = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 0 } };

        EpuzzleSearch searcher = new EpuzzleSearch(tar);
        SearchState initState = (SearchState) new EpuzzleState(puzz, 0);

        String res_astar = searcher.runSearch(initState, "AStar");
        System.out.println(res_astar);
    }
}