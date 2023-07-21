package com.menu.core.domain.model.aggregates;

import lombok.*;
import javax.persistence.*;

@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "menu_info", uniqueConstraints = {@UniqueConstraint(columnNames = "menu_id")})
public class Menu {

    @Id
    @Column(name = "menu_seq", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long menuSeq;

    @Column(name = "menu_id", nullable = false)
    private String menuId;

    @Column(name = "menu_name", nullable = false)
    private String menuName;

    @Column(name = "price", nullable = false)
    private Integer price;

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "drink", nullable = true)
    private String drink;

    @Column(name = "sub_menu", nullable = true)
    private String subMenu;

    
    public void changeDrink(String drink) {
        this.drink = drink;
    }
    
    public void changeSubMenu(String subMenu) {
        this.subMenu = subMenu;
    }

}