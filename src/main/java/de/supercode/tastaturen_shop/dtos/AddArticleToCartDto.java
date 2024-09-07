package de.supercode.tastaturen_shop.dtos;

public class AddArticleToCartDto {
    private long CustomerID;
    private long ArticleID;

    public long getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(long customerID) {
        CustomerID = customerID;
    }

    public long getArticleID() {
        return ArticleID;
    }

    public void setArticleID(long articleID) {
        ArticleID = articleID;
    }
}
