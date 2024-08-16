package com.jmt.restaurant.controllers;

import com.jmt.global.CommonSearch;
import lombok.Data;

@Data
public class RestaurantSearch extends CommonSearch {


    // SIDO : 시도
    private String sido; // 우리조 엔티티로 변경 필요

    // SIDO + SIGUNGU : 시도 + 시군구
    private String sigungu; // 우리조 엔티티로 변경 필요

}
