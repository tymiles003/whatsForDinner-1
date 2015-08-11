package org.home.whatsfordinner.repository.menu;

import org.home.whatsfordinner.domain.menu.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Long> {
}
