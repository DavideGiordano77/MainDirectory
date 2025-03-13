package com.andrianigiordano.springboot.the_oscar_awards;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheOscarAwardsRepository extends JpaRepository<TheOscarAwards, Long> {
}
