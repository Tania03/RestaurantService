package com.practice;

import javafx.collections.transformation.SortedList;
import sun.jvm.hotspot.utilities.Interval;

import javax.swing.tree.TreeNode;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author tania.gupta
 * @date 16/07/20
 */
public class Test {

    public static void main(String[] args) {

        Map<Integer, List<Integer>> numToIndexMap = new HashMap<>();

        String result = "";

        result.replaceAll("#",String.valueOf(0));

        Set<Integer> set1 = new HashSet<>();

        PriorityQueue<WordCount> queue = new PriorityQueue<>
                ((w1, w2) -> w1.count - w2.count == 0 ? w2.word.compareTo(w1.word) : w1.count - w2.count);

        Object obj1 = new Object();
        Object obj2 = new Object();
        String str1 = new String();
        String str2 = new String();

        System.out.println("Object Check : {} " + obj1.equals(obj2));
        System.out.println("String Check : {} " + str1.equals(str2));

        Map<Integer, Position> map = new TreeMap<>();
        System.out.println(evaluate("0B0"));

        Student st1 = new Student(1, "Tania", 24);
        Student st2 = new Student(2, "GHGH", 24);
        Student st3 = new Student(1, "Tania", 24);

        Set<Student> students = new HashSet<>();

        students.add(st1);
        students.add(st2);
        students.add(st3);

        System.out.println(students.size());

    }

    private static int evaluate(String input) {
        //  1C1B1B0A0
        Stack<Integer> stack = new Stack<>();

        char operation = ' ';
        stack.push(Integer.parseInt(String.valueOf(input.charAt(0))));

        for (int i = 1; i < input.length(); i++) {

            if (input.charAt(i) != '1' && input.charAt(i) != '0') {
                operation = input.charAt(i);
                continue;
            }

            Integer current = Integer.parseInt(String.valueOf(input.charAt(i)));

            if (operation == 'A') {
                stack.push(stack.pop() & current);
            } else if (operation == 'B') {
                stack.push(stack.pop() | current);
            } else if (operation == 'C') {
                stack.push(stack.pop() ^ current);
            }

        }

        return stack.pop();
    }

}

class Key {
    public int hashcode() {
        return 1;
    }
}

class Student {

    int id;
    String name;
    int age;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id &&
                age == student.age &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age);
    }
}

class Position {

    TreeNode node;
    int position;
    int level;

    Position(TreeNode node, int position, int level) {
        this.node = node;
        this.position = position;
        this.level = level;
    }
}


class WordCount {

    String word;
    int count;

    WordCount(String word, int count) {
        this.word = word;
        this.count = count;
    }

}