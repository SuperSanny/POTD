//Leetcode: https://leetcode.com/problems/course-schedule/
import java.util.*;
public class CourseSchedule {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegrees = new int[numCourses];
        List<List<Integer>> adjacencyList = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) adjacencyList.add(new ArrayList<>());

        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prerequisiteCourse = prerequisite[1];
            adjacencyList.get(prerequisiteCourse).add(course);
            inDegrees[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegrees[i] == 0) {
                queue.offer(i);
            }
        }

        int count = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            for (int nextCourse : adjacencyList.get(course))
                if (--inDegrees[nextCourse] == 0) queue.offer(nextCourse);

        }
        return count == numCourses;
    }
    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{0, 1}};
        boolean answer =  canFinish(numCourses, prerequisites);
        System.out.println(answer);
    }

}
