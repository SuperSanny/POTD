//Leetcode: https://leetcode.com/problems/smallest-sufficient-team/

import java.util.*;
public class SmallestSufficientTeam {
    public static int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        int n = people.size(), m = req_skills.length;
        HashMap<String, Integer> skillId = new HashMap<String, Integer>();
        for (int i = 0; i < m; i++)
            skillId.put(req_skills[i], i);

        int[] skillsMaskOfPerson = new int[n];
        for (int i = 0; i < n; i++)
            for (String skill : people.get(i))
                skillsMaskOfPerson[i] |= 1 << skillId.get(skill);

        long[] dp = new long [1 << m];
        Arrays.fill(dp, (1L << n) - 1);
        dp[0] = 0;
        for (int skillsMask = 1; skillsMask < (1 << m); skillsMask++) {
            for (int i = 0; i < n; i++) {
                int smallerSkillsMask = skillsMask & ~skillsMaskOfPerson[i];
                if (smallerSkillsMask != skillsMask) {
                    long peopleMask = dp[smallerSkillsMask] | (1L << i);
                    if (Long.bitCount(peopleMask) < Long.bitCount(dp[skillsMask]))
                        dp[skillsMask] = peopleMask;
                }
            }
        }
        long answerMask = dp[(1 << m) - 1];
        int ans[] = new int [Long.bitCount(answerMask)];
        int ptr = 0;
        for (int i = 0; i < n; i++) {
            if (((answerMask >> i) & 1) == 1) {
                ans[ptr++] = i;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        String[] req_skills = {"java","nodejs","reactjs"};
        List<List<String>> people = new ArrayList<>();
        people.add(List.of("java"));
        people.add(List.of("nodejs"));
        people.add(Arrays.asList("nodejs", "reactjs"));
        System.out.println(people);
        int[] ans = smallestSufficientTeam(req_skills, people);
        System.out.println(Arrays.toString(ans));
    }
}
