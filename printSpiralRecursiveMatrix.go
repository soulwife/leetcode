func printSpiralRecursive(matrix [][]int) {
	printSpiralRecursiveHelper(matrix, 0, len(matrix)-1, 0, len(matrix[0])-1)
}

func printSpiralRecursiveHelper(matrix [][]int, top, bottom, left, right int) {
	if top > bottom || left > right {
		return
	}

	for i := left; i <= right; i++ {
		fmt.Print(matrix[top][i], " ")
	}
	top++

	for i := top; i <= bottom; i++ {
		fmt.Print(matrix[i][right], " ")
	}
	right--

	if top <= bottom {
		for i := right; i >= left; i-- {
			fmt.Print(matrix[bottom][i], " ")
		}
		bottom--
	}

	if left <= right {
		for i := bottom; i >= top; i-- {
			fmt.Print(matrix[i][left], " ")
		}
		left++
	}

	printSpiralRecursiveHelper(matrix, top, bottom, left, right)
}
