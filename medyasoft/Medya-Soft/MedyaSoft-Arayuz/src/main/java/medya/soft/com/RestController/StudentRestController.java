package medya.soft.com.RestController;

import medya.soft.com.BusinessLayer.StudentBusinessLayer;
import medya.soft.com.EntityModel.StudentEntityModel;
import medya.soft.com.Model.StudentModel;
import medya.soft.com.ModelMap.StudentConverter;
import medya.soft.com.Repository.StudentRepository;
import medya.soft.com.ViewModel.DataTableViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentRestController {

    @Autowired
    private StudentBusinessLayer studentBusinessLayer;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentConverter studentConverter;


    @RequestMapping("/studentAjax")
    public DataTableViewModel studentAjax(
            @RequestParam(value = "start", required = false, defaultValue = "0") Integer start,
            @RequestParam(value = "length", required = false, defaultValue = "10") Integer length,
            @RequestParam(value = "search", required = false, defaultValue = "") String search,
            @RequestParam(value = "draw", required = false, defaultValue = "0") Integer draw
    ) {
        return studentBusinessLayer.allStudent(start, length, search, draw);
    }


    @PostMapping(value = "/saveStudent")
    public void saveStudent(@ModelAttribute StudentModel studentModel) {
        studentRepository.save(studentConverter.toStudentEntityModel(studentModel));
    }

    @GetMapping(value = "/studentList")
    public List<StudentEntityModel> studentList() {
        return (List<StudentEntityModel>) studentRepository.findAll();
    }
}
