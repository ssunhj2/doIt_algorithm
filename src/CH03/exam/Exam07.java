package CH03.exam;

import CH03.common.Id;

import java.util.Arrays;

/**
 * 실습 3-6
 * 문자열의 배열에서 원하는 text를 검색한다.
 */
public class Exam07
{
    public static void main(String[] args)
    {
        String searchText = "new";

        String[] javaArray =
        {
            "abstract",   "assert",       "boolean",   "break",      "byte",
            "case",       "catch",        "char",      "class",      "const",
            "continue",   "default",      "do",        "double",     "else",
            "enum",       "extends",      "final",     "finally",    "float",
            "for",        "goto",         "if",        "implements", "import",
            "instanceof", "int",          "interface", "long",       "native",
            "new",        "package",      "private",   "protected",  "public",
            "return",     "short",        "static",    "strictfp",   "super",
            "switch",     "synchronized", "this",      "throw",      "throws",
            "transient",  "try",          "void",      "volatile",   "while"
        };

        int index = Arrays.binarySearch(javaArray, searchText);

        if(index < 0)
        {
            System.out.println("검색값을 찾을 수 없다.");
        }
        else
        {
            System.out.println(searchText + " 의 index는 "+index+" 이다.");
        }
    }
}
