package com.menu.core.domain.query;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class MenuListQuery {

  private final String menuId;
  private final String searchType;
  private final int pagingSize;
  private final int page;
}

