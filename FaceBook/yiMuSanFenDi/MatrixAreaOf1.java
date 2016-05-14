package yiMuSanFenDi;

import java.util.*;

public class MatrixAreaOf1 {
	public static int matrixArea(int[][] matrix, int x, int y) {
		boolean[][] visited = new boolean[matrix.length][matrix[0].length];
		int[] result = new int[1];
		matrixAreaHelper(matrix, x, y, visited, result, matrix[x][y]);
		return result[0];
	}

	public static void matrixAreaHelper(int[][] matrix, int row, int col, boolean[][] visited, int[] result,
			int sample) {
		if (row < 0 || row > matrix.length - 1)
			return;
		if (col < 0 || col > matrix[0].length - 1)
			return;
		if (visited[row][col])
			return;
		visited[row][col] = true;
		if (matrix[row][col] != sample)
			return;
		result[0]++;
		matrixAreaHelper(matrix, row - 1, col, visited, result, sample);
		matrixAreaHelper(matrix, row + 1, col, visited, result, sample);
		matrixAreaHelper(matrix, row, col - 1, visited, result, sample);
		matrixAreaHelper(matrix, row, col + 1, visited, result, sample);
	}

	public static int matrixAreaII(int[][] matrix, int x, int y) {
		int result = 0;
		Queue<Point> queue = new LinkedList<Point>();
		boolean[][] visited = new boolean[matrix.length][matrix[0].length];
		queue.offer(new Point(x, y));
		while (!queue.isEmpty()) {
			Point point = queue.poll();
			int row = point.x, col = point.y;
			if (visited[point.x][point.y])
				continue;
			visited[point.x][point.y] = true;
			if (matrix[point.x][point.y] != matrix[x][y])
				continue;
			result++;
			if (row > 0)
				queue.offer(new Point(row - 1, col));
			if (row < matrix.length - 1)
				queue.offer(new Point(row + 1, col));
			if (col > 0)
				queue.offer(new Point(row, col - 1));
			if (col < matrix[0].length - 1)
				queue.offer(new Point(row, col + 1));
		}
		return result;
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 0, 1, 0 }, { 0, 0, 0, 1 }, { 1, 1, 1, 1 }, { 1, 0, 0, 1 } };
		System.out.println(matrixArea(matrix, 3, 2));
		System.out.println(matrixAreaII(matrix, 3, 2));
	}
}

class Point {
	public int x;
	public int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}