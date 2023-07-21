package com.menu.core.domain.query;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import com.menu.core.domain.model.aggregates.Menu;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class MenuListQueryResult {
  public Integer totalCnt;
  public Integer page;
  public List<Menu> menuList;
}
