package medya.soft.com.Repository;

import medya.soft.com.EntityModel.StudentClassEntityModel;
import org.springframework.data.repository.CrudRepository;
import zendemFramework.AltyapiRepository.RepositoryImpl.RepositoryBase;

public interface StudentClassRepository extends CrudRepository<StudentClassEntityModel, Long>, RepositoryBase { //jpa katmanı
    StudentClassEntityModel findByIdEquals(int id);

}
