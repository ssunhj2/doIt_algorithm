package CH03.exam;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 실습 3-8
 * 신체 데이터 배열에서 이진검색
 */
public class Exam08
{
    static class phyData
    {
        private String name;
        private int height;
        private double vision;

        public phyData(String name, int height, double vision)
        {
            this.name = name;
            this.height = height;
            this.vision = vision;
        }

        public String toString()
        {
            return name + " ," + height + " ," + vision;
        }

        public static final Comparator<phyData> ORDER_HEIGHT = new orderHeightComparator();

        private static class orderHeightComparator implements Comparator<phyData>
        {
            public int compare(phyData phy1, phyData phy2)
            {
                return (phy1.height > phy2.height) ? 1 :
                       (phy1.height < phy2.height) ? -1 : 0;
            }
        }
    }


    public static void main(String[] args)
    {
        phyData[] phyDataArr =
        {
            new phyData("lee gaga", 152, 0.6),
            new phyData("kim nana", 165, 1.2),
            new phyData("sun dada", 170, 0.9),
            new phyData("seo mama", 178, 0.2),
            new phyData("ahn baba", 180, 1.2),
            new phyData("byun sasa", 190, 0.6),
        };

        int searchHeight = 170;

        System.out.println("키가 " + searchHeight + "cm 인 사람을 검색한다.");

        int index = Arrays.binarySearch
        (
            phyDataArr,
            new phyData("", searchHeight, 0.0),
            phyData.ORDER_HEIGHT
        );

        if(index < 0)
        {
            System.out.println("검색값을 찾을 수 없다.");
        }
        else
        {
            System.out.println(searchHeight + " 의 index는 "+index+" 이다.");
            System.out.println("신체 데이터 검색결과: " + phyDataArr[index]);
        }
    }
}
