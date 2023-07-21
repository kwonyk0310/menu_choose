package com.menu.core.application.commandservices;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.menu.core.domain.model.aggregates.Menu;
import javax.transaction.Transactional;
import com.menu.core.domain.repository.MenuRepository;
import com.menu.core.domain.query.MenuSaveRqstDto;

@Slf4j
@Service
@RequiredArgsConstructor
public class MenuCommandHandler {

  private final MenuRepository menuRepository;
  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  public Menu save(MenuSaveRqstDto rqstDto) {

    Menu menuInfo = Menu.builder()
      .menuName(rqstDto.getMenuName())
      .category(rqstDto.getCategory())
      .drink(rqstDto.getDrink())
      .price(rqstDto.getPrice())
      .subMenu(rqstDto.getSubMenu())
            .build();

    Menu menu = menuRepository.save(menuInfo);

    logger.info("MenuCommandHandler, save : " + menu);
    return menu;
  }


  @Transactional
  public Menu update(MenuSaveRqstDto rqstDto) {

    Menu menu = menuRepository.findById(rqstDto.getMenuSeq()).orElseThrow();

    if(menu != null) {
      menu.changeDrink(rqstDto.getDrink());
      menu.changeSubMenu(rqstDto.getSubMenu());
    }
    logger.info("MenuCommandHandler, save : " + menu);
    return menu;
  }

  @Transactional
  public void delete(MenuSaveRqstDto rqstDto) {

    Menu menu = menuRepository.findById(rqstDto.getMenuSeq()).orElseThrow();

    if(menu != null) {
      menuRepository.delete(menu);
    }
    logger.info("MenuCommandHandler, delete success");
  }

}
