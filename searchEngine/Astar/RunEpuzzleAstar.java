public class RunEpuzzleAstar {
    public static void main(String[] arg) {
        int[][] seed = new int[][] { { 1, 0, 3 }, { 4, 2, 6 }, { 7, 5, 8 } };
        int[][] tar = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 0 } };

        EpuzzleSearch searcher = new EpuzzleSearch(tar);
        SearchState initState = (SearchState) new EpuzzleState(seed, 0);

        String res_astar = searcher.runSearch(initState, "AStar");
        System.out.println(res_astar);
    }
}