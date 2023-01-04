package io.github.apulbere.rsqlquerydsl.criteria;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.ComparableExpression;

import java.time.LocalDateTime;
import java.util.List;

public class LocalDateTimeCriteria extends SearchCriteria<LocalDateTime> {

    private List<LocalDateTime> btw;

    public LocalDateTimeCriteria(LocalDateTime eq) {
        super(eq);
    }

    public LocalDateTimeCriteria() {
        this(null);
    }

    public List<LocalDateTime> getBtw() {
        return btw;
    }

    public void setBtw(List<LocalDateTime> btw) {
        this.btw = btw;
    }

    public BooleanBuilder matches(ComparableExpression<LocalDateTime> expression) {
        BooleanBuilder booleanBuilder = super.match(expression);
        if (btw != null && btw.size() == 2) {
            booleanBuilder.and(expression.between(btw.get(0), btw.get(1)));
        }
        return booleanBuilder;
    }

    public static LocalDateTimeCriteria empty() {
        return new LocalDateTimeCriteria();
    }
}
