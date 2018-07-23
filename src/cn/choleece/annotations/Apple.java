package cn.choleece.annotations;

/**
 * @author choleece
 * @description: cn.choleece.annotations
 * @date 2018/7/20 10:02
 */
public class Apple {
    @FruitName("apple")
    private String appleName;

    @FruitColor(fruitColor = FruitColor.Color.RED)
    private String appleColor;

    public String getAppleName() {
        return appleName;
    }

    public void setAppleName(String appleName) {
        this.appleName = appleName;
    }

    public String getAppleColor() {
        return appleColor;
    }

    public void setAppleColor(String appleColor) {
        this.appleColor = appleColor;
    }

    public void displayName() {
        System.out.println("水果的名字是苹果");
    }

    public static void main(String[] args) {
        Apple apple = new Apple();

        System.out.println(apple.getAppleName() + apple.getAppleColor());
    }
}
