package medya.soft.com.ModelMap;

import medya.soft.com.EntityModel.StudentEntityModel;
import medya.soft.com.Model.StudentModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentConverter { // model to entity , entity to model mapper dönüştürücü
    StudentModel toStudentModel(StudentEntityModel studentEntityModel);

    StudentEntityModel toStudentEntityModel(StudentModel studentModel);
}
