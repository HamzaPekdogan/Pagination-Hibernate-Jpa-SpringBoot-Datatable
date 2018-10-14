package medya.soft.com.RestController;

import medya.soft.com.BusinessLayer.StudentClassBusinessLayer;
import medya.soft.com.EntityModel.StudentClassEntityModel;
import medya.soft.com.Model.StudentClassModel;
import medya.soft.com.ModelMap.StudentClassConverter;
import medya.soft.com.Repository.StudentClassRepository;
import medya.soft.com.ViewModel.DataTableViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentClassRestController {

    @Autowired
    private StudentClassRepository studentClassRepository;

    @Autowired
    private StudentClassBusinessLayer studentClassBusinessLayer;

    @Autowired
    private StudentClassConverter studentClassConverter;

    @RequestMapping("/studentClassAjax")
    public DataTableViewModel studentAjax(
            @RequestParam(value = "start", required = false, defaultValue = "0") Integer start,
            @RequestParam(value = "length", required = false, defaultValue = "10") Integer length,
            @RequestParam(value = "search", required = false, defaultValue = "") String search,
            @RequestParam(value = "draw", required = false, defaultValue = "0") Integer draw
    ) {
        return studentClassBusinessLayer.allStudentClass(start, length, search, draw);
    }


    @PostMapping(value = "/saveStudentClass")
    public void saveStudent(@ModelAttribute StudentClassModel studentClassModel) {
        studentClassRepository.save(studentClassConverter.toStudentClassEntityModel(studentClassModel));
    }

    @GetMapping(value = "/studentClassList")
    public List<StudentClassEntityModel> studentList() {
        return (List<StudentClassEntityModel>) studentClassRepository.findAll();
    }
}
