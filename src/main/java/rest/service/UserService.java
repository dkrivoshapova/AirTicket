package rest.service;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import rest.dto.UserDto;
import rest.persistence.entity.Student;
import rest.persistence.entity.User;
import rest.persistence.repository.StudentRepository;
import rest.persistence.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ModelAndView login(UserDto userDto) {

        System.out.println(userDto.getEmail());
        System.out.println(userDto.getPassword());
        if (userDto.getEmail().equals("") || userDto.getPassword().equals("")){return LoginExcepPage();}
        List<User> userInfo = userRepository.findAllUser();
        for (User user : userInfo) {
            if (userDto.getEmail().equals(user.getEmail())) {
                if (userDto.getPassword().equals(user.getPassword())) {
                    return createAdminPage();
                }
            }
        }
        return LoginExcepPage();
    }


    private ModelAndView createAdminPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.clear();
        modelAndView.setViewName("admin-page");
        return modelAndView;
    }

    private ModelAndView LoginExcepPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.clear();
        modelAndView.setViewName("exception-login");
        modelAndView.getModel().put("message", "неправильный логин или пароль"); // иньекция значений на страницу
        return modelAndView;
    }
//    private ModelAndView createAndFillModel(List<StudentDto> studentDtos) {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.clear();
//        modelAndView.getModel().put("listStudents", studentDtos);
//        modelAndView.setViewName("studets-page");
//        return modelAndView;
//    }

}
