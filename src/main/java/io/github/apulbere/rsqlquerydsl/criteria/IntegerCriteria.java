package io.github.apulbere.rsqlquerydsl.criteria;

public class IntegerCriteria extends SearchCriteria<Integer> {

    public IntegerCriteria(Integer eq) {
        super(eq);
    }

    public IntegerCriteria() {
        this(null);
    }

    public static IntegerCriteria empty() {
        return new IntegerCriteria();
    }
}
