package medya.soft.com.Repository;

import medya.soft.com.EntityModel.StudentEntityModel;
import medya.soft.com.Model.StudentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import zendemFramework.AltyapiRepository.RepositoryImpl.RepositoryBase;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Component
public class StudentCriteriaRepository { //pagination işlemi
    @Autowired
    private EntityManager em;

    public List<StudentEntityModel> findAllCriteria(int start,int length,String search)
    {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<StudentEntityModel> cq = cb.createQuery(StudentEntityModel.class);
        Root<StudentEntityModel> from = cq.from(StudentEntityModel.class);
        CriteriaQuery<StudentEntityModel> selectQuery = cq.select(from);
        TypedQuery<StudentEntityModel> query = em.createQuery(selectQuery).setFirstResult(start).setMaxResults(length);
        return query.getResultList();
    }
}
