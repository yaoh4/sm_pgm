package gov.nih.nci.iscs.oracle.pgm.dataaccess.resources;
import java.util.List;

public interface WbRetrieveBoardsCommand
{
    public List getBoards();
    public String execute(String oUserId);
}