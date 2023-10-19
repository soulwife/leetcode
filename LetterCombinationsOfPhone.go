func letterCombinations(digits string) []string {
	if len(digits) == 0 {
		return []string{}
	}

	output, index, cur := []string{}, 0, ""
	hash := map[byte]string{
		'2': "abc",
		'3': "def",
		'4': "ghi",
		'5': "jkl",
		'6': "mno",
		'7': "pqrs",
		'8': "tuv",
		'9': "wxyz",
	}
	backtrack(hash, &output, digits, cur, index)
	return output
}

func backtrack(hash map[byte]string, output *[]string, digits string, cur string, index int) {
	if index > len(digits) {
		return
	}

	if len(cur) == len(digits) {
		*output = append(*output, cur)
		return
	}

	symbols := hash[digits[index]]
	for _, v := range symbols {
		cur += string(v)
		backtrack(hash, output, digits, cur, index+1)
		cur = cur[:len(cur)-1]
	}
}
