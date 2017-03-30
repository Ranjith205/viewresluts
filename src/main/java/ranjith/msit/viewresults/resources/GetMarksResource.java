package ranjith.msit.viewresults.resources;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ranjith.msit.viewresults.dao.MarksDao;
import ranjith.msit.viewresults.dao.MarksOperations;
import ranjith.msit.viewresults.model.Marks;
import ranjith.msit.viewresults.model.MarksTable;

@Path("/getmarks")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GetMarksResource {

	MarksOperations marksDao = new MarksOperations();
	@GET
	
    public List<MarksTable> getMarks() throws ClassNotFoundException, SQLException {
        return marksDao.getAllMarks();
    }
}
