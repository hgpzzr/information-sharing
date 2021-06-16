package com.example.information_sharing.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InformationVO {
    private Integer informationId;

    private String describe;

    private Date time;

    private String contactInformation;

    private Integer informationStatus;

    private Integer informationCategoryId;

    private Integer userId;
}
