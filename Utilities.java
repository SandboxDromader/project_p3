public class Utilities {
    public static int getRandomInteger(int min, int max) {
        return (int)(Math.random() * (max-min+1) + (min - 1));
    }
}