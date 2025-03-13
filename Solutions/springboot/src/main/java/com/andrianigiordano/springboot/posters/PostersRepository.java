package com.andrianigiordano.springboot.posters;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostersRepository extends JpaRepository<Posters, Long> {

        @Query(value = """
        SELECT p.*
        FROM posters_data p
        JOIN movies_data m ON p.id = m.id
        ORDER BY m.date DESC
        LIMIT 6
    """, nativeQuery = true)
        List<Posters> findTop6ByOrderByReleaseDateDesc();
}
