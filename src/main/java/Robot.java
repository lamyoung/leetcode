import java.util.HashSet;

public class Robot {

	public static void main(String[] args) {
		String command = "RRU";
		int[][] obstacles = { { 9,4 }};
		int x = 1486;
		int y = 743;
		System.out.println(robot(command, obstacles, x, y));
	}

	public static boolean robot(String command, int[][] obstacles, int x, int y) {
		int rightStep = 0;
		for (int commandCount = 0; commandCount < command.length(); commandCount++) {
			if ('R' == command.charAt(commandCount)) {
				rightStep++;
			}
		}
		int minSize;
		if(rightStep == 0) {
			minSize = y / command.length();
		} else if(rightStep == command.length()) {
			minSize = x / rightStep;
		} else {
			minSize = Math.min(x / rightStep, y / (command.length() - rightStep));
		}
		int newX = x- minSize * rightStep;
		int newY = y- minSize * (command.length() - rightStep);
		int xPos = 0, yPos = 0;
		HashSet<String> obstaclesSet = getObstaclesPos(rightStep, command, obstacles, x, y);
		for (int i = 0; i < command.length(); i++) {
			String res = new StringBuilder().append(xPos).append(",").append(yPos).toString();
			if (obstaclesSet.contains(res)) {
				return false;
			}
			if (xPos == newX && yPos == newY) {
				return true;
			}
			if ('R' == command.charAt(i)) {
				xPos++;
			} else {
				yPos++;
			}
		}
		if(newX==0 && newY==0) {
			return true;
		} else {
			return false;
		}
	}

	public static HashSet<String> getObstaclesPos(int rightStep, String command, int[][] obstacles, int x, int y) {

		HashSet<String> obstaclesSet = new HashSet<>();
		for (int obstaclesCount = 0; obstaclesCount < obstacles.length; obstaclesCount++) {
			if(obstacles[obstaclesCount][0]>x || obstacles[obstaclesCount][1]>y) {
				continue;
			}
			int minSize;
			if(rightStep == 0) {
				minSize = obstacles[obstaclesCount][1] / command.length();
			} else if(rightStep == command.length()) {
				minSize = obstacles[obstaclesCount][0] / rightStep;
			} else {
				minSize = Math.min(obstacles[obstaclesCount][0] / rightStep, obstacles[obstaclesCount][1] / (command.length() - rightStep));
			}
			obstaclesSet.add(new StringBuilder().append(obstacles[obstaclesCount][0] - minSize * rightStep)
					.append(",")
					.append(obstacles[obstaclesCount][1] - minSize * (command.length() - rightStep)).toString());
		}
		return obstaclesSet;
	}
}
