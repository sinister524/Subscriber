package com.sinister524.Subscriber.Entitys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SUBSCRIPTION")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Subscription extends Message{

    private Long msisdn;

    @Id
    private Long timestamp;
}
