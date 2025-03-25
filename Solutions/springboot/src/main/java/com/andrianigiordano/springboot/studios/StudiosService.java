package com.andrianigiordano.springboot.studios;

import com.andrianigiordano.springboot.languages.Languages;
import com.andrianigiordano.springboot.languages.LanguagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudiosService {

    @Autowired
    private StudiosRepository studiosRepository;


}
