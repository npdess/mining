
package jp.gr.java_conf.ange.mastodon.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "url",
    "username",
    "acct",
    "id"
})
public class Mention {

    /**
     * URL of user's profile (can be remote)
     * 
     */
    @JsonProperty("url")
    @JsonPropertyDescription("URL of user's profile (can be remote)")
    private String url;
    /**
     * The username of the account
     * 
     */
    @JsonProperty("username")
    @JsonPropertyDescription("The username of the account")
    private String username;
    /**
     * Equals username for local users, includes @domain for remote ones
     * 
     */
    @JsonProperty("acct")
    @JsonPropertyDescription("Equals username for local users, includes @domain for remote ones")
    private String acct;
    /**
     * Account ID
     * 
     */
    @JsonProperty("id")
    @JsonPropertyDescription("Account ID")
    private Integer id;

    /**
     * URL of user's profile (can be remote)
     * 
     */
    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    /**
     * URL of user's profile (can be remote)
     * 
     */
    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * The username of the account
     * 
     */
    @JsonProperty("username")
    public String getUsername() {
        return username;
    }

    /**
     * The username of the account
     * 
     */
    @JsonProperty("username")
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Equals username for local users, includes @domain for remote ones
     * 
     */
    @JsonProperty("acct")
    public String getAcct() {
        return acct;
    }

    /**
     * Equals username for local users, includes @domain for remote ones
     * 
     */
    @JsonProperty("acct")
    public void setAcct(String acct) {
        this.acct = acct;
    }

    /**
     * Account ID
     * 
     */
    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    /**
     * Account ID
     * 
     */
    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(url).append(username).append(acct).append(id).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Mention) == false) {
            return false;
        }
        Mention rhs = ((Mention) other);
        return new EqualsBuilder().append(url, rhs.url).append(username, rhs.username).append(acct, rhs.acct).append(id, rhs.id).isEquals();
    }

}
