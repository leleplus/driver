package com.leleplus.dao;

import com.leleplus.bean.RfidRecord;
import com.leleplus.bean.RfidRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RfidRecordMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table driver_rfid_record
     *
     * @mbg.generated Tue Jan 21 23:08:34 CST 2020
     */
    long countByExample(RfidRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table driver_rfid_record
     *
     * @mbg.generated Tue Jan 21 23:08:34 CST 2020
     */
    int deleteByExample(RfidRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table driver_rfid_record
     *
     * @mbg.generated Tue Jan 21 23:08:34 CST 2020
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table driver_rfid_record
     *
     * @mbg.generated Tue Jan 21 23:08:34 CST 2020
     */
    int insert(RfidRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table driver_rfid_record
     *
     * @mbg.generated Tue Jan 21 23:08:34 CST 2020
     */
    int insertSelective(RfidRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table driver_rfid_record
     *
     * @mbg.generated Tue Jan 21 23:08:34 CST 2020
     */
    List<RfidRecord> selectByExample(RfidRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table driver_rfid_record
     *
     * @mbg.generated Tue Jan 21 23:08:34 CST 2020
     */
    RfidRecord selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table driver_rfid_record
     *
     * @mbg.generated Tue Jan 21 23:08:34 CST 2020
     */
    int updateByExampleSelective(@Param("record") RfidRecord record, @Param("example") RfidRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table driver_rfid_record
     *
     * @mbg.generated Tue Jan 21 23:08:34 CST 2020
     */
    int updateByExample(@Param("record") RfidRecord record, @Param("example") RfidRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table driver_rfid_record
     *
     * @mbg.generated Tue Jan 21 23:08:34 CST 2020
     */
    int updateByPrimaryKeySelective(RfidRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table driver_rfid_record
     *
     * @mbg.generated Tue Jan 21 23:08:34 CST 2020
     */
    int updateByPrimaryKey(RfidRecord record);
}