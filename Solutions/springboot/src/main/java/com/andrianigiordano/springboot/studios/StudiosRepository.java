package com.andrianigiordano.springboot.studios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudiosRepository extends JpaRepository<Studios, Long> {
}
