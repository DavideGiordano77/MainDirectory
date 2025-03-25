package com.andrianigiordano.springboot.themes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ThemesService {

    @Autowired
    private ThemesRepository themesRepository;


}
