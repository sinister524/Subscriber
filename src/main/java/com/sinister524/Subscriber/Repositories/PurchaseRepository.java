package com.sinister524.Subscriber.Repositories;

import com.sinister524.Subscriber.Entitys.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
}
