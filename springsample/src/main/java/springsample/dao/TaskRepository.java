package springsample.dao;

import org.springframework.data.repository.CrudRepository;
import springsample.model.Task;


public interface TaskRepository extends CrudRepository<Task, Integer> {

}
