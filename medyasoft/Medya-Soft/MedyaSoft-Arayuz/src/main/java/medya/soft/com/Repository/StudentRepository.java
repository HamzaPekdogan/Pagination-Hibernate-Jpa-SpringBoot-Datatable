package medya.soft.com.Repository;

import medya.soft.com.EntityModel.StudentEntityModel;
import org.springframework.data.repository.CrudRepository;
import zendemFramework.AltyapiRepository.RepositoryImpl.RepositoryBase;

public interface StudentRepository extends CrudRepository<StudentEntityModel, Long>, RepositoryBase { //jpa katmanı
    StudentEntityModel findByIdEquals(int id);
}
