package spring.example.rest.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import spring.example.rest.dao.SeriesDAO;
import spring.example.rest.models.Series;

@RestController
@RequestMapping("/api")
public class SeriesController {

	/** The Constant EMPTY_STRING. */
	private static final String EMPTY_STRING = "";
	
	/** The Constant TAG_LISTAS. */
    public static final String TAG_LISTAS = "Listas";
    
    /** The Constant TAG_TODO. */
    public static final String TAG_TODO = "Todos";
    
    /** The Constant SERIES_ENDPOINT. */
    public static final String SERIES_ENDPOINT = "/series";
    /** The Constant SERIES_GET_DESCRIPTION. */
    public static final String SERIES_GET_DESCRIPTION = "Obtención de lista de series";
    /** The Constant SERIES_GET_BY_ID_DESCRIPTION. */
    public static final String SERIES_GET_BY_ID_DESCRIPTION = "Obtención de una serie por su id";
    /** The Constant SERIES_CREATE_DESCRIPTION. */
    public static final String SERIES_CREATE_DESCRIPTION = "Creación de una nueva serie";
    /** The Constant SERIES_UPDATE_DESCRIPTION. */
    public static final String SERIES_UPDATE_DESCRIPTION = "Modificación de una serie";
    /** The Constant SERIES_DELETE_DESCRIPTION. */
    public static final String SERIES_DELETE_DESCRIPTION = "Eliminación de una serie";
    
	@Autowired
	private SeriesDAO seriesDAO;
	
	@ApiOperation(value = SERIES_GET_DESCRIPTION, notes = EMPTY_STRING, tags = { TAG_LISTAS, TAG_TODO})
	@ApiResponses({
		@ApiResponse(code = 200, message = "OK")
	})
	@RequestMapping(value = SERIES_ENDPOINT, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public List<Series> getAll(){
		return seriesDAO.get();
	}
	
	@ApiOperation(value = SERIES_GET_BY_ID_DESCRIPTION, notes = EMPTY_STRING, tags = { TAG_LISTAS, TAG_TODO})
	@ApiResponses({
		@ApiResponse(code = 200, message = "OK")
	})
	@RequestMapping(value = SERIES_ENDPOINT + "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public Series getById(@PathVariable(value = "id") Integer id){
		return seriesDAO.find(id);
	}
	
	@ApiOperation(value = SERIES_CREATE_DESCRIPTION, notes = EMPTY_STRING, tags = { TAG_LISTAS})
	@ApiResponses({
		@ApiResponse(code = 200, message = "OK")
	})
	@RequestMapping(value = SERIES_ENDPOINT, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public Boolean create(@RequestBody @Valid Series series){
		return seriesDAO.create(series) > 0;
	}
	
	@ApiOperation(value = SERIES_UPDATE_DESCRIPTION, notes = EMPTY_STRING, tags = { TAG_LISTAS})
	@ApiResponses({
		@ApiResponse(code = 200, message = "OK")
	})
	@RequestMapping(value = SERIES_ENDPOINT + "/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public Boolean update(@PathVariable Integer id, @RequestBody @Valid Series series){
		series.setId(id);
		
		return seriesDAO.update(series) != null;
	}
	
	@ApiOperation(value = SERIES_DELETE_DESCRIPTION, notes = EMPTY_STRING, tags = { TAG_LISTAS})
	@ApiResponses({
		@ApiResponse(code = 200, message = "OK")
	})
	@RequestMapping(value = SERIES_ENDPOINT + "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public void delete(@PathVariable Integer id){
		seriesDAO.delete(id);
	}
}