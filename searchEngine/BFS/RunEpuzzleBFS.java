public class RunEpuzzleBFS {
    public static void main(String[] arg) {
        int[][] seed = new int[][] { { 2, 3, 6 }, { 1, 5, 8 }, { 4, 7, 0 } };
        int[][] tar = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 0 } };

        EpuzzleSearch searcher = new EpuzzleSearch(tar);
        SearchState initState = (SearchState) new EpuzzleState(seed);

        String resb = searcher.runSearch(initState, "breadthFirst");
        System.out.println(resb);
    }
}