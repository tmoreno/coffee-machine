package com.tmoreno.kata.coffeemachine.report;

import java.math.BigDecimal;
import java.util.Objects;

public final class Report {

    private final int teaSold;
    private final int coffeeSold;
    private final int chocolateSold;
    private final int orangeSold;
    private final BigDecimal totalEarned;

    public Report(
        int teaSold,
        int coffeeSold,
        int chocolateSold,
        int orangeSold,
        BigDecimal totalEarned
    ) {
        this.teaSold = teaSold;
        this.coffeeSold = coffeeSold;
        this.chocolateSold = chocolateSold;
        this.orangeSold = orangeSold;
        this.totalEarned = totalEarned;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Report report = (Report) o;

        return teaSold == report.teaSold
                && coffeeSold == report.coffeeSold
                && chocolateSold == report.chocolateSold
                && orangeSold == report.orangeSold
                && totalEarned.equals(report.totalEarned);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teaSold, coffeeSold, chocolateSold, orangeSold, totalEarned);
    }
}
