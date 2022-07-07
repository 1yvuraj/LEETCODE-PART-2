class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {        
	int xLo = 0; int xHi = matrix[0].length - 1; // columns
	int yLo = 0; int yHi = matrix.length - 1; // rows

	int sz = (xHi + 1) * (yHi + 1);
	ArrayList<Integer> output = new ArrayList<>(sz);

	boolean onAxis = true; // onAxis = !rowsAndColsSwitched from the pseudocode
	int increment;
	while (output.size() < sz) {
		// take the top row
		increment = (xHi - xLo) > 0 ? 1 : -1; // increment so xLo approaches xHi
		for (int i = xLo; increment * (xHi - i) >= 0 ; i += increment) {
			output.add(onAxis ? matrix[yLo][i] : matrix[i][yLo]); // 
		}

		yLo += (yHi - yLo) > 0 ? 1 : -1; // increment so yLo approaches yHi
		onAxis = !onAxis;

		// swap around
		int tempXLo = xLo;
		int tempXHi = xHi;
		xLo = yLo;
		xHi = yHi;
		yLo = tempXHi;
		yHi = tempXLo;
	}

	return output;
}
}