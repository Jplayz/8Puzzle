public class EpuzzleSearch extends Search {
    private int[][] target;
    private String searchType;

    public EpuzzleSearch(int[][] tar, String st) {
        target = tar;
        searchType = st;
    }

    public int[][] getTarget() {
        return target;
    }

    public String getType() {
        return searchType;
    }

}
