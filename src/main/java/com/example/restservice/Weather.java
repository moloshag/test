package com.example.restservice;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class Weather {
	private String fall;
	private int temp, wind, wet;
	private Date date;
}
