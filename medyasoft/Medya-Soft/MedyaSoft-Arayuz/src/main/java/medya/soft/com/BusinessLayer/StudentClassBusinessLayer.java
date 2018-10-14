package medya.soft.com.BusinessLayer;

import medya.soft.com.EntityModel.StudentClassEntityModel;
import medya.soft.com.Repository.StudentClassCriteriaRepository;
import medya.soft.com.Repository.StudentClassRepository;
import medya.soft.com.ViewModel.DataTableViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentClassBusinessLayer { // iş katmanı
    @Autowired
    private StudentClassRepository studentClassRepository;

    @Autowired
    private StudentClassCriteriaRepository studentClassCriteriaRepository;

    public DataTableViewModel allStudentClass(int start, int length, String search, int draw) {
        DataTableViewModel studentClassViewModel = new DataTableViewModel();
        for (StudentClassEntityModel studentClassEntityModel : studentClassCriteriaRepository.findAllCriteria(start, length, search)) {
            List<String> item = new ArrayList<>();
            item.add(studentClassEntityModel.getName());
            studentClassViewModel.getData().add(item);
        }
        studentClassViewModel.setDraw(draw);
        studentClassViewModel.setLength(length);
        studentClassViewModel.setRecordsFiltered(Math.toIntExact(studentClassRepository.count()));
        studentClassViewModel.setRecordsTotal(Math.toIntExact(studentClassRepository.count()));
        return studentClassViewModel;
    }
}
