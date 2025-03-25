package com.andrianigiordano.springboot.languages;

import com.andrianigiordano.springboot.countries.Countries;
import com.andrianigiordano.springboot.countries.CountriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LanguagesService {
    @Autowired
    private LanguagesRepository languagesRepository;

}
