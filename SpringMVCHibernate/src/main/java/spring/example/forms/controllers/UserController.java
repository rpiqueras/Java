package spring.example.forms.controllers;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import spring.example.forms.dao.impl.GenericDAOImpl;
import spring.example.forms.models.PaginationCriteria;
import spring.example.forms.models.User;

@Controller
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	private final String SHOW_USERS_PAGE = "user/users";
	private final String SHOW_USERS_PAGINATED_PAGE = "user/usersPaginated";
	private final String PAGINATION_PAGE = "user/usersPagination";
	private final String DETAIL_USER_PAGE = "user/userDetail";
	private final String NEW_USER_PAGE = "user/newUser";
	private final String USER_CREATED_PAGE = "user/createdUser";
	private final String ERROR_PAGE = "error";
	private final String UPDATE_PAGE = "user/userUpdate";
	private final String USER_UPDATED_PAGE = "user/userUpdated";
	private final String DELETED_USER_PAGE = "user/deletedUser";
	private final String LOGIN_PAGE = "customLogin";
	@Autowired
	private GenericDAOImpl<User> userDAO;
	
	@RequestMapping(method = RequestMethod.GET, value = {"/", "/users"})
	public String showUsers(Map<String, Object> model){
		logger.info("Product show users. ");
		
		List<User> users = userDAO.selectAll(User.class);
		model.put("users", users);
		
		return SHOW_USERS_PAGE;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = {"/users/paginated"})
	public String showUsersPaginated(Map<String, Object> model){
		logger.info("Product show users paginated. ");
		
		List<User> users = userDAO.selectAll(User.class);
		model.put("users", users);
		
		return SHOW_USERS_PAGINATED_PAGE;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = {"/users/pagination"})
	public String showPagination(Map<String, Object> model){
		logger.info("Product show pagination page. ");
		
		model.put("paginationCriteria", new PaginationCriteria());
		
		return PAGINATION_PAGE;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = {"/users/{id}"})
	public String userDetail(@PathVariable(value = "id") Integer id, Map<String, Object> model){
		logger.info("User detail.");
		
		User user = userDAO.selectById(id, User.class);
		model.put("user", user);
		
		return DETAIL_USER_PAGE;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = {"/users/new"})
	public String newUser(Map<String, Object> model){
		logger.info("Showing custom view to insert a user.");
		
		model.put("user", new User());
		
		return NEW_USER_PAGE;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = {"/users/savenew"})
	public ModelAndView createUser(@Valid User user,BindingResult bindingResult){
		logger.info("Save view POST " + user.getId() + ".");
		
		ModelAndView modelAndView = new ModelAndView();
		
		if(bindingResult.hasErrors()){
			modelAndView.setViewName(NEW_USER_PAGE);
			modelAndView.addObject("user", user);
		}else if(userDAO.insert(user) > 0){
			modelAndView.setViewName(USER_CREATED_PAGE);
			modelAndView.addObject("user", user);
		}else{
			modelAndView.setViewName(ERROR_PAGE);
			modelAndView.addObject("errorMessage", "An error ocurred while trying to create a new user. Please try again.");
		}
		
		return modelAndView;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = {"/users/update/{id}"})
	public String updateUser(@PathVariable(value = "id") Integer id, Map<String, Object> model){
		logger.info("Showing update view.");
		
		model.put("user", userDAO.selectById(id, User.class));
		
		return UPDATE_PAGE;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = {"/users/saveupdate"})
	public ModelAndView saveupdate(User user){
		logger.info("Save update POST " + user.getId() + ".");
		
		userDAO.update(user);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(USER_UPDATED_PAGE);
		modelAndView.addObject("user", user);
		
		return modelAndView;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = {"/users/delete/{id}"})
	public String deleteUser(@PathVariable(value = "id") int id, Map<String, Object> model){
		logger.info("Delete user.");
		
		User user = userDAO.selectById(id, User.class);
		userDAO.delete(user);
		
		model.put("userId", id);
		
		return DELETED_USER_PAGE;
	}
	
//	@RequestMapping(method = RequestMethod.GET, value = {"/myCustomLogin"})
//	public String customLogin(Locale locale, Model model){
//		logger.info("Showing login the client locale is {}.", locale);
//		
//		return LOGIN_PAGE;
//	}
}
