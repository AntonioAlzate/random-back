package com.co.sofka.random.dtos;

import java.time.LocalDateTime;

public class RandomDTO {

    private String id;

    private LocalDateTime dateTime;

    private Integer min;

    private Integer max;

    private String originalList;

    private String randomList;

    public RandomDTO(String id, LocalDateTime dateTime, Integer min, Integer max, String originalList, String randomList) {
        this.id = id;
        this.dateTime = dateTime;
        this.min = min;
        this.max = max;
        this.originalList = originalList;
        this.randomList = randomList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public String getOriginalList() {
        return originalList;
    }

    public void setOriginalList(String originalList) {
        this.originalList = originalList;
    }

    public String getRandomList() {
        return randomList;
    }

    public void setRandomList(String randomList) {
        this.randomList = randomList;
    }
}
