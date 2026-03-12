import java.util.Random;

public class Enums {
    public enum Direction {
        NORTH, SOUTH, EAST, WEST
    }

    public enum Movement {
        NORTH(0, 1),
        NORTHEAST(1, 1),
        EAST(1, 0),
        SOUTHEAST(1, -1),
        SOUTH(0, -1),
        SOUTHWEST(-1, -1),
        WEST(-1, 0),
        NORTHWEST(-1, 1);

        private final int DELTA_X;
        private final int DELTA_Y;

        Movement(int x, int y) {
            DELTA_X = x;
            DELTA_Y = y;
        }

        public int changeX(int x) {
            return x + DELTA_X;
        }

        public int changeY(int y) {
            return y + DELTA_Y;
        }
    }

    public enum NobleGas {
        HELIUM(2,4.003),
        NEON(10, 20.178),
        ARGON(18, 39.948),
        KRYPTON(36, 83.798),
        XENON(54, 131.293),
        RADON(86, 222.018);

        public final int ATOMIC_NUMBER;
        public final double ATOMIC_WEIGHT;

        NobleGas(int number, double weight) {
            ATOMIC_NUMBER = number;
            ATOMIC_WEIGHT = weight;
        }
    }

    public static void main(String[] args) {
        Direction direction = generateDirection();
        if (direction == Direction.EAST) {
            System.out.println("When the East is in the house");
        }

        switch (direction) {
            case NORTH:
                System.out.println("From the Gate of the Kings the North Wind rides");
                break;
            case SOUTH:
                System.out.println("From the mouths of the Sea the South Wind flies");
                break;
            case WEST:
                System.out.println("The West Wind comes walking, and about the walls it goes");
                break;
        }

        for (Direction cardinal : Direction.values()) {
            System.out.println(cardinal.ordinal() + ": " + cardinal);
        }

        Direction heading = Direction.valueOf("WEST");

        int x = 0;
        int y = 0;
        Movement movement = Movement.SOUTHEAST;

        x = movement.changeX(x);
        y = movement.changeY(y);
        System.out.println("x: " + x);
        System.out.println("y: " + y);

        double neonWeight = NobleGas.NEON.ATOMIC_WEIGHT;
        System.out.println(neonWeight);
    }

    public static Direction generateDirection() {
        Random random = new Random();
        return Direction.values()[random.nextInt(Direction.values().length)];
    }
}