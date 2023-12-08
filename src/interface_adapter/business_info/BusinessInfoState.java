package interface_adapter.business_info;

/**
 * This class represents the state for the business info feature.
 * It contains the business name, address, status, url, and reviews.
 */
public class BusinessInfoState {
    private String businessName;
    private String businessAddress;
    private String status;
    private String businessUrl;
    private String businessReviews;

//    public BusinessInfoState(BusinessInfoState copy) {
//        businessName = copy.getBusinessName();
//        businessAddress = copy.getBusinessAddress();
//        status = copy.getStatus();
//        businessUrl = copy.getBusinessUrl();
//        businessReviews = copy.getBusinessReviews();
//    }
//
    /**
     * This constructor creates a new BusinessInfoState object.
     */
    public BusinessInfoState() {
    }

    // GETTERS
    /** This method returns the name of the business
     * @return businessName the name of the business */
    public String getBusinessName() {
        return businessName;
    }

    /** This method returns the address of a business
     * @return businessAddress the address of the business
     */
    public String getBusinessAddress() {
        return businessAddress;
    }

    /** This method returns the status of a business, whether open or closed
     * @return the status of the business (yes/no) whether the business is open or closed.*/
    public String getStatus() {
        return status;
    }

    /** This method returns the url of a business
     * @return businessUrl the url of the business*/
    public String getBusinessUrl() {
        return businessUrl;
    }

    /** This method returns the reviews of a business*
     * @return businessReviews the reviews of the business
     */
    public String getBusinessReviews() {
        return businessReviews;
    }

    // SETTERS
    /** This method sets the name of the business
     * @param businessName the name of the business*/
    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    /** This method sets the address of the business
     * @param businessAddress the address of the business*/
    public void setBusinessAddress(String businessAddress) {
        this.businessAddress = businessAddress;
    }

    /** This method sets the status of the business
     * @param status the status of the business*/
    public void setStatus(String status) {
        this.status = status;
    }

    /** This method sets the url of the business
     * @param businessUrl the url of the business*/
    public void setBusinessUrl(String businessUrl) {
        this.businessUrl = businessUrl;
    }

    /** This method sets the reviews of the business
     * @param businessReview the reviews of the business*/
    public void setBusinessReviews(String businessReview) {
        this.businessReviews = businessReview;
    }
}
