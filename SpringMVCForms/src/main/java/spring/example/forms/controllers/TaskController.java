package spring.example.forms.controllers;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import spring.example.forms.dao.TaskDAO;
import spring.example.forms.models.Task;
import spring.example.forms.models.User;

@Controller
public class TaskController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	private final String DETAIL_TASK_PAGE = "task/taskDetail";
	private final String NEW_TASK_PAGE = "task/newTask";
	private final String TASK_CREATED_PAGE = "task/createdTask";
	private final String ERROR_PAGE = "error";
	private final String UPDATE_PAGE = "task/taskUpdate";
	private final String TASK_UPDATED_PAGE = "task/taskUpdated";
	private final String DELETED_TASK_PAGE = "task/deletedTask";
	
	@Autowired
	private TaskDAO taskDAO;
	
	@RequestMapping(method = RequestMethod.GET, value = {"/tasks/{id}"})
	public String taskDetail(@PathVariable(value = "id") Integer id, Map<String, Object> model){
		logger.info("Task detail.");
		
		Task task = taskDAO.selectById(id);
		model.put("task", task);
		
		return DETAIL_TASK_PAGE;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = {"/tasks/new"})
	public String newTask(Map<String, Object> model){
		logger.info("Showing custom view to insert a task.");
		
		model.put("task", new Task());
		
		return NEW_TASK_PAGE;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = {"/tasks/new"})
	public ModelAndView createTask(Task task){
		logger.info("Save view POST " + task.getId() + ".");
		
		ModelAndView modelAndView = new ModelAndView();
		if(taskDAO.create(task) > 0){
			modelAndView.setViewName(TASK_CREATED_PAGE);
			modelAndView.addObject("task", task);
		}else{
			modelAndView.setViewName(ERROR_PAGE);
			modelAndView.addObject("errorMessage", "An error ocurred while trying to create a new task. Please try again.");
		}
		
		return modelAndView;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = {"/tasks/update/{id}"})
	public String updateTask(@PathVariable(value = "id") Integer id, Map<String, Object> model){
		logger.info("Showing update view.");
		
		model.put("task", taskDAO.selectById(id));
		
		return UPDATE_PAGE;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = {"/tasks/saveupdate"})
	public ModelAndView saveupdate(Task task){
		logger.info("Save update POST " + task.getId() + ".");
		
		taskDAO.update(task.getId(), task);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(TASK_UPDATED_PAGE);
		modelAndView.addObject("user", task);
		
		return modelAndView;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = {"/tasks/delete/{id}"})
	public String deleteTask(@PathVariable(value = "id") Integer id, Map<String, Object> model){
		logger.info("Delete task.");
		
		taskDAO.delete(id);
		
		model.put("taskId", id);
		
		return DELETED_TASK_PAGE;
	}
}