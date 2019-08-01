package springbootcase.demo.dao.test1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import springbootcase.demo.pojo.data.test1.Student;

public interface StudentRepository extends JpaRepository<Student,Integer>, JpaSpecificationExecutor<Student> {
}
