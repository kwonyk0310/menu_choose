package com.menu.core.interfaces.menu;

import com.menu.core.application.commandservices.MenuCommandHandler;
import com.menu.core.application.queryservices.MenuQueryHandler;
import com.menu.core.domain.model.aggregates.Menu;
import com.menu.core.domain.query.MenuListQueryResult;
import com.menu.core.domain.query.MenuSaveRqstDto;
import com.menu.core.interfaces.menu.dto.MenuListRqstDto;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/Menu")
public class MenuController {

    private final MenuQueryHandler queryHandler;
    private final MenuCommandHandler commandHandler;

    @GetMapping( "/list")
    public MenuListQueryResult menuList(
            @Parameter(in = ParameterIn.QUERY) MenuListRqstDto menuListRqstDto
    ) throws Exception{
        log.info("Test Start");

        try {
            MenuListQueryResult menuList = queryHandler.execute(menuListRqstDto);

            return menuList;

        } catch (Exception e) {
            throw new Exception();
        }
    }

    @PostMapping( "/insert")
    public Menu menuInsert(
            @Parameter(in = ParameterIn.QUERY) MenuSaveRqstDto menuSaveRqstDto
    ) throws Exception{
        log.info("Test Start");

        try {
            Menu menu = commandHandler.save(menuSaveRqstDto);

            return menu;

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception();
        }
    }
//
//    @PostMapping( "/update")
//    public Menu menuUpdate(
//            @Parameter(in = ParameterIn.QUERY) MenuSaveRqstDto menuSaveRqstDto
//    ) throws Exception{
//        log.info("Test Start");
//
//        try {
//            Menu menu = commandHandler.update(menuSaveRqstDto);
//
//            return menu;
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new Exception();
//        }
//    }
//
//    @PostMapping( "/delete")
//    public void menuDelete(
//            @Parameter(in = ParameterIn.QUERY) MenuSaveRqstDto menuSaveRqstDto
//    ) throws Exception{
//        log.info("Test Start");
//
//        try {
//            commandHandler.delete(menuSaveRqstDto);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new Exception();
//        }
//    }

}