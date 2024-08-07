package telran.range;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BrokenFloorTest {

    private int getMinimalBrokenFloor(BallBrokenFloor bbf) {
        int begin = 0;
        int end = Integer.MAX_VALUE;
        int mid = (begin + end) / 2;

        while (begin <= end) {
            try {
                bbf.checkFloor(mid);
                begin = mid + 1;
            } catch (Exception e) {
                end = mid - 1;
            }
            mid = (begin + end) / 2;
        }
        return begin;
    }

    @Test
    void minimalBrokenFloorTest() {
        int [] floors = {200, 17, 1001, 2000};
        for(int i = 0; i < floors.length; i++) {
            BallBrokenFloor bbf = new BallBrokenFloor(floors[i]);
            assertEquals(bbf.getMinBrokenFloor(), getMinimalBrokenFloor(bbf));
        }
    }
}