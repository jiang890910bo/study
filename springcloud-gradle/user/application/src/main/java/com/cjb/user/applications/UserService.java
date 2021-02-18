package com.cjb.user.applications;

import com.cjb.user.domain.StudentService;
import com.cjb.user.domain.TeacherService;
import com.cjb.user.domain.UserInterface;
import com.cjb.user.domain.entity.Student;
import com.cjb.user.domain.entity.Teacher;
import com.cjb.user.domain.entity.User;
import lombok.Data;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * UserService
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2020/08/02
 */
@Data
@Component
public class UserService implements  BeanFactoryPostProcessor{

  private ApplicationContext applicationContext;

  private  Map<Class<? extends User>, UserInterface> userInterfaceMap = new HashMap<>();

  @Override
  public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
    StudentService studentServiceBean = beanFactory.getBean(StudentService.class);
    TeacherService teacherServiceBean = beanFactory.getBean(TeacherService.class);
    userInterfaceMap.put(Student.class, studentServiceBean);
    userInterfaceMap.put(Teacher.class, teacherServiceBean);
  }
}
