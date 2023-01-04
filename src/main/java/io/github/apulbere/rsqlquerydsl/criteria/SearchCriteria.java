package io.github.apulbere.rsqlquerydsl.criteria;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.SimpleExpression;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * Class holding common search operation available for all types of data.
 *
 * @param <T> value type
 */
public abstract class SearchCriteria<T> {

    protected List<T> in;
    protected T eq;
    protected T ne;

    public SearchCriteria(T eq) {
        this.eq = eq;
    }

    public List<T> getIn() {
        return in;
    }

    public void setIn(List<T> in) {
        this.in = in;
    }

    public T getEq() {
        return eq;
    }

    public void setEq(T eq) {
        this.eq = eq;
    }

    public T getNe() {
        return ne;
    }

    public void setNe(T ne) {
        this.ne = ne;
    }

    /**
     * Build an empty predicate or with some criteria depending on
     * how the object was populated.
     *
     * @param path entity path field
     * @return predicate to be used in WHERE
     */
    public BooleanBuilder match(SimpleExpression<T> path) {
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        if (in != null) {
            booleanBuilder.and(path.in(in));
        }
        if (eq != null) {
            booleanBuilder.and(path.eq(eq));
        }

        if (ne != null) {
            booleanBuilder.and(path.ne(ne));
        }
        return booleanBuilder;
    }

    /**
     * If any operator on this object is set then a composite
     * predicate will be returned else an empty one.
     *
     * @param predicate for composition
     * @return composite of two predicates or empty one
     */
    public BooleanBuilder exists(Predicate predicate) {
        BooleanBuilder builder = new BooleanBuilder();
        if (Stream.of(in, eq, ne).anyMatch(Objects::nonNull)) {
            builder.and(predicate);
        }
        return builder;
    }


}
