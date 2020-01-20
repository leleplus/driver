package com.leleplus.bean;

import java.io.Serializable;

public class RfidRecord implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column driver_rfid_record.id
     *
     * @mbg.generated Mon Jan 20 23:27:51 CST 2020
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column driver_rfid_record.user_id
     *
     * @mbg.generated Mon Jan 20 23:27:51 CST 2020
     */
    private Long userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column driver_rfid_record.record_time
     *
     * @mbg.generated Mon Jan 20 23:27:51 CST 2020
     */
    private String recordTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column driver_rfid_record.status
     *
     * @mbg.generated Mon Jan 20 23:27:51 CST 2020
     */
    private String status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column driver_rfid_record.deleted
     *
     * @mbg.generated Mon Jan 20 23:27:51 CST 2020
     */
    private Integer deleted;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table driver_rfid_record
     *
     * @mbg.generated Mon Jan 20 23:27:51 CST 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column driver_rfid_record.id
     *
     * @return the value of driver_rfid_record.id
     *
     * @mbg.generated Mon Jan 20 23:27:51 CST 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column driver_rfid_record.id
     *
     * @param id the value for driver_rfid_record.id
     *
     * @mbg.generated Mon Jan 20 23:27:51 CST 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column driver_rfid_record.user_id
     *
     * @return the value of driver_rfid_record.user_id
     *
     * @mbg.generated Mon Jan 20 23:27:51 CST 2020
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column driver_rfid_record.user_id
     *
     * @param userId the value for driver_rfid_record.user_id
     *
     * @mbg.generated Mon Jan 20 23:27:51 CST 2020
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column driver_rfid_record.record_time
     *
     * @return the value of driver_rfid_record.record_time
     *
     * @mbg.generated Mon Jan 20 23:27:51 CST 2020
     */
    public String getRecordTime() {
        return recordTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column driver_rfid_record.record_time
     *
     * @param recordTime the value for driver_rfid_record.record_time
     *
     * @mbg.generated Mon Jan 20 23:27:51 CST 2020
     */
    public void setRecordTime(String recordTime) {
        this.recordTime = recordTime == null ? null : recordTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column driver_rfid_record.status
     *
     * @return the value of driver_rfid_record.status
     *
     * @mbg.generated Mon Jan 20 23:27:51 CST 2020
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column driver_rfid_record.status
     *
     * @param status the value for driver_rfid_record.status
     *
     * @mbg.generated Mon Jan 20 23:27:51 CST 2020
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column driver_rfid_record.deleted
     *
     * @return the value of driver_rfid_record.deleted
     *
     * @mbg.generated Mon Jan 20 23:27:51 CST 2020
     */
    public Integer getDeleted() {
        return deleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column driver_rfid_record.deleted
     *
     * @param deleted the value for driver_rfid_record.deleted
     *
     * @mbg.generated Mon Jan 20 23:27:51 CST 2020
     */
    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table driver_rfid_record
     *
     * @mbg.generated Mon Jan 20 23:27:51 CST 2020
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", recordTime=").append(recordTime);
        sb.append(", status=").append(status);
        sb.append(", deleted=").append(deleted);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}