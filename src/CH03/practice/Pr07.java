package CH03.practice;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 시력에 대해 내림차순으로 정렬 된 신체 데이터 배열에서 특정 시력을 가진사람울 검색한다.
 */
public class Pr07
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

        public static final Comparator<phyData> ORDER_VISION = new orderVisionComparator();

        private static class orderVisionComparator implements Comparator<phyData>
        {
            public int compare(phyData phy1, phyData phy2)
            {
                return (phy1.vision < phy2.vision) ? 1 :
                       (phy1.vision > phy2.vision) ? -1 : 0;
            }
        }
    }


    public static void main(String[] args)
    {
        phyData[] phyDataArr =
        {
            new phyData("lee gaga", 152, 1.2),
            new phyData("kim nana", 165, 1.0),
            new phyData("sun dada", 170, 0.9),
            new phyData("seo mama", 178, 0.7),
            new phyData("ahn baba", 180, 0.5),
            new phyData("byun sasa", 190, 0.3),
        };

        double searchVision = 0.5;

        System.out.println("시력이 " + searchVision + "인 사람을 검색한다.");

        int index = Arrays.binarySearch
        (
            phyDataArr,
            new phyData("", 0, searchVision),
            phyData.ORDER_VISION
        );

        if(index < 0)
        {
            System.out.println("검색값을 찾을 수 없다.");
        }
        else
        {
            System.out.println(searchVision + " 의 index는 "+index+" 이다.");
            System.out.println("신체 데이터 검색결과: " + phyDataArr[index]);
        }
    }
}
