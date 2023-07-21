package com.menu.core.application.queryservices;

import com.menu.core.domain.model.aggregates.Menu;
import com.menu.core.domain.query.MenuListQueryResult;
import com.menu.core.domain.repository.MenuRepository;
import com.menu.core.interfaces.menu.dto.MenuListRqstDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MenuQueryHandler {

  private final MenuRepository menuRepository;

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  public MenuListQueryResult execute(MenuListRqstDto rqstDto) {

    List<Menu> menuList = menuRepository.findAll();

    logger.info("MenuListQueryHandler, execute : " + menuList);

    return MenuListQueryResult.builder()
        .totalCnt(menuList == null ? 0 : menuList.size())
        .page(rqstDto.getPage())
        .menuList(menuList)
        .build();
  }

}
