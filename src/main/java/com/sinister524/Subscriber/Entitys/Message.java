package com.sinister524.Subscriber.Entitys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    private Long msisdn;

    private Action action;

    private Long timeStamp;
}
