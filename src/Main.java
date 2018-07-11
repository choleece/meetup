public class Main {

    public static void main(String[] args) {
        int[] nums = {1, 0, 2, 2, 0, 1, 1, 3, 9, 0};

        int[] ints = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        for (int i = 0; i < nums.length; i++) {
            ints[nums[i] % 9] += 1;
        }

        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }

    }
}
