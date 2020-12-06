package com.mrtk.reportrepair;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;

public class ReportRepair {

    public static void main(String[] args) {

        String path = new File(ReportRepair.class.getResource("/report.txt")
                .getFile()).getPath();
        try {
            int[] report = ReportReader.readReport(path);
            System.out.println(findTwoEntriesAndGetMultiplication(report));
            System.out.println(findThreeEntriesAndGetMultiplication(report));
        } catch (IOException ex) {
            // TODO
        }
    }

    public static int findTwoEntriesAndGetMultiplication(int[] expenseReport) {
        HashSet<Integer> entries = new HashSet<>(expenseReport.length);
        for (int i = 0; i < expenseReport.length; i++) {
            int entry = expenseReport[i];
            if (entries.contains(entry)) {
                return entry * (2020 - entry);
            }
            entries.add(2020 - entry);
        }
        return -1;
    }

//    public static int findTwoEntriesAndGetMultiplication(int[] expenseReport) {
//        Arrays.sort(expenseReport);
//        return findTwoEntries(expenseReport, 0, expenseReport.length - 1);
//    }

//    private static int findTwoEntries(int[] expenseReport, int firstIndex, int secondIndex) {
//        int firstExpense = expenseReport[firstIndex];
//        int secondExpense = expenseReport[secondIndex];
//        if (firstExpense + secondExpense == 2020) {
//            return firstExpense * secondExpense;
//        }
//        return (firstExpense + secondExpense > 2020)
//                ? findTwoEntries(expenseReport, firstIndex, secondIndex - 1)
//                : findTwoEntries(expenseReport, firstIndex + 1, secondIndex);
//    }

    public static int findThreeEntriesAndGetMultiplication(int[] expenseReport) {
        Arrays.sort(expenseReport);
        int i = 0;
        int j = 1;
        int k = expenseReport.length - 1;
        while (i < expenseReport.length / 2) {
            while (j < k) {
                if (expenseReport[i] + expenseReport[j] + expenseReport[k] == 2020) {
                    return expenseReport[i] * expenseReport[j] * expenseReport[k];
                }
                if (expenseReport[i] + expenseReport[j] + expenseReport[k] > 2020) {
                    k--;
                } else {
                    j++;
                }
            }
            i++;
            j = i + 1;
            k = expenseReport.length - 1;
        }
        return -1;
    }

//    public static int findThreeEntriesAndGetMultiplication(int[] expenseReport) {
//        Arrays.sort(expenseReport);
//        return findThreeEntries(expenseReport, 0, 1, expenseReport.length - 1);
//    }
//
//    private static int findThreeEntries(int[] expenseReport, int firstIndex, int secondIndex, int thirdIndex) {
//        int firstEntry = expenseReport[firstIndex];
//        int secondEntry = expenseReport[secondIndex];
//        int thirdEntry = expenseReport[thirdIndex];
//        if (firstEntry + secondEntry + thirdEntry == 2020) {
//            return firstEntry * secondEntry * thirdEntry;
//        }
//        if (firstEntry + secondEntry + thirdEntry > 2020) {
//            return findThreeEntries(expenseReport, firstIndex, secondIndex, thirdIndex - 1);
//        }
//        if (secondEntry + 1 < thirdEntry) {
//            return findThreeEntries(expenseReport, firstIndex, secondIndex + 1, thirdIndex);
//        }
//        return findThreeEntries(expenseReport, firstIndex + 1, secondIndex, thirdIndex);
//    }
}