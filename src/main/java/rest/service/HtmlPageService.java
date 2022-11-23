package rest.service;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import rest.dto.StudentDto;
import rest.dto.UserDto;

import java.util.UUID;

@Service
public class HtmlPageService {

    private final StudentService studentService;

    public HtmlPageService(StudentService studentService) {
        this.studentService = studentService;
    }

    public ModelAndView createStudentPage() {
        return studentService.getAllStudents();
    }

    public ModelAndView createStudent(StudentDto studentDto) {
        return studentService.createStudent(studentDto);
    }
    public ModelAndView loginUser(UserDto userDto) {
        return studentService.loginUser(userDto);
    }


    public void removeStudent(UUID id) {
        studentService.removeStudentById(id);
    }
}
