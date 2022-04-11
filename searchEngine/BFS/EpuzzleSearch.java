public class EpuzzleSearch extends Search {
    private int[][] seed;
    private int[][] target;

    public EpuzzleSearch(int[][] seed2, int[][] tar){
        seed = seed2;
        target = tar;
    }

    public int[][] getSeed(){
        return seed;
    }

    public int[][] getTarget(){
        return target;
    }
}
