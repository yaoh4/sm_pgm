package gov.nih.nci.iscs.oracle.pgm.forms;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import gov.nih.nci.iscs.oracle.pgm.constants.ApplicationConstants;
import java.util.List;

/** @author Hibernate CodeGenerator */
public class PaginationObject implements Serializable {

    private Integer  pageSize;
    private Integer  pageNumber;
    private Long     totalResultsCount = new Long(0);
    private boolean isFirstPage = true;
    private boolean isLastPage = true;
    private Integer lastPageNumber;
    private Integer nextPageNumber;
    private Integer previousPageNumber;
    private boolean hasNextPage;
    private boolean hasPreviousPage;
    private String indexOfFirstGrant;
    private String indexOfLastGrant;





    /** default constructor */


    /** default constructor */
    public PaginationObject() {
		this.pageSize = new Integer(ApplicationConstants.DEFAULT_PAGE_SIZE);
	}



    public Integer getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }


    public Integer getPageNumber() {
        return this.pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }



    public Long getTotalResultsCount() {
        return this.totalResultsCount;
    }
    public void setTotalResultsCount(Long totalResultsCount) {
        this.totalResultsCount = totalResultsCount;
    }


    public Integer getLastPageNumber() {
        return this.lastPageNumber;
    }
    public void setLastPageNumber(Integer lastPageNumber) {
        this.lastPageNumber = lastPageNumber;
    }


    public boolean getIsFirstPage() {
       return isFirstPage;
	}
    public void setIsFirstPage(boolean isFirstPage) {
		this.isFirstPage = isFirstPage;
	}


    public boolean getIsLastPage() {
       return isLastPage;
    }
    public void setIsLastPage(boolean isLastPage){
		this.isLastPage = isLastPage;
	}


    public Integer getNextPageNumber() {
        return this.nextPageNumber;
    }
    public void setNextPageNumber(Integer nextPageNumber) {
        this.nextPageNumber = nextPageNumber;
    }


    public Integer getPreviousPageNumber() {
        return this.previousPageNumber;
    }
    public void setPreviousPageNumber(Integer previousPageNumber) {
        this.previousPageNumber = previousPageNumber;
    }


    public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}
    public boolean getHasNextPage() {
       return hasNextPage;
    }


    public void setHasPreviousPage(boolean hasPreviousPage) {
		this.hasPreviousPage = hasPreviousPage;
	}
    public boolean getHasPreviousPage() {
       return hasPreviousPage;
    }


    public String getIndexOfFirstGrant() {
		int index = (this.pageSize.intValue() * (this.pageNumber.intValue() - 1)) + 1;
        return new Integer(index).toString();
    }

    public void setIndexOfFirstGrant(Integer index) {
		this.indexOfFirstGrant = index.toString();
    }

    public String getIndexOfLastGrant() {
		long index = this.pageSize.intValue() * this.pageNumber.intValue();
		if(index>totalResultsCount.longValue())
			return totalResultsCount.toString();
        return new Long(index).toString();
    }

    public void setIndexOfLastGrant(Integer index) {
		this.indexOfLastGrant = index.toString();
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("pageSize ", getPageSize())
            .append("pageNumber ", getPageNumber())
            .append("totalResultsCount ", getTotalResultsCount())
            .append("lastPageNumber ", getLastPageNumber())
            .append("lastPageNumber ", getLastPageNumber())
            .append("isLastPage ", getIsLastPage())
            .append("isFirstPage ", getIsFirstPage())
            .append("NextPageNumber ", getNextPageNumber())
            .append("PreviousPageNumber ", getPreviousPageNumber())
            .append("hasNextPage ", getHasNextPage())
            .append("hasPreviousPage ", getHasPreviousPage())
            .append("indexOfFirstGrant ", getIndexOfFirstGrant())
            .append("indexOfLastGrant ", getIndexOfLastGrant())
            .toString();
    }



}
