package com.alex.common.jojo.model;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DotaUser implements Serializable {

    private Long id;
    private String userName;
    private Date createTime;
    private String operateIp;

    private String uniqueId;
    private String sex;
    private String headUrl;
    private String nickName;

}
