package com.automation.pojo;




import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Data {

    int year;
    float price;

    @JsonProperty("Cpu model")
    String Cpu_model;

    @JsonProperty("Hard disk size")
    String Hard_disk_size;
}
