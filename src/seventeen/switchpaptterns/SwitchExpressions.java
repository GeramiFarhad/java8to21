package seventeen.switchpaptterns;

enum Direction {NORTH, SOUTH, EAST, WEST}

public class SwitchExpressions {
    public static void main(String[] args) {
        Direction d = Direction.NORTH;

        int numLetters = 0;
        switch (d) {
            case NORTH:
            case SOUTH:
                numLetters = 5;
                break;
            case EAST:
            case WEST:
                numLetters = 4;
                break;
        }

        System.out.println(numLetters);

// in switch expressions there should be a default
// switch expressions can be used in other code blocks
// i.e. in System.out.println
// because they yield or use arrow functions
// in other words switch expressions can have return values
        System.out.println(
                switch (d) {
// when you use arrow (->) there is no need for YIELD
//                    case NORTH, SOUTH -> 5;
//                    default -> 4;

// when you use colon (:) you use YIELD. it means the output and break
                    case NORTH, SOUTH:
                        yield 5;
                    default:
                        yield 4;
                }
        );

    }
}
