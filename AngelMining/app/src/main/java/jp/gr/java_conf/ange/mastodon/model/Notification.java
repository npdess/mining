
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
    "account",
    "created_at",
    "id",
    "status",
    "type"
})
public class Notification {

    @JsonProperty("account")
    private Account account;
    /**
     * The time the notification was created
     * 
     */
    @JsonProperty("created_at")
    @JsonPropertyDescription("The time the notification was created")
    private String createdAt;
    /**
     * The notification ID
     * 
     */
    @JsonProperty("id")
    @JsonPropertyDescription("The notification ID")
    private Integer id;
    @JsonProperty("status")
    private Status status;
    /**
     * One of "mention", "reblog", "favourite", "follow"
     * 
     */
    @JsonProperty("type")
    @JsonPropertyDescription("One of \"mention\", \"reblog\", \"favourite\", \"follow\"")
    private String type;

    @JsonProperty("account")
    public Account getAccount() {
        return account;
    }

    @JsonProperty("account")
    public void setAccount(Account account) {
        this.account = account;
    }

    /**
     * The time the notification was created
     * 
     */
    @JsonProperty("created_at")
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * The time the notification was created
     * 
     */
    @JsonProperty("created_at")
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * The notification ID
     * 
     */
    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    /**
     * The notification ID
     * 
     */
    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("status")
    public Status getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * One of "mention", "reblog", "favourite", "follow"
     * 
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * One of "mention", "reblog", "favourite", "follow"
     * 
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(account).append(createdAt).append(id).append(status).append(type).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Notification) == false) {
            return false;
        }
        Notification rhs = ((Notification) other);
        return new EqualsBuilder().append(account, rhs.account).append(createdAt, rhs.createdAt).append(id, rhs.id).append(status, rhs.status).append(type, rhs.type).isEquals();
    }

}
