package org.home.whatsfordinner.domain.menu;

import org.hibernate.annotations.Type;
import org.home.whatsfordinner.domain.BaseEntity;
import org.joda.time.DateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "menu")
public class Menu extends BaseEntity {

    private Integer weekNr;
    private DateTime startDate;
    private DateTime endDate;
    private List<MenuDish> menuDishes = new LinkedList<>();

    @NotNull
    @Column(name = "week_nr", nullable = false)
    public Integer getWeekNr() {
        return weekNr;
    }

    public void setWeekNr(final Integer weekNr) {
        this.weekNr = weekNr;
    }

    @NotNull
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @Column(name = "start_date")
    public DateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(final DateTime startDate) {
        this.startDate = startDate;
    }

    @NotNull
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @Column(name = "end_date")
    public DateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(final DateTime endDate) {
        this.endDate = endDate;
    }

    @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL)
    @MapKeyColumn(name="id")
    public List<MenuDish> getMenuDishes() {
        return menuDishes;
    }

    public void setMenuDishes(final List<MenuDish> menuDishes) {
        this.menuDishes = menuDishes;
    }
}
