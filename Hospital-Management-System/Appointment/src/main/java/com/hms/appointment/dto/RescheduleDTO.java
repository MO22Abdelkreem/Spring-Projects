package com.hms.appointment.dto;

import java.time.LocalDateTime;

public class RescheduleDTO {
    private LocalDateTime newDateTime;

    public RescheduleDTO() {}

    public RescheduleDTO(LocalDateTime newDateTime) {
        this.newDateTime = newDateTime;
    }

    public LocalDateTime getNewDateTime() {
        return newDateTime;
    }

    public void setNewDateTime(LocalDateTime newDateTime) {
        this.newDateTime = newDateTime;
    }
}