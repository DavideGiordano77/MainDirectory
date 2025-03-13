package com.andrianigiordano.springboot.releases;

import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReleasesService {

    private final ReleasesRepository releasesRepository;

    public ReleasesService(ReleasesRepository releasesRepository) {
        this.releasesRepository = releasesRepository;
    }



}
