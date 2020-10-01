package com.medium;

/**
 * @author tania.gupta
 * @date 24/06/20
 */

enum Status {

    VISITED, VISITING, UNVISITED;

}

public class CourseSchedule {

    public static void main(String args[]) {

        int courses = 2;

        int prerequisites[][] = new int[][]{{1, 0}};

        CourseSchedule courseSchedule = new CourseSchedule();
        courseSchedule.canFinish(courses, prerequisites);

    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Graph g = new Graph(numCourses, prerequisites);

        Status[] visited = new Status[numCourses];

        for (int i = 0; i < numCourses; i++)
            visited[i] = Status.UNVISITED;

        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == Status.UNVISITED && !dfs(g, i, visited))
                return false;
        }
        return true;
    }

    private boolean dfs(Graph g, int i, Status[] visited) {

        if (visited[i] == Status.VISITING)
            return false;

        visited[i] = Status.VISITING;

        for (Integer vertice : g.edges[i]) {
            if (!dfs(g, vertice, visited))
                return false;
        }

        visited[i] = Status.VISITED;

        return true;
    }
}
