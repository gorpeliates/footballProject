package com.league.footballProject.commons;

import jakarta.persistence.*;

@Entity
@Table(name = "Player")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String nationality;
    private Integer age;
    private String position;
    private Integer starts;
    private Double minutes;
    private Integer goals;
    private Integer assists;

    public Player() {
    }

    public Player(Long id, String name, String nationality, Integer age, String position, Integer starts, Double minutes, Integer goals, Integer assists) {
        this.id = id;
        this.name = name;
        this.nationality = nationality;
        this.age = age;
        this.position = position;
        this.starts = starts;
        this.minutes = minutes;
        this.goals = goals;
        this.assists = assists;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getStarts() {
        return starts;
    }

    public void setStarts(Integer starts) {
        this.starts = starts;
    }

    public Double getMinutes() {
        return minutes;
    }

    public void setMinutes(Double minutes) {
        this.minutes = minutes;
    }

    public Integer getGoals() {
        return goals;
    }

    public void setGoals(Integer goals) {
        this.goals = goals;
    }

    public Integer getAssists() {
        return assists;
    }

    public void setAssists(Integer assists) {
        this.assists = assists;
    }
}
