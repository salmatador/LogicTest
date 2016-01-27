import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Micah on 1/5/2016.
 */
public class hintClass {


    public hintClass(int[][] myArray){
        int[][] arrayXY = new int[10][10];
        int xLength = 10;
        int yLength = 10;
        Random randomNumber = new Random();
        arrayXY = myArray;
        System.out.println("DOES THIS WORK!");
        for(int y = 0; y < 10; y++){
            for(int x = 0; x < 10; x++) {
                //arrayXY[y][x] = randomNumber.nextInt(7)+1;
                System.out.print(arrayXY[y][x] + ", ");
            }
            System.out.println();

        }

        List<XYLocation> matchList = new ArrayList<>();

        int[] matchesX[];
        int[] matchesY[];

        int matchCount = 0;

        boolean match = false;

        for(int y = 0; y < yLength; y++){
            for(int x = 0; x < xLength; x++){
                if((x+1 < xLength) && arrayXY[y][x]==arrayXY[y][x+1]){
                    //check xxox
                    if((x+3 < xLength) && arrayXY[y][x]==arrayXY[y][x+3]){
                        //matchList.add(new XYLocation(x+3, y, arrayXY[y][x+3]));
                        matchList.add(new XYLocation(x, y, arrayXY[y][x]));
                        matchList.add(new XYLocation(x+1, y, arrayXY[y][x+1]));
                        matchList.add(new XYLocation(x+2, y, arrayXY[y][x+2]));
                        matchList.add(new XYLocation(x+3, y, arrayXY[y][x+3]));

                    }
                    //check xxo
                    //        x
                    if((x+2 < xLength) && (y+1 < yLength) && arrayXY[y][x]==arrayXY[y+1][x+2]){
 //                       matchList.add(new XYLocation(x+2, y+1, arrayXY[y+1][x+2]));
                    }
                    //check   x
                    //      xxo
                    if((x+2 < xLength) && (y-1 >= 0) && arrayXY[y][x]==arrayXY[y-1][x+2]){
   //                     matchList.add(new XYLocation(x+2, y+1, arrayXY[y+1][x+2]));
                    }
                }
                if((x+2 < xLength) && arrayXY[y][x]==arrayXY[y][x+2]){
                    //check xox
                    //       x
                    if((y+1 < yLength) && arrayXY[y][x]==arrayXY[y+1][x+1]){
     //                   matchList.add(new XYLocation(x+1, y+1, arrayXY[y+1][x+1]));
                    }
                    //check  x
                    //      xox
                    if((y-1 >= 0) && arrayXY[y][x]==arrayXY[y-1][x+1]){
       //                 matchList.add(new XYLocation(x+1, y-1, arrayXY[y-1][x+1]));
                    }
                }
//check x to left
                if((x-1 >= 0) && arrayXY[y][x]==arrayXY[y][x-1]){
                    //check xoxx
                    if((x-3 >= 0) && arrayXY[y][x]==arrayXY[y][x-3]){
         //               matchList.add(new XYLocation(x-3, y, arrayXY[y][x-3]));
                    }
                    //check oxx
                    //      x
                    if((x-2 >= 0) && (y+1 < yLength) && arrayXY[y][x]==arrayXY[y+1][x-2]){
           //             matchList.add(new XYLocation(x-2, y+1, arrayXY[y+1][x-2]));
                    }
                    //check x
                    //      oxx
                    if((x-2 >= 0) && (y-1 >= 0) && arrayXY[y][x]==arrayXY[y-1][x-2]){
             //           matchList.add(new XYLocation(x-2, y+1, arrayXY[y+1][x-2]));
                    }
                }
                if((x-2 > 0) && arrayXY[y][x]==arrayXY[y][x-2]){
                    //check xox
                    //       x
                    if((y+1 < yLength) && arrayXY[y][x]==arrayXY[y+1][x-1]){
             //           matchList.add(new XYLocation(x-1, y+1, arrayXY[y+1][x-1]));
                    }
                    //check  x
                    //      xox
                    if((y-1 >= 0) && arrayXY[y][x]==arrayXY[y-1][x-1]){
               //         matchList.add(new XYLocation(x-1, y-1, arrayXY[y-1][x-1]));
                    }
                }
//check y up
                if((y-1 >= 0) && arrayXY[y][x]==arrayXY[y-1][x]){
                    //check x
                    //      o
                    //      x
                    //      x
                    if((y-3 >= 0) && arrayXY[y][x]==arrayXY[y-3][x]){
                 //       matchList.add(new XYLocation(x, y-3, arrayXY[y-3][x]));
                    }
                    //check xo
                    //       x
                    //       x
                    if((y-2 >= 0) && (x-1 >= 0) && arrayXY[y][x]==arrayXY[y-2][x-1]){
                   //     matchList.add(new XYLocation(x-1, y-2, arrayXY[y-2][x-1]));
                    }
                    //check  ox
                    //       x
                    //       x
                    if((y-2 >= 0) && (x+1 < xLength) && arrayXY[y][x]==arrayXY[y-2][x+1]){
                //        matchList.add(new XYLocation(x+1, y-2, arrayXY[y-2][x+1]));
                    }
                }
                if((y-2 >= 0) && arrayXY[y][x]==arrayXY[y-2][x]){
                    //check x
                    //      ox
                    //      x
                    if((x+1 < xLength) && arrayXY[y][x]==arrayXY[y-1][x+1]){
               //         matchList.add(new XYLocation(x+1, y-1, arrayXY[y-1][x+1]));
                    }
                    //check x
                    //     xo
                    //      x
                    if((x-1 >= 0) && arrayXY[y][x]==arrayXY[y-1][x-1]){
               //         matchList.add(new XYLocation(x-1, y-1, arrayXY[y-1][x-1]));
                    }
                }
//check y down
                if((y+1 < yLength) && arrayXY[y][x]==arrayXY[y+1][x]){
                    //check x
                    //      x
                    //      o
                    //      x
                    if((y+3 < yLength) && arrayXY[y][x]==arrayXY[y+3][x]){
            //            matchList.add(new XYLocation(x, y+3, arrayXY[y+3][x]));
                    }
                    //check x
                    //      x
                    //      ox
                    if((y+2 < yLength) && (x+1 < xLength) && arrayXY[y][x]==arrayXY[y+2][x+1]){
           //             matchList.add(new XYLocation(x+1, y+2, arrayXY[y+2][x+1]));
                    }
                    //check x
                    //      x
                    //     xo
                    if((y+2 < xLength) && (x-1 >= 0) && arrayXY[y][x]==arrayXY[y+2][x-1]){
           //             matchList.add(new XYLocation(x-1, y+2, arrayXY[y+2][x-1]));
                    }
                }
                if((y+2 < yLength) && arrayXY[y][x]==arrayXY[y+2][x]){
                    //check x
                    //      ox
                    //      x
                    if((y+1 < yLength) && (x+1 < xLength) && arrayXY[y][x]==arrayXY[y+1][x+1]){
                        matchList.add(new XYLocation(x, y, arrayXY[y][x]));
                        matchList.add(new XYLocation(x, y+1, arrayXY[y+1][x]));
                        matchList.add(new XYLocation(x, y+2, arrayXY[y+2][x]));
                        matchList.add(new XYLocation(x+1, y+1, arrayXY[y+1][x+1]));
                    }
                    //check x
                    //     xo
                    //      x
                    if((y+1 < yLength)&& (x-1 > 0) && arrayXY[y][x]==arrayXY[y+1][x-1]){
                        matchList.add(new XYLocation(x, y, arrayXY[y][x]));
                        matchList.add(new XYLocation(x, y+1, arrayXY[y+1][x]));
                        matchList.add(new XYLocation(x, y+2, arrayXY[y+2][x]));
                        matchList.add(new XYLocation(x-1, y+1, arrayXY[y+1][x-1]));
                    }
                }
            }

    }

        for(int i = 0; i < matchList.size(); i++){
            matchList.get(i).outPut();
        }
}

    private static class XYLocation {
        public int x,y,value;
        public XYLocation(int x, int y,int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }

        public void outPut(){
            System.out.println(x + " , " + y + " = " + value);
        }

        }
    }
