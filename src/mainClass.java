import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Micah on 12/15/2015.
 */
public class mainClass {


    hintClass myClass;

    public mainClass(int[][] arrayS){
        myClass = new hintClass(arrayS);
    }

    public static boolean findMatches(int[][] arrayXY){
        boolean foundMatch = false;
        int len = 10;
        ArrayList<Coords> matched = new ArrayList<Coords>();
        for(int y = 0; y < len; y++){
            for( int x = 0; x < len; x++){
                //int matchCount = 0;
                for(int x1 = x; x1 < len; x1++){
                    if(arrayXY[y][x] != 0 && arrayXY[y][x] == arrayXY[y][x1]){
                        matched.add(new Coords(x1,y));
                    } else {
                        if(matched.size() >= 3){
                            for(int index = 0; index < matched.size();index++){
                                arrayXY[matched.get(index).y][matched.get(index).x] = 0;
                                foundMatch = true;
                            }
                            }
                        matched.clear();
                        break;
                    }
                }

                matched.clear();




                for(int y1 = y; y1 < len; y1++){
                    if(arrayXY[y][x] != 0 && arrayXY[y][x] == arrayXY[y1][x]){
                        matched.add(new Coords(x,y1));
                    } else
                    {
                        if(matched.size() >= 3) {
                            for (int index = 0; index < matched.size(); index++) {
                                arrayXY[matched.get(index).y][matched.get(index).x] = 0;
                                foundMatch = true;
                            }
                        }
                            matched.clear();
                            break;

                    }
                }

                matched.clear();
            }
        }
        String line = "";
        for (int y = 0; y < len; y++) {
            // System.out.println(y);
            for (int x = 0; x < len; x++) {
                line = x + " " +line;
                System.out.print(arrayXY[y][x] + " ");
            }
            System.out.println("Find Match X + Y");


        }
        System.out.println();

        return foundMatch;
    }

    public static class Coords {
        int x,y;

        public Coords(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static boolean dropGems(int[][] ArrayYX){
        Random rand = new Random();
        boolean isFull = true;
        int AY = 10;
        int AX = 10;
        String line = "";
        //count--;
        for (int y = AY - 1; y >= 0; y--) {
            for (int x = AX - 1; x >= 0; x--) {

                if(ArrayYX[y][x] == 0) {
                    isFull = false;
                    if(y - 1 >= 0){
                        ArrayYX[y][x] = ArrayYX[y-1][x];
                        ArrayYX[y-1][x] = 0;
                    } else {

                        ArrayYX[y][x] = rand.nextInt(8)+1;
                    }
                }


            }

        }

        for (int y = 0; y < AY; y++) {
            // System.out.println(y);
            for (int x = 0; x < AX; x++) {
                line = x + " " +line;
                System.out.print(ArrayYX[y][x] + " ");
            }
            System.out.println("Drop Gems");


        }
        System.out.println();

        return isFull;
    }

    public static void main(String[] args){
        Random rand = new Random();
        boolean isFull = false;
        String line = "";
        int AY = 10;
        int AX = 10;
        //int count = 50;
        int[][] ArrayYX = new int[AY][AX];

        while (!isFull) {
            isFull = true;
            //count--;
            for (int y = AY - 1; y >= 0; y--) {
                for (int x = AX - 1; x >= 0; x--) {

                    if(ArrayYX[y][x] == 0) {
                        isFull = false;
                        if(y - 1 >= 0){
                            ArrayYX[y][x] = ArrayYX[y-1][x];
                            ArrayYX[y-1][x] = 0;
                        } else {

                            ArrayYX[y][x] = rand.nextInt(8)+1;
                        }
                    }


                }

            }

            for (int y = 0; y < AY; y++) {
               // System.out.println(y);
                for (int x = 0; x < AX; x++) {
                    line = x + " " +line;
                    System.out.print(ArrayYX[y][x] + " ");
                }
                System.out.println("Line");


            }
            System.out.println();

        }
        isFull = false;
        System.out.println("___________________________");
        System.out.println();
        ArrayYX[9][4] = 0;
        ArrayYX[8][4] = 0;
        ArrayYX[7][4] = 0;
        ArrayYX[9][5] = 0;
        ArrayYX[9][6] = 0;
       ArrayYX[9][7] = 0;



        while (!isFull) {
            //isFull = true;
            isFull = dropGems(ArrayYX);

            if(isFull == true){
                isFull = !findMatches(ArrayYX);
            }
        }

        new mainClass(ArrayYX);
    }
}
