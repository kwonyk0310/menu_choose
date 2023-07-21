package com.menu.core.domain.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter // @Validated 사용을 위해선 @Setter가 필수
@AllArgsConstructor
@ToString
//@StickerSendRqstDtoValidation
public class MenuSaveRqstDto {

  @Schema(
      description = "메뉴 고유 번호",
      example = "1",
      required = true
  )
  private Long menuSeq;

//  @Schema(
//      description = "메뉴 아이디",
//      example = "apple",
//      required = true
//  )
//  private String menuId;

  @Schema(
      description = "주 메뉴",
      example = "김치볶음밥",
      required = true
  )
  private String menuName;
  
  @Schema(
    description = "1인분 당 가격",
    example = "W",
    required = true
  )
  private Integer price;
  
  @Schema(
    description = "카테고리",
    example = "한식",
    required = true
  )
  private String category;
  
  @Schema(
    description = "어울리는 음료",
    example = "맥주",
    required = true
  )
  private String drink;
  
  @Schema(
    description = "어울리는 메뉴",
    example = "된장국",
    required = true
  )
  private String subMenu;

}
