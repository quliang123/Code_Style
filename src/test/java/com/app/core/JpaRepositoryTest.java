package com.app.core;

import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.Rollback;

import java.lang.annotation.*;

import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

/**
 * @program: Code_Style
 * @description:
 * @author: quliang
 * @create: 2022-06-16 16:11
 **/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@DataJpaTest
//@Import(DatabaseTestConfiguration.class)
@AutoConfigureTestDatabase(replace = NONE)
@Rollback(value = false)
public @interface JpaRepositoryTest {

}
