public class Methods {
    public int bunnyEars(int bunnies) {
      if (bunnies == 0) {
        return 0;
      }
      return 2 + bunnyEars(bunnies - 1);
    }

    public int triangle(int rows) {
      if (rows == 0) {
        return 0;
      }
      return rows + triangle(rows - 1);
    }

    public boolean strCopies(String str, String sub, int n) {
      if (n == 0) {
        return true;
      }
      if (str.length() < sub.length()) {
        return false;
      }
      if (str.substring(0, sub.length()).equals(sub)) {
        return strCopies(str.substring(1), sub, n - 1);
      }
      return strCopies(str.substring(1), sub, n);
    }

    public int array11(int[] nums, int index) {
      if (index == nums.length) {
        return 0;
      }
      if (nums[index] == 11) {
        return 1 + array11(nums, index + 1);
      }
      return array11(nums, index + 1);
    }

    public int countPairs(String str) {
      if (str.length() <= 2) {
        return 0;
      }
      if (str.charAt(0) == str.charAt(2)) {
        return 1 + countPairs(str.substring(1));
      }
      return countPairs(str.substring(1));
    }

    public boolean groupSum(int start, int[] nums, int target) {
      if (target == 0) {
        return true;
      }
      if (start >= nums.length) {
        return false;
      }
      if (nums[start] > target) {
        return groupSum(start+1, nums, target);
      }
      // Unsure about last part. Return another groupSum? Similar to countPairs?
    }
}
