package medya.soft.com.ModelMap;

import medya.soft.com.EntityModel.StudentClassEntityModel;
import medya.soft.com.Model.StudentClassModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentClassConverter { // model to entity , entity to model mapper dönüştürücü
    StudentClassModel toStudentClassModel(StudentClassEntityModel studentClassEntityModel);

    StudentClassEntityModel toStudentClassEntityModel(StudentClassModel studentClassModel);
}
