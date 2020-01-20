package com.leleplus.dao;

import com.leleplus.bean.StudentAssociateCoach;
import com.leleplus.bean.StudentAssociateCoachExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudentAssociateCoachMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table driver_student_associate_coach
     *
     * @mbg.generated Mon Jan 20 23:27:51 CST 2020
     */
    long countByExample(StudentAssociateCoachExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table driver_student_associate_coach
     *
     * @mbg.generated Mon Jan 20 23:27:51 CST 2020
     */
    int deleteByExample(StudentAssociateCoachExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table driver_student_associate_coach
     *
     * @mbg.generated Mon Jan 20 23:27:51 CST 2020
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table driver_student_associate_coach
     *
     * @mbg.generated Mon Jan 20 23:27:51 CST 2020
     */
    int insert(StudentAssociateCoach record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table driver_student_associate_coach
     *
     * @mbg.generated Mon Jan 20 23:27:51 CST 2020
     */
    int insertSelective(StudentAssociateCoach record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table driver_student_associate_coach
     *
     * @mbg.generated Mon Jan 20 23:27:51 CST 2020
     */
    List<StudentAssociateCoach> selectByExample(StudentAssociateCoachExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table driver_student_associate_coach
     *
     * @mbg.generated Mon Jan 20 23:27:51 CST 2020
     */
    StudentAssociateCoach selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table driver_student_associate_coach
     *
     * @mbg.generated Mon Jan 20 23:27:51 CST 2020
     */
    int updateByExampleSelective(@Param("record") StudentAssociateCoach record, @Param("example") StudentAssociateCoachExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table driver_student_associate_coach
     *
     * @mbg.generated Mon Jan 20 23:27:51 CST 2020
     */
    int updateByExample(@Param("record") StudentAssociateCoach record, @Param("example") StudentAssociateCoachExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table driver_student_associate_coach
     *
     * @mbg.generated Mon Jan 20 23:27:51 CST 2020
     */
    int updateByPrimaryKeySelective(StudentAssociateCoach record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table driver_student_associate_coach
     *
     * @mbg.generated Mon Jan 20 23:27:51 CST 2020
     */
    int updateByPrimaryKey(StudentAssociateCoach record);
}