package ru.ertelecom.bpms.db;

import ru.ertelecom.bpms.db.utils.Test;
import ru.ertelecom.bpms.db.utils.Test1;
import ru.ertelecom.bpms.db.utils.Test2;


public class BPMDBHelper {
    public static void main(String[] args)
            throws Exception {
        long startTime = System.nanoTime();
        System.out.println("Hola!");
        System.out.println("start time = " + startTime);

        Test1.test();

        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println("run time = " + totalTime / 1000000000 + " seconds");
        System.out.println("That's all folks!");
    }

}
