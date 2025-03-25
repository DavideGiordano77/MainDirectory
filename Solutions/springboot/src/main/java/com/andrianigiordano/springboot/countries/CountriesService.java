package com.andrianigiordano.springboot.countries;

import com.andrianigiordano.springboot.posters.Posters;
import com.andrianigiordano.springboot.posters.PostersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.andrianigiordano.springboot.countries.CountriesRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CountriesService {

    @Autowired
    private CountriesRepository countriesRepository;


}
