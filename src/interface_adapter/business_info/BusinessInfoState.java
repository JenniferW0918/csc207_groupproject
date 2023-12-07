package interface_adapter.business_info;

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

    public BusinessInfoState() {
    }

    public String getBusinessName() {
        return businessName;
    }
    public String getBusinessAddress() {
        return businessAddress;
    }
    public String getStatus() {
        return status;
    }
    public String getBusinessUrl() {
        return businessUrl;
    }
    public String getBusinessReviews() {
        return businessReviews;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }
    public void setBusinessAddress(String businessAddress) {
        this.businessAddress = businessAddress;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void setBusinessUrl(String businessUrl) {
        this.businessUrl = businessUrl;
    }
    public void setBusinessReviews(String businessReview) {
        this.businessReviews = businessReview;
    }
}
