package com.andrianigiordano.springboot.rotten_tomatoes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RottenTomatoesReviewRepository extends JpaRepository<RottenTomatoesReview, Long> {
}
