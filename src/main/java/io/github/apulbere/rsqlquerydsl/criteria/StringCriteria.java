package io.github.apulbere.rsqlquerydsl.criteria;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.StringExpression;

public class StringCriteria extends SearchCriteria<String> {

    private String like;

    public StringCriteria() {
        super(null);
    }

    public StringCriteria(String eq) {
        super(eq);
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }

    public BooleanBuilder match(StringExpression path) {
        BooleanBuilder booleanBuilder = super.match(path);
        if (like != null) {
            booleanBuilder.and(path.likeIgnoreCase("%" + like + "%"));
        }
        return booleanBuilder;
    }

    public static StringCriteria empty() {
        return new StringCriteria();
    }
}
