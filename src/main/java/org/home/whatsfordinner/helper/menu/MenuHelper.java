package org.home.whatsfordinner.helper.menu;

import org.home.whatsfordinner.domain.dish.Dish;
import org.home.whatsfordinner.domain.menu.Menu;
import org.home.whatsfordinner.domain.menu.MenuDish;
import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;

import java.util.LinkedList;
import java.util.List;

public final class MenuHelper {

    private MenuHelper() {}

    /**
     * Get the week number. The first week of the year is that in which at least 4 days are in the year
     *
     * @return the week number
     */
    public static Integer getWeekNumber() {
        return new DateTime().getWeekOfWeekyear();
    }

    /**
     * Get the date of the first day of the current week
     *
     * @return date of the first day of the current week
     */
    public static DateTime getWeekStartDate() {
        return new DateTime().withDayOfWeek(DateTimeConstants.MONDAY).withTimeAtStartOfDay();
    }

    /**
     * Get the date of the last day of the current week
     *
     * @return date of the last day of the current week
     */
    public static DateTime getWeekEndDate() {
        return new DateTime().withDayOfWeek(DateTimeConstants.SUNDAY)
                .withHourOfDay(23)
                .withMinuteOfHour(59)
                .withSecondOfMinute(59)
                .withMillisOfSecond(0);
    }

    /**
     * Create a list of menuDishes from the list of dishes
     *
     * @param dishes
     * @param menu
     * @return list of menu dishes
     */
    public static List<MenuDish> createMenuDishes(final List<Dish> dishes, final Menu menu) {
        final List<MenuDish> menuDishes = new LinkedList<>();
        dishes.forEach(dish -> {
            final MenuDish menuDish = new MenuDish();
            menuDish.setMenu(menu);
            menuDish.setDish(dish);
            menuDishes.add(menuDish);
        });
        return menuDishes;
    }
}
