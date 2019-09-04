package com.javarush.task.task21.task2104;

import java.util.HashSet;
import java.util.Set;

/* 
Equals and HashCode
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Solution)) return false; // if (o == null || o.getClass() != getClass()) return false;

        Solution solution = (Solution) o;

        return (first != null ? first.equals(solution.first) : solution.first == null) && (last != null ? last.equals(solution.last) : solution.last == null);
    }

    public int hashCode() {
        return 31 * ((first != null ? first.hashCode() : 0) + (last != null ? last.hashCode() : 0));
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
        System.out.println(s.contains(new Solution("Donald", "Duck")));
    }
}
