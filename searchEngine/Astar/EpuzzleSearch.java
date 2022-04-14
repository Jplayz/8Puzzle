public class EpuzzleSearch extends Search {
    private int[][] target;

    public EpuzzleSearch(int[][] tar) {
        target = tar;
    }

    public int[][] getTarget() {
        return target;
    }
}
