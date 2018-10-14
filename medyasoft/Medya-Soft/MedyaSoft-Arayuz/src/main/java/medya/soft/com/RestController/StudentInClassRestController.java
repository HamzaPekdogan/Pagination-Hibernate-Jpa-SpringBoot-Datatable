package medya.soft.com.RestController;

import medya.soft.com.BusinessLayer.StudentInClassBusinessLayer;
import medya.soft.com.Model.StudentInClassModel;
import medya.soft.com.ModelMap.StudentInClassConverter;
import medya.soft.com.Repository.StudentInClassRepository;
import medya.soft.com.ViewModel.DataTableViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentInClassRestController {

    @Autowired
    private StudentInClassBusinessLayer studentInClassBusinessLayer;

    @Autowired
    private StudentInClassRepository studentInClassRepository;

    @Autowired
    private StudentInClassConverter studentInClassConverter;


    @RequestMapping("/studentInClassAjax")
    public DataTableViewModel studentAjax(
            @RequestParam(value = "start", required = false, defaultValue = "0") Integer start,
            @RequestParam(value = "length", required = false, defaultValue = "10") Integer length,
            @RequestParam(value = "search", required = false, defaultValue = "") String search,
            @RequestParam(value = "draw", required = false, defaultValue = "0") Integer draw
    ) {
        return studentInClassBusinessLayer.allStudentInClass(start, length, search, draw);
    }


    @PostMapping(value = "/saveStudentInClass")
    public void saveStudent(@ModelAttribute StudentInClassModel studentInClassModel) {
        studentInClassRepository.save(studentInClassConverter.toStudentInClassEntityModel(studentInClassModel));
    }

}
