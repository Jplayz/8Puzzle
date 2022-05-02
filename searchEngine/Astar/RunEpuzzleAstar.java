public class RunEpuzzleAstar {
    public static void main(String[] arg) {
        EpuzzGen gen = new EpuzzGen(23456);
        int[][] puzz = gen.puzzGen(12); 

        int[][] tar = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 0 } };

        // Put "hamming" for hamming search and "manhattan" for manhattan
        // if its invalid it defaults to manhattan - case sensitive 
        EpuzzleSearch searcher = new EpuzzleSearch(tar, "manhattan");
        SearchState initState = (SearchState) new EpuzzleState(puzz, 0);

        String res_astar = searcher.runSearch(initState, "AStar");
        System.out.println(res_astar);
    }
}