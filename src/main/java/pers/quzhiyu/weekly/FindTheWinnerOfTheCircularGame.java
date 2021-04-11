package pers.quzhiyu.weekly;

public class FindTheWinnerOfTheCircularGame {
    public int findTheWinner(int n, int k) {

        int d = 0;
        for(int i=2; i<=n; i++){
            d = (d+k)%i;
        }
        return d;

    }
}
