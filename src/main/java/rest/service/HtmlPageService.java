package rest.service;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import rest.dto.StudentDto;
import rest.dto.UserDto;

import java.util.UUID;

@Service
public class HtmlPageService {

    private final StudentService studentService;
    private final UserService userService;

    public HtmlPageService(StudentService studentService, UserService userService) {
        this.studentService = studentService;
        this.userService = userService;
    }
    public ModelAndView registrartion(UserDto userDto) {
        return userService.login(userDto);
    }
    public ModelAndView createStudentPage() {
        return studentService.getAllStudents();
    }

    public ModelAndView createStudent(StudentDto studentDto) {
        return studentService.createStudent(studentDto);
    }

    public void removeStudent(UUID id) {
        studentService.removeStudentById(id);
    }
}
