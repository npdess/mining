
package jp.gr.java_conf.ange.mastodon.model;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "accounts",
    "hashtags",
    "statues"
})
public class Results {

    /**
     * An array of matched Accounts
     * 
     */
    @JsonProperty("accounts")
    @JsonPropertyDescription("An array of matched Accounts")
    private List<Account> accounts = new ArrayList<Account>();
    /**
     * An array of matched hashtags, as strings
     * 
     */
    @JsonProperty("hashtags")
    @JsonPropertyDescription("An array of matched hashtags, as strings")
    private List<String> hashtags = new ArrayList<String>();
    /**
     * An array of matchhed Statuses
     * 
     */
    @JsonProperty("statues")
    @JsonPropertyDescription("An array of matchhed Statuses")
    private List<Status> statues = new ArrayList<Status>();

    /**
     * An array of matched Accounts
     * 
     */
    @JsonProperty("accounts")
    public List<Account> getAccounts() {
        return accounts;
    }

    /**
     * An array of matched Accounts
     * 
     */
    @JsonProperty("accounts")
    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    /**
     * An array of matched hashtags, as strings
     * 
     */
    @JsonProperty("hashtags")
    public List<String> getHashtags() {
        return hashtags;
    }

    /**
     * An array of matched hashtags, as strings
     * 
     */
    @JsonProperty("hashtags")
    public void setHashtags(List<String> hashtags) {
        this.hashtags = hashtags;
    }

    /**
     * An array of matchhed Statuses
     * 
     */
    @JsonProperty("statues")
    public List<Status> getStatues() {
        return statues;
    }

    /**
     * An array of matchhed Statuses
     * 
     */
    @JsonProperty("statues")
    public void setStatues(List<Status> statues) {
        this.statues = statues;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(accounts).append(hashtags).append(statues).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Results) == false) {
            return false;
        }
        Results rhs = ((Results) other);
        return new EqualsBuilder().append(accounts, rhs.accounts).append(hashtags, rhs.hashtags).append(statues, rhs.statues).isEquals();
    }

}
