package com.example.information_sharing.controller;

import com.example.information_sharing.VO.ResultVO;
import com.example.information_sharing.entity.Information;
import com.example.information_sharing.service.InformationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping("/information")
public class InformationController {

    @Autowired
    private InformationService informationService;

    // 添加其他信息
    @PostMapping("/insert")
    public ResultVO insertInformation(Information information){
        return informationService.insertInformation(information);
    }

    // 删除其他信息
    @DeleteMapping("/delete")
    public ResultVO deleteInformation(Integer informationId){
        return informationService.deleteInformation(informationId);
    }

    // 修改其他信息
    @PutMapping("/update")
    public ResultVO updateInformation(Information information){
        return informationService.updateInformation(information);
    }

    // 查找其他未完成信息
    @GetMapping("/selectAll")
    public ResultVO selectAll(){
        return informationService.selectAllInformation();
    }

    @GetMapping("/selectByCategoryId")
    public ResultVO selectByCategoryId(Integer informationCategoryId){
        return informationService.selectByCategoryId(informationCategoryId);
    }

}
