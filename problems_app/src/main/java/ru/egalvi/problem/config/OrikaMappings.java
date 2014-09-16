package ru.egalvi.problem.config;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class OrikaMappings {
    private final MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

    private void configure(){
//        mapperFactory.classMap(Discipline.class, DisciplineDto.class)
//                .field()
    }

    public MapperFacade getMapper(){
        return mapperFactory.getMapperFacade();
    }
}
