package medya.soft.com.BusinessLayer;

import medya.soft.com.EntityModel.StudentEntityModel;
import medya.soft.com.Repository.StudentCriteriaRepository;
import medya.soft.com.Repository.StudentRepository;
import medya.soft.com.ViewModel.DataTableViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentBusinessLayer {  // iş katmanı
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentCriteriaRepository studentCriteriaRepository;

    public DataTableViewModel allStudent(int start, int length, String search, int draw) {
        DataTableViewModel studentViewModel = new DataTableViewModel();
        for (StudentEntityModel studentEntityModel : studentCriteriaRepository.findAllCriteria(start, length, search)) {
            List<String> item = new ArrayList<>();
            item.add(studentEntityModel.getName());
            studentViewModel.getData().add(item);
        }
        studentViewModel.setDraw(draw);
        studentViewModel.setLength(length);
        studentViewModel.setRecordsFiltered(Math.toIntExact(studentRepository.count()));
        studentViewModel.setRecordsTotal(Math.toIntExact(studentRepository.count()));
        return studentViewModel;
    }
}
