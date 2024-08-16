package com.jmt.restaurant.controllers;

import com.jmt.global.ListData;
import com.jmt.global.rests.JSONData;
import com.jmt.restaurant.entities.Restaurant;
import com.jmt.restaurant.services.RestaurantInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restaurant")
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantInfoService infoService;


    /**
     * 목록 조회
     *
     * @param search
      */
    @GetMapping("/list")
    public JSONData list(@ModelAttribute RestaurantSearch search) { // url로 데이터 요청이라 모델어튜리뷰트로 셋업

        ListData<Restaurant> data = infoService.getList(search);

        return new JSONData(data);
    }

    /**
     *  식당 상세 조회
      */
    @GetMapping("/info/{rstrId}")
    public JSONData info(@PathVariable("rstrId") Long rstrId) {

        Restaurant data = infoService.get(rstrId);

        return new JSONData(data);
    }

}
