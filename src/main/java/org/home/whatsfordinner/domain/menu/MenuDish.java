package org.home.whatsfordinner.domain.menu;

import org.home.whatsfordinner.domain.BaseEntity;
import org.home.whatsfordinner.domain.dish.Dish;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "menu_dish")
public class MenuDish extends BaseEntity {

    private Dish dish;
    private Menu menu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dish_id", nullable = false)
    public Dish getDish() {
        return dish;
    }

    public void setDish(final Dish dish) {
        this.dish = dish;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id", nullable = false)
    public Menu getMenu() {
        return menu;
    }

    public void setMenu(final Menu menu) {
        this.menu = menu;
    }

}
