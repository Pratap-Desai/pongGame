package looping;

public class MazeSolver {
    static char maze[][] = {{'.','.','.','.','.','#','#','.','.','.'},
                            {'#','#','.','#','.','.','.','.','#','.'},
                            {'#','#','.','#','.','#','#','#','#','.'},
                            {'#','#','.','#','.','#','#','#','#','.'},
                            {'.','.','.','#','.','.','.','#','#','.'},
                            {'.','#','.','#','.','#','.','#','#','.'},
                            {'.','.','#','.','.','#','.','.','#','.'},
                            {'#','.','#','#','.','#','.','#','#','.'},
                            {'#','.','.','#','.','#','.','#','#','.'},
                            {'#','#','#','#','.','#','.','#','#','.'}};
    
    public static boolean solve(int x, int y) {
    	System.out.println(x + " " + y);
        if (x < 0 || y < 0 || x > 9 || y > 9) {
            return false;
        }
        if (x == 9 && y == 9) {
            return true;
        }
        if (maze[x][y] == '#' || maze[x][y] == '+') {
            return false;
        }
        maze[x][y] = '+';
        if (solve(x + 1, y)) {
            return true;
        }
        if (solve(x - 1, y)) {
            return true;
        }
        if (solve(x, y - 1)) {
            return true;
        }
        if (solve(x, y + 1)) {
            return true;
        }
        maze[x][y] = '.';
        return false;
    }
    
    public static void main(String args[]) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }
        solve(0, 0);
    }
}
