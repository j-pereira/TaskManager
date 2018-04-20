package springsample.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import springsample.dao.TaskRepository;
import springsample.model.Task;


@Service
@Transactional
public class TaskService {
	
	private TaskRepository taskRepository;
		
	public TaskService(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}
	
	public List<Task> findAll(){
		List<Task> tasks = new ArrayList<>();
		for(Task task : taskRepository.findAll()){
			tasks.add(task);
		}
		
		Collections.sort(tasks, (o1, o2) -> o1.compareTo(o2));
		
		return tasks;
	}
	
	public Optional<Task> findTask(int id){
		return taskRepository.findById(id);
	}
	
	
	public void save(Task task) {
		taskRepository.save(task);
	}
	
	
	public void delete(int id) {
		taskRepository.deleteById(id);
	}
	
}
