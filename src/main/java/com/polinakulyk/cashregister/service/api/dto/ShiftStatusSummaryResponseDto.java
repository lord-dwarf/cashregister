package com.polinakulyk.cashregister.service.api.dto;

import com.polinakulyk.cashregister.db.dto.ShiftStatus;

import java.util.StringJoiner;

public class ShiftStatusSummaryResponseDto {

    private ShiftStatus shiftStatus;
    private String shiftStatusElapsedTime;

    public ShiftStatus getShiftStatus() {
        return shiftStatus;
    }

    public ShiftStatusSummaryResponseDto setShiftStatus(ShiftStatus shiftStatus) {
        this.shiftStatus = shiftStatus;
        return this;
    }

    public String getShiftStatusElapsedTime() {
        return shiftStatusElapsedTime;
    }

    public ShiftStatusSummaryResponseDto setShiftStatusElapsedTime(String shiftStatusElapsedTime) {
        this.shiftStatusElapsedTime = shiftStatusElapsedTime;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShiftStatusSummaryResponseDto that = (ShiftStatusSummaryResponseDto) o;

        if (!shiftStatus.equals(that.shiftStatus)) return false;
        return shiftStatusElapsedTime.equals(that.shiftStatusElapsedTime);
    }

    @Override
    public int hashCode() {
        int result = shiftStatus.hashCode();
        result = 31 * result + shiftStatusElapsedTime.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return new StringJoiner(
                ", ", ShiftStatusSummaryResponseDto.class.getSimpleName() + "[", "]")
                .add("shiftStatus='" + shiftStatus + "'")
                .add("shiftStatusElapsedTime='" + shiftStatusElapsedTime + "'")
                .toString();
    }
}
