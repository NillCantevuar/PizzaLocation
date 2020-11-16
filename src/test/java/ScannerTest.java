import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

class ScannerTest {

    Scanner scanner = new Scanner(2);

    @Test
    public void shouldPerformScanningOnFirst(){
        //given
        Point point = new Point(1,0);
        List<Solit> solitList = new ArrayList<>();
        Solit solit1 = new Solit(new Point(0,0),1);
        Solit solit2 = new Solit(new Point(3,0),7);
        Solit solit3 = new Solit(new Point(5,0),9);
        Solit solit4 = new Solit(new Point(8,0),1);
        solitList.add(solit1);
        solitList.add(solit2);
        solitList.add(solit3);
        solitList.add(solit4);
        //when
        int outcome =  scanner.scanLocation(point,solitList);
        //then
        Assertions.assertEquals(8,outcome);
    }

    @Test
    public void shouldPerformScanningOnFirst_OneDisabled(){
        //given
        Point point = new Point(4,0);
        List<Solit> solitList = new ArrayList<>();
        Solit solit1 = new Solit(new Point(0,0),1);
        solit1.setChecked(true);
        Solit solit2 = new Solit(new Point(3,0),7);
        solit2.setChecked(true);
        Solit solit3 = new Solit(new Point(5,0),9);
        Solit solit4 = new Solit(new Point(8,0),1);
        solitList.add(solit1);
        solitList.add(solit2);
        solitList.add(solit3);
        solitList.add(solit4);
        //when
        int outcome =  scanner.scanLocation(point,solitList);
        //then
        Assertions.assertEquals(9,outcome);
    }

    @Test
    public void shouldPerformScanningOnSet(){
        //given
        List<Point> pointList = new ArrayList<>();
        Point point1 = new Point(1,0);
        Point point2 = new Point(4,0);
        pointList.add(point1);
        pointList.add(point2);

        List<Solit> solitList = new ArrayList<>();
        Solit solit1 = new Solit(new Point(0,0),1);
        Solit solit2 = new Solit(new Point(3,0),7);
        Solit solit3 = new Solit(new Point(5,0),9);
        Solit solit4 = new Solit(new Point(8,0),1);
        solitList.add(solit1);
        solitList.add(solit2);
        solitList.add(solit3);
        solitList.add(solit4);
        //when
        int outcome =  scanner.scanLocationSet(pointList,solitList);
        Assertions.assertEquals(17,outcome);
    }

    @Test
    public void shouldPerformScanningOnSetSeond(){
        //given
        List<Point> pointList = new ArrayList<>();
        Point point1 = new Point(1,0);
        Point point2 = new Point(7,0);
        pointList.add(point1);
        pointList.add(point2);

        List<Solit> solitList = new ArrayList<>();
        Solit solit1 = new Solit(new Point(0,0),1);
        Solit solit2 = new Solit(new Point(3,0),7);
        Solit solit3 = new Solit(new Point(5,0),9);
        Solit solit4 = new Solit(new Point(8,0),1);
        solitList.add(solit1);
        solitList.add(solit2);
        solitList.add(solit3);
        solitList.add(solit4);
        //when
        int outcome =  scanner.scanLocationSet(pointList,solitList);
        Assertions.assertEquals(18,outcome);
    }
    @Test
    public void shouldPerformScanningOnSetThird(){
        //given
        List<Point> pointList = new ArrayList<>();
        Point point1 = new Point(4,0);
        Point point2 = new Point(7,0);
        pointList.add(point1);
        pointList.add(point2);

        List<Solit> solitList = new ArrayList<>();
        Solit solit1 = new Solit(new Point(0,0),1);
        Solit solit2 = new Solit(new Point(3,0),7);
        Solit solit3 = new Solit(new Point(5,0),9);
        Solit solit4 = new Solit(new Point(8,0),1);
        solitList.add(solit1);
        solitList.add(solit2);
        solitList.add(solit3);
        solitList.add(solit4);
        //when
        int outcome =  scanner.scanLocationSet(pointList,solitList);
        Assertions.assertEquals(17,outcome);
    }
    @Test
    public void shouldPerformScanningOnThreeSet(){
        //given
        List<Point> pointList = new ArrayList<>();
        Point point1 = new Point(0,0);
        Point point2 = new Point(1,6);
        Point point3 = new Point(2,3);
        pointList.add(point1);
        pointList.add(point2);
        pointList.add(point3);

        List<Solit> solitList = new ArrayList<>();
        Solit solit1 = new Solit(new Point(0,1),2);
        Solit solit2 = new Solit(new Point(0,5),3);
        Solit solit3 = new Solit(new Point(0,6),1);
        Solit solit4 = new Solit(new Point(1,0),1);
        Solit solit5 = new Solit(new Point(3,2),3);
        Solit solit6 = new Solit(new Point(3,6),2);
        Solit solit7 = new Solit(new Point(6,2),4);
        Solit solit8 = new Solit(new Point(8,6),3);
        solitList.add(solit1);
        solitList.add(solit2);
        solitList.add(solit3);
        solitList.add(solit4);
        solitList.add(solit5);
        solitList.add(solit6);
        solitList.add(solit7);
        solitList.add(solit8);
        //when
        int outcome =  scanner.scanLocationSet(pointList,solitList);
        Assertions.assertEquals(12,outcome);
    }

    @Test
    public void shouldGiveCombinationsFor5to2(){
        //given
        Scanner scanner = new Scanner(2);
        //when
        final List<Integer> integers = scanner.selectNaturalCombinations(2, 5);
        //then
        for (int i :integers
             ) {
            System.out.println(i);
        }

    }

}
