package com.menu.core.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.menu.core.domain.model.aggregates.Menu;

public interface MenuRepository extends JpaRepository<Menu, Long> {

}
