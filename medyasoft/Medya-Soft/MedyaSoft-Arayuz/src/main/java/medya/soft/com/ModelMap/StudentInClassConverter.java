package medya.soft.com.ModelMap;

import medya.soft.com.EntityModel.StudentInClassEntityModel;
import medya.soft.com.Model.StudentInClassModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentInClassConverter { // model to entity , entity to model mapper dönüştürücü
    StudentInClassModel toStudentInClassModel(StudentInClassEntityModel studentInClassEntityModel);

    StudentInClassEntityModel toStudentInClassEntityModel(StudentInClassModel studentInClassModel);
}
