
// Given an integer numRows, return the first numRows of Pascal's triangle.

// In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:


 

// Example 1:

// Input: numRows = 5
// Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
// Example 2:

// Input: numRows = 1
// Output: [[1]]
 

// Constraints:

// 1 <= numRows <= 30

func generate(numRows int) [][]int {
    if numRows == 0 {
			return make([][]int, 0)
		}
		var retVal[][]int
		numberOne := 1
		retVal = append(retVal, []int{numberOne})
		for i:=1; i<numRows; i++ {
			var row []int
			row = append(row, numberOne)
			lastRow := retVal[i-1]

			for j:=0; j<i-1; j++ {
				row = append(row, lastRow[j]+lastRow[j+1])
			}

			row = append(row, numberOne)
			retVal = append(retVal, row)
		}

		return retVal
}
