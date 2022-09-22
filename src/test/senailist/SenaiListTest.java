package test.senailist;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import senailist.SenaiList;
import senailist.SenaiListCompare;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Timer;

import static org.junit.Assert.*;

@RunWith(Enclosed.class)
public class SenaiListTest {

    public static class Constructor {

        @Test
        public void withoutParameters() {

            List<String> senaiList = new SenaiList<>();
            long senaiListInitialTimer = System.currentTimeMillis();
            for (int i = 0; i < 1000000; i++) {
                senaiList.add(i + "");
            }
            long senaiListFinalTimer = System.currentTimeMillis();
            System.out.println(senaiListFinalTimer - senaiListInitialTimer);

            List<String> senaiListCompare = new SenaiListCompare<>();
            long senaiListCompareInitialTimer = System.currentTimeMillis();
            for (int i = 0; i < 1000000; i++) {
                senaiListCompare.add(i + "");
            }
            long senaiListCompareFinalTimer = System.currentTimeMillis();
            System.out.println(senaiListCompareFinalTimer - senaiListCompareInitialTimer);

        }

    }

}