package org.real.yanolja;

/**
 * 해당 문제는 Inverter 클래스의 invert 메소드를 테스트하기 위한 JUnit 4 프레임워크를 사용한 테스트 스위트를 제공하는 것이 목표입니다. invert 메소드는 문자열을 입력받아 해당 문자열을 반전시킨 문자열을 반환하는 역할을 합니다.
 *
 * 요구사항에 따른 invert 메소드의 동작 설명은 다음과 같습니다:
 *
 * 빈 문자열이 주어지면 빈 문자열을 반환합니다.
 * 메소드의 인자로 null이 전달되면 빈 문자열을 반환합니다.
 * 문자열의 길이가 1인 경우에는 동일한 문자열을 반환합니다.
 * 문자열의 길이가 1보다 큰 경우에는 해당 문자열을 반전시킨 결과를 반환합니다.
 * 주어진 예제에서는 invert 메소드의 사용 예시를 보여주고 있습니다:
 *
 * Inverter.invert("a"); // 결과: "a"
 * Inverter.invert(null); // 결과: ""
 * Inverter.invert("abcd"); // 결과: "dcba"
 * 요구사항에 맞는 invert 메소드의 동작을 테스트하는 JUnit 4를 사용한 테스트 스위트를 작성해야 합니다. invert 메소드의 올바른 동작을 확인하기 위해 여러 구현체를 대상으로 테스트 스위트를 실행할 것입니다. Inverter 클래스나 invert 메소드 자체를 구현할 필요는 없으며, 그 기능을 테스트하는 것에만 집중하면 됩니다.
 *
 * 모든 테스트가 올바르게 통과해야 합니다. 그렇지 않으면 점수가 주어지지 않으므로 올바른 구현에 대해 모든 테스트가 통과하는지 확인한 후에 과제를 제출하시기 바랍니다.
 *
 * JUnit 4에서 제공하는 org.junit.Assert 클래스의 정적 메소드(assertEquals, assertNotEquals 등)를 사용하여 어설션(assertion)을 작성하면 됩니다.
 */

import org.junit.Assert;
import org.junit.Test;

public class yanolja_p2 {

    static class Inverter {
        static String  invert(String input) {
            return "";
        }
    }

    @Test
    public void invert_empty() {
        String input = "";
        String expected = "";
        String actual = Inverter.invert(input);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void invert_Null() {
        String input = null;
        String expected = "";
        String actual = Inverter.invert(input);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void invert_One() {
        String input = "a";
        String expected = "a";
        String actual = Inverter.invert(input);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testInvert_Characters() {
        String input = "abcd";
        String expected = "dcba";
        String actual = Inverter.invert(input);
        Assert.assertEquals(expected, actual);
    }
}
