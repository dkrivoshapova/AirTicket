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
        List<User> userInfo = userRepository.findAllUser();
        for (User user : userInfo) {
            if (userDto.getEmail().equals(user.getEmail())) {
                if (userDto.getPassword().equals(user.getPassword())) {
                    return createAdminPage();
                }
            }
        }
        return returnLoginPage();
    }


    private ModelAndView createAdminPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.clear();
        modelAndView.setViewName("admin-page");
        return modelAndView;
    }

    private ModelAndView returnLoginPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.clear();
        modelAndView.setViewName("login");
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
