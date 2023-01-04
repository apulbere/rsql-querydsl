package io.github.apulbere.rsqlquerydsl.criteria;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.ComparableExpression;

import java.time.LocalDate;
import java.util.List;

public class LocalDateCriteria extends SearchCriteria<LocalDate> {

    private List<LocalDate> btw;

    public LocalDateCriteria(LocalDate eq) {
        super(eq);
    }

    public LocalDateCriteria() {
        super(null);
    }

    public List<LocalDate> getBtw() {
        return btw;
    }

    public void setBtw(List<LocalDate> btw) {
        this.btw = btw;
    }

    public BooleanBuilder matches(ComparableExpression<LocalDate> expression) {
        BooleanBuilder booleanBuilder = super.match(expression);
        if (btw != null && btw.size() == 2) {
            booleanBuilder.and(expression.between(btw.get(0), btw.get(1)));
        }
        return booleanBuilder;
    }

    public static LocalDateCriteria empty() {
        return new LocalDateCriteria();
    }
}
