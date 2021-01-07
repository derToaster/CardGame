package com.dertoaster.androidtest.repositories;

import com.dertoaster.androidtest.models.Cards;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Cards, Long> {
}
