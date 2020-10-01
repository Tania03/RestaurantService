import com.practice.CharListNode;
import com.practice.ReverseEachWord;
import org.junit.Assert;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * @author tania.gupta
 * @date 01/07/20
 */
public class TestReverseEachWord {

    private ReverseEachWord reverseEachWord;

    @Test
    public void test1() {
        reverseEachWord = new ReverseEachWord();

        CharListNode tail1 = new CharListNode('u', null);
        CharListNode tail2 = new CharListNode('o', tail1);
        CharListNode tail3 = new CharListNode('y', tail2);
        CharListNode tail4 = new CharListNode(' ', tail3);
        CharListNode tail5 = new CharListNode('e', tail4);
        CharListNode tail6 = new CharListNode('r', tail5);
        CharListNode tail7 = new CharListNode('a', tail6);
        CharListNode tail8 = new CharListNode(' ', tail7);
        CharListNode tail9 = new CharListNode('w', tail8);
        CharListNode tail10 = new CharListNode('o', tail9);
        CharListNode head = new CharListNode('h', tail10);
        CharListNode newHead = reverseEachWord.getReversedLinkedList(head);

        Assert.assertEquals(newHead.getVal(), Character.valueOf('w'));
    }
}
