class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        if (num == null || num.length() == 0)
            return result;

        // Use a StringBuilder for efficient string manipulation
        backtrack(result, new StringBuilder(), num, target, 0, 0, 0);
        return result;
    }

    private void backtrack(List<String> res, StringBuilder path, String num, int target, int index, long currentValue,
            long prevOperand) {
        // Base Case: If we've processed all digits
        if (index == num.length()) {
            if (currentValue == target) {
                res.add(path.toString());
            }
            return;
        }

        for (int i = index; i < num.length(); i++) {
            // Rule: No leading zeros. 
            // If the chunk starts with '0', we can only use '0' itself as a number, not '05'.
            if (i != index && num.charAt(index) == '0')
                break;

            // Extract the current number chunk
            String part = num.substring(index, i + 1);
            long curr = Long.parseLong(part);
            int len = path.length();

            // If it's the very first number in the expression
            if (index == 0) {
                backtrack(res, path.append(curr), num, target, i + 1, curr, curr);
                path.setLength(len); // Backtrack: reset the path length
            } else {
                // Try Addition
                backtrack(res, path.append("+").append(curr), num, target, i + 1, currentValue + curr, curr);
                path.setLength(len);

                // Try Subtraction
                backtrack(res, path.append("-").append(curr), num, target, i + 1, currentValue - curr, -curr);
                path.setLength(len);

                // Try Multiplication (The "Undo" Trick)
                // New value: (Total - Last Number) + (Last Number * Current Number)
                backtrack(res, path.append("*").append(curr), num, target, i + 1,
                        (currentValue - prevOperand) + (prevOperand * curr), prevOperand * curr);
                path.setLength(len);
            }
        }
    }
}