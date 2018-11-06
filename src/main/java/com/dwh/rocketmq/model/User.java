package com.dwh.rocketmq.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class User implements Serializable {
    private String id;
    private String username;
}
