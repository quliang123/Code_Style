package com.app.domian.repository;

import com.app.domian.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @program: Code_Style
 * @description:
 * @author: quliang
 * @create: 2022-06-15 17:43
 **/

public interface QuestionRepository extends JpaRepository<Question,String> {
}
