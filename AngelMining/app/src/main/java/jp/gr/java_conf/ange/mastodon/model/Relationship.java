
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
    "blocking",
    "followed_by",
    "following",
    "id",
    "muting",
    "requested"
})
public class Relationship {

    /**
     * Whether the user is currently blocking the account
     * 
     */
    @JsonProperty("blocking")
    @JsonPropertyDescription("Whether the user is currently blocking the account")
    private Boolean blocking;
    /**
     * Whether the user is currently being followed by the account
     * 
     */
    @JsonProperty("followed_by")
    @JsonPropertyDescription("Whether the user is currently being followed by the account")
    private Boolean followedBy;
    /**
     * Whether the user is currently following the account
     * 
     */
    @JsonProperty("following")
    @JsonPropertyDescription("Whether the user is currently following the account")
    private Boolean following;
    /**
     * Target account id
     * 
     */
    @JsonProperty("id")
    @JsonPropertyDescription("Target account id")
    private Integer id;
    /**
     * Whether the user is currently muting the account
     * 
     */
    @JsonProperty("muting")
    @JsonPropertyDescription("Whether the user is currently muting the account")
    private Boolean muting;
    /**
     * Whether the user has requested to follow the account
     * 
     */
    @JsonProperty("requested")
    @JsonPropertyDescription("Whether the user has requested to follow the account")
    private Boolean requested;

    /**
     * Whether the user is currently blocking the account
     * 
     */
    @JsonProperty("blocking")
    public Boolean getBlocking() {
        return blocking;
    }

    /**
     * Whether the user is currently blocking the account
     * 
     */
    @JsonProperty("blocking")
    public void setBlocking(Boolean blocking) {
        this.blocking = blocking;
    }

    /**
     * Whether the user is currently being followed by the account
     * 
     */
    @JsonProperty("followed_by")
    public Boolean getFollowedBy() {
        return followedBy;
    }

    /**
     * Whether the user is currently being followed by the account
     * 
     */
    @JsonProperty("followed_by")
    public void setFollowedBy(Boolean followedBy) {
        this.followedBy = followedBy;
    }

    /**
     * Whether the user is currently following the account
     * 
     */
    @JsonProperty("following")
    public Boolean getFollowing() {
        return following;
    }

    /**
     * Whether the user is currently following the account
     * 
     */
    @JsonProperty("following")
    public void setFollowing(Boolean following) {
        this.following = following;
    }

    /**
     * Target account id
     * 
     */
    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    /**
     * Target account id
     * 
     */
    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Whether the user is currently muting the account
     * 
     */
    @JsonProperty("muting")
    public Boolean getMuting() {
        return muting;
    }

    /**
     * Whether the user is currently muting the account
     * 
     */
    @JsonProperty("muting")
    public void setMuting(Boolean muting) {
        this.muting = muting;
    }

    /**
     * Whether the user has requested to follow the account
     * 
     */
    @JsonProperty("requested")
    public Boolean getRequested() {
        return requested;
    }

    /**
     * Whether the user has requested to follow the account
     * 
     */
    @JsonProperty("requested")
    public void setRequested(Boolean requested) {
        this.requested = requested;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(blocking).append(followedBy).append(following).append(id).append(muting).append(requested).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Relationship) == false) {
            return false;
        }
        Relationship rhs = ((Relationship) other);
        return new EqualsBuilder().append(blocking, rhs.blocking).append(followedBy, rhs.followedBy).append(following, rhs.following).append(id, rhs.id).append(muting, rhs.muting).append(requested, rhs.requested).isEquals();
    }

}
