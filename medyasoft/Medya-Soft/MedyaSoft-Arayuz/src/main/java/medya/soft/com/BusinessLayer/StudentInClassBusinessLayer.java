package medya.soft.com.BusinessLayer;

import medya.soft.com.EntityModel.StudentInClassEntityModel;
import medya.soft.com.Repository.StudentClassRepository;
import medya.soft.com.Repository.StudentInClassCriteriaRepository;
import medya.soft.com.Repository.StudentInClassRepository;
import medya.soft.com.Repository.StudentRepository;
import medya.soft.com.ViewModel.DataTableViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentInClassBusinessLayer {  // iş katmanı
    @Autowired
    private StudentInClassRepository studentInClassRepository;

    @Autowired
    private StudentInClassCriteriaRepository studentInClassCriteriaRepository;

    @Autowired
    private StudentClassRepository studentClassRepository;

    @Autowired
    private StudentRepository studentRepository;

    public DataTableViewModel allStudentInClass(int start, int length, String search, int draw) {
        DataTableViewModel studentClassInViewModel = new DataTableViewModel();
        for (StudentInClassEntityModel studentInClassEntityModel : studentInClassCriteriaRepository.findAllCriteria(start, length, search)) {
            List<String> item = new ArrayList<>();
            item.add(studentRepository.findByIdEquals(Integer.parseInt(studentInClassEntityModel.getStudentUuid())).getName());
            item.add(studentClassRepository.findByIdEquals(Integer.parseInt(studentInClassEntityModel.getStudentClassUuid())).getName());
            studentClassInViewModel.getData().add(item);
        }
        studentClassInViewModel.setDraw(draw);
        studentClassInViewModel.setLength(length);
        studentClassInViewModel.setRecordsFiltered(Math.toIntExact(studentInClassRepository.count()));
        studentClassInViewModel.setRecordsTotal(Math.toIntExact(studentInClassRepository.count()));
        return studentClassInViewModel;
    }
}
