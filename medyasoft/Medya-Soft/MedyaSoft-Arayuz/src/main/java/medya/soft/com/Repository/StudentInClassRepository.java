package medya.soft.com.Repository;

import medya.soft.com.EntityModel.StudentInClassEntityModel;
import org.springframework.data.repository.CrudRepository;
import zendemFramework.AltyapiRepository.RepositoryImpl.RepositoryBase;

public interface StudentInClassRepository extends CrudRepository<StudentInClassEntityModel, Long>, RepositoryBase { //jpa katmanı


}
