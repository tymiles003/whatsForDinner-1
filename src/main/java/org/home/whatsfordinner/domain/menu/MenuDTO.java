package org.home.whatsfordinner.domain.menu;

import org.home.whatsfordinner.domain.dish.Dish;
import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MenuDTO {

    private Integer weekNr;
    private DateTime startDate;
    private DateTime endDate;
    private List<Dish> dishes = new LinkedList<>();
    private List<Long> dishIdsToIgnore = new ArrayList<>();

    public Integer getWeekNr() {
        return weekNr;
    }

    public void setWeekNr(final Integer weekNr) {
        this.weekNr = weekNr;
    }

    public DateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(final DateTime startDate) {
        this.startDate = startDate;
    }

    public DateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(final DateTime endDate) {
        this.endDate = endDate;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(final List<Dish> dishes) {
        this.dishes = dishes;
    }

    public List<Long> getDishIdsToIgnore() {
        return dishIdsToIgnore;
    }

    public void setDishIdsToIgnore(final List<Long> dishIdsToIgnore) {
        this.dishIdsToIgnore = dishIdsToIgnore;
    }

}
