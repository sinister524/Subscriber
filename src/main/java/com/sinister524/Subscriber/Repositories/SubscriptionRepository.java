package com.sinister524.Subscriber.Repositories;

import com.sinister524.Subscriber.Entitys.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
}
