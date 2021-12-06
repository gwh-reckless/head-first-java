/**
 * Coding Example for Beer Song to illustrate how java program written
 */

package Chap1;

public class BeerSong {
    public static void main(String[] args) {
        int beerNum = 99;
        String word = "bottoles";

        while (beerNum > 0) {
            if (beerNum == 1) {
                word = "bottle"; // singular , as in ONE bottle
            }

            System.out.println("--------------------------");
            System.out.println(beerNum + " " + word + " of beer on the wall");
            System.out.println(beerNum + " " + word + " of beer.");
            System.out.println("Take onw down.");
            System.out.println("Pass it around.");
            beerNum = beerNum - 1;

            if (beerNum > 0) {
                System.out.println(beerNum + " " + word + " of beer on the wall");
            } else {
                System.out.println("No more bottles of beer on the wall");
            }
        }

    }
}
