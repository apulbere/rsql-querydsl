package io.github.apulbere.rsqlquerydsl.criteria;

public class DoubleCriteria extends SearchCriteria<Double> {

    public DoubleCriteria(Double eq) {
        super(eq);
    }

    public DoubleCriteria() {
        this(null);
    }

    public static DoubleCriteria empty() {
        return new DoubleCriteria();
    }
}
