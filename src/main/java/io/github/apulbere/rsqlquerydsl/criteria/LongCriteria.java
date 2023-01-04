package io.github.apulbere.rsqlquerydsl.criteria;

public class LongCriteria extends SearchCriteria<Long> {

    public LongCriteria(Long eq) {
        super(eq);
    }

    public LongCriteria() {
        super(null);
    }

    public static LongCriteria empty() {
        return new LongCriteria();
    }
}
