package com.leleplus.bean;

import java.util.ArrayList;
import java.util.List;

public class PracticeExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table driver_practice
     *
     * @mbg.generated Tue Jan 21 23:08:34 CST 2020
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table driver_practice
     *
     * @mbg.generated Tue Jan 21 23:08:34 CST 2020
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table driver_practice
     *
     * @mbg.generated Tue Jan 21 23:08:34 CST 2020
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table driver_practice
     *
     * @mbg.generated Tue Jan 21 23:08:34 CST 2020
     */
    public PracticeExample() {
        oredCriteria = new ArrayList<>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table driver_practice
     *
     * @mbg.generated Tue Jan 21 23:08:34 CST 2020
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table driver_practice
     *
     * @mbg.generated Tue Jan 21 23:08:34 CST 2020
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table driver_practice
     *
     * @mbg.generated Tue Jan 21 23:08:34 CST 2020
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table driver_practice
     *
     * @mbg.generated Tue Jan 21 23:08:34 CST 2020
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table driver_practice
     *
     * @mbg.generated Tue Jan 21 23:08:34 CST 2020
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table driver_practice
     *
     * @mbg.generated Tue Jan 21 23:08:34 CST 2020
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table driver_practice
     *
     * @mbg.generated Tue Jan 21 23:08:34 CST 2020
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table driver_practice
     *
     * @mbg.generated Tue Jan 21 23:08:34 CST 2020
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table driver_practice
     *
     * @mbg.generated Tue Jan 21 23:08:34 CST 2020
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table driver_practice
     *
     * @mbg.generated Tue Jan 21 23:08:34 CST 2020
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table driver_practice
     *
     * @mbg.generated Tue Jan 21 23:08:34 CST 2020
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andStudentArchiveIdIsNull() {
            addCriterion("student_archive_id is null");
            return (Criteria) this;
        }

        public Criteria andStudentArchiveIdIsNotNull() {
            addCriterion("student_archive_id is not null");
            return (Criteria) this;
        }

        public Criteria andStudentArchiveIdEqualTo(Long value) {
            addCriterion("student_archive_id =", value, "studentArchiveId");
            return (Criteria) this;
        }

        public Criteria andStudentArchiveIdNotEqualTo(Long value) {
            addCriterion("student_archive_id <>", value, "studentArchiveId");
            return (Criteria) this;
        }

        public Criteria andStudentArchiveIdGreaterThan(Long value) {
            addCriterion("student_archive_id >", value, "studentArchiveId");
            return (Criteria) this;
        }

        public Criteria andStudentArchiveIdGreaterThanOrEqualTo(Long value) {
            addCriterion("student_archive_id >=", value, "studentArchiveId");
            return (Criteria) this;
        }

        public Criteria andStudentArchiveIdLessThan(Long value) {
            addCriterion("student_archive_id <", value, "studentArchiveId");
            return (Criteria) this;
        }

        public Criteria andStudentArchiveIdLessThanOrEqualTo(Long value) {
            addCriterion("student_archive_id <=", value, "studentArchiveId");
            return (Criteria) this;
        }

        public Criteria andStudentArchiveIdIn(List<Long> values) {
            addCriterion("student_archive_id in", values, "studentArchiveId");
            return (Criteria) this;
        }

        public Criteria andStudentArchiveIdNotIn(List<Long> values) {
            addCriterion("student_archive_id not in", values, "studentArchiveId");
            return (Criteria) this;
        }

        public Criteria andStudentArchiveIdBetween(Long value1, Long value2) {
            addCriterion("student_archive_id between", value1, value2, "studentArchiveId");
            return (Criteria) this;
        }

        public Criteria andStudentArchiveIdNotBetween(Long value1, Long value2) {
            addCriterion("student_archive_id not between", value1, value2, "studentArchiveId");
            return (Criteria) this;
        }

        public Criteria andPracticeTimeIsNull() {
            addCriterion("practice_time is null");
            return (Criteria) this;
        }

        public Criteria andPracticeTimeIsNotNull() {
            addCriterion("practice_time is not null");
            return (Criteria) this;
        }

        public Criteria andPracticeTimeEqualTo(Long value) {
            addCriterion("practice_time =", value, "practiceTime");
            return (Criteria) this;
        }

        public Criteria andPracticeTimeNotEqualTo(Long value) {
            addCriterion("practice_time <>", value, "practiceTime");
            return (Criteria) this;
        }

        public Criteria andPracticeTimeGreaterThan(Long value) {
            addCriterion("practice_time >", value, "practiceTime");
            return (Criteria) this;
        }

        public Criteria andPracticeTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("practice_time >=", value, "practiceTime");
            return (Criteria) this;
        }

        public Criteria andPracticeTimeLessThan(Long value) {
            addCriterion("practice_time <", value, "practiceTime");
            return (Criteria) this;
        }

        public Criteria andPracticeTimeLessThanOrEqualTo(Long value) {
            addCriterion("practice_time <=", value, "practiceTime");
            return (Criteria) this;
        }

        public Criteria andPracticeTimeIn(List<Long> values) {
            addCriterion("practice_time in", values, "practiceTime");
            return (Criteria) this;
        }

        public Criteria andPracticeTimeNotIn(List<Long> values) {
            addCriterion("practice_time not in", values, "practiceTime");
            return (Criteria) this;
        }

        public Criteria andPracticeTimeBetween(Long value1, Long value2) {
            addCriterion("practice_time between", value1, value2, "practiceTime");
            return (Criteria) this;
        }

        public Criteria andPracticeTimeNotBetween(Long value1, Long value2) {
            addCriterion("practice_time not between", value1, value2, "practiceTime");
            return (Criteria) this;
        }

        public Criteria andPracticeTypeIsNull() {
            addCriterion("practice_type is null");
            return (Criteria) this;
        }

        public Criteria andPracticeTypeIsNotNull() {
            addCriterion("practice_type is not null");
            return (Criteria) this;
        }

        public Criteria andPracticeTypeEqualTo(String value) {
            addCriterion("practice_type =", value, "practiceType");
            return (Criteria) this;
        }

        public Criteria andPracticeTypeNotEqualTo(String value) {
            addCriterion("practice_type <>", value, "practiceType");
            return (Criteria) this;
        }

        public Criteria andPracticeTypeGreaterThan(String value) {
            addCriterion("practice_type >", value, "practiceType");
            return (Criteria) this;
        }

        public Criteria andPracticeTypeGreaterThanOrEqualTo(String value) {
            addCriterion("practice_type >=", value, "practiceType");
            return (Criteria) this;
        }

        public Criteria andPracticeTypeLessThan(String value) {
            addCriterion("practice_type <", value, "practiceType");
            return (Criteria) this;
        }

        public Criteria andPracticeTypeLessThanOrEqualTo(String value) {
            addCriterion("practice_type <=", value, "practiceType");
            return (Criteria) this;
        }

        public Criteria andPracticeTypeLike(String value) {
            addCriterion("practice_type like", value, "practiceType");
            return (Criteria) this;
        }

        public Criteria andPracticeTypeNotLike(String value) {
            addCriterion("practice_type not like", value, "practiceType");
            return (Criteria) this;
        }

        public Criteria andPracticeTypeIn(List<String> values) {
            addCriterion("practice_type in", values, "practiceType");
            return (Criteria) this;
        }

        public Criteria andPracticeTypeNotIn(List<String> values) {
            addCriterion("practice_type not in", values, "practiceType");
            return (Criteria) this;
        }

        public Criteria andPracticeTypeBetween(String value1, String value2) {
            addCriterion("practice_type between", value1, value2, "practiceType");
            return (Criteria) this;
        }

        public Criteria andPracticeTypeNotBetween(String value1, String value2) {
            addCriterion("practice_type not between", value1, value2, "practiceType");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table driver_practice
     *
     * @mbg.generated do_not_delete_during_merge Tue Jan 21 23:08:34 CST 2020
     */
    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table driver_practice
     *
     * @mbg.generated Tue Jan 21 23:08:34 CST 2020
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}