package CH03.exam;

import CH03.common.Id;

/**
 * 실습 3C-1
 */
public class Exam06
{
    public static void main(String[] args)
    {
        Id id1 = new Id();
        Id id2 = new Id();

        System.out.println("id1의 아이디: " + id1.getId());
        System.out.println("id2의 아이디: " + id2.getId());

        System.out.println("부여한 아이디 개수는 " + Id.getCounter() + "개 이다.");
    }

}
