
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
    "acct",
    "avatar",
    "avatar_static",
    "created_at",
    "display_name",
    "followers_count",
    "following_count",
    "header",
    "header_static",
    "id",
    "locked",
    "note",
    "oauth_authentications",
    "statuses_count",
    "url",
    "username"
})
public class Account {

    /**
     * Equals username for local users, includes @domain for remote ones
     * 
     */
    @JsonProperty("acct")
    @JsonPropertyDescription("Equals username for local users, includes @domain for remote ones")
    private String acct;
    /**
     * URL to the avatar image
     * 
     */
    @JsonProperty("avatar")
    @JsonPropertyDescription("URL to the avatar image")
    private String avatar;
    /**
     * URL to the avatar static image (gif)
     * 
     */
    @JsonProperty("avatar_static")
    @JsonPropertyDescription("URL to the avatar static image (gif)")
    private String avatarStatic;
    /**
     * The time the account was created
     * 
     */
    @JsonProperty("created_at")
    @JsonPropertyDescription("The time the account was created")
    private String createdAt;
    /**
     * The account's display name
     * 
     */
    @JsonProperty("display_name")
    @JsonPropertyDescription("The account's display name")
    private String displayName;
    /**
     * The number of followers for the account
     * 
     */
    @JsonProperty("followers_count")
    @JsonPropertyDescription("The number of followers for the account")
    private Integer followersCount;
    /**
     * The number of accounts the given account is following
     * 
     */
    @JsonProperty("following_count")
    @JsonPropertyDescription("The number of accounts the given account is following")
    private Integer followingCount;
    /**
     * URL to the header image
     * 
     */
    @JsonProperty("header")
    @JsonPropertyDescription("URL to the header image")
    private String header;
    /**
     * URL to the header static image (gif)
     * 
     */
    @JsonProperty("header_static")
    @JsonPropertyDescription("URL to the header static image (gif)")
    private String headerStatic;
    /**
     * The ID of the accountおーけーぴーけー
     * 
     */
    @JsonProperty("id")
    @JsonPropertyDescription("The ID of the account\u304a\u30fc\u3051\u30fc\u3074\u30fc\u3051\u30fc")
    private Integer id;
    /**
     * Boolean for when the account cannot be followed without waiting for approval first
     * 
     */
    @JsonProperty("locked")
    @JsonPropertyDescription("Boolean for when the account cannot be followed without waiting for approval first")
    private Boolean locked;
    /**
     * Biography of user
     * 
     */
    @JsonProperty("note")
    @JsonPropertyDescription("Biography of user")
    private String note;
    /**
     * oauth
     * 
     */
    @JsonProperty("oauth_authentications")
    @JsonPropertyDescription("oauth")
    private List<Object> oauthAuthentications = new ArrayList<Object>();
    /**
     * The number of statuses the account has made
     * 
     */
    @JsonProperty("statuses_count")
    @JsonPropertyDescription("The number of statuses the account has made")
    private Integer statusesCount;
    /**
     * URL of the user's profile page (can be remote)
     * 
     */
    @JsonProperty("url")
    @JsonPropertyDescription("URL of the user's profile page (can be remote)")
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
     * URL to the avatar image
     * 
     */
    @JsonProperty("avatar")
    public String getAvatar() {
        return avatar;
    }

    /**
     * URL to the avatar image
     * 
     */
    @JsonProperty("avatar")
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     * URL to the avatar static image (gif)
     * 
     */
    @JsonProperty("avatar_static")
    public String getAvatarStatic() {
        return avatarStatic;
    }

    /**
     * URL to the avatar static image (gif)
     * 
     */
    @JsonProperty("avatar_static")
    public void setAvatarStatic(String avatarStatic) {
        this.avatarStatic = avatarStatic;
    }

    /**
     * The time the account was created
     * 
     */
    @JsonProperty("created_at")
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * The time the account was created
     * 
     */
    @JsonProperty("created_at")
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * The account's display name
     * 
     */
    @JsonProperty("display_name")
    public String getDisplayName() {
        return displayName;
    }

    /**
     * The account's display name
     * 
     */
    @JsonProperty("display_name")
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * The number of followers for the account
     * 
     */
    @JsonProperty("followers_count")
    public Integer getFollowersCount() {
        return followersCount;
    }

    /**
     * The number of followers for the account
     * 
     */
    @JsonProperty("followers_count")
    public void setFollowersCount(Integer followersCount) {
        this.followersCount = followersCount;
    }

    /**
     * The number of accounts the given account is following
     * 
     */
    @JsonProperty("following_count")
    public Integer getFollowingCount() {
        return followingCount;
    }

    /**
     * The number of accounts the given account is following
     * 
     */
    @JsonProperty("following_count")
    public void setFollowingCount(Integer followingCount) {
        this.followingCount = followingCount;
    }

    /**
     * URL to the header image
     * 
     */
    @JsonProperty("header")
    public String getHeader() {
        return header;
    }

    /**
     * URL to the header image
     * 
     */
    @JsonProperty("header")
    public void setHeader(String header) {
        this.header = header;
    }

    /**
     * URL to the header static image (gif)
     * 
     */
    @JsonProperty("header_static")
    public String getHeaderStatic() {
        return headerStatic;
    }

    /**
     * URL to the header static image (gif)
     * 
     */
    @JsonProperty("header_static")
    public void setHeaderStatic(String headerStatic) {
        this.headerStatic = headerStatic;
    }

    /**
     * The ID of the accountおーけーぴーけー
     * 
     */
    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    /**
     * The ID of the accountおーけーぴーけー
     * 
     */
    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Boolean for when the account cannot be followed without waiting for approval first
     * 
     */
    @JsonProperty("locked")
    public Boolean getLocked() {
        return locked;
    }

    /**
     * Boolean for when the account cannot be followed without waiting for approval first
     * 
     */
    @JsonProperty("locked")
    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    /**
     * Biography of user
     * 
     */
    @JsonProperty("note")
    public String getNote() {
        return note;
    }

    /**
     * Biography of user
     * 
     */
    @JsonProperty("note")
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * oauth
     * 
     */
    @JsonProperty("oauth_authentications")
    public List<Object> getOauthAuthentications() {
        return oauthAuthentications;
    }

    /**
     * oauth
     * 
     */
    @JsonProperty("oauth_authentications")
    public void setOauthAuthentications(List<Object> oauthAuthentications) {
        this.oauthAuthentications = oauthAuthentications;
    }

    /**
     * The number of statuses the account has made
     * 
     */
    @JsonProperty("statuses_count")
    public Integer getStatusesCount() {
        return statusesCount;
    }

    /**
     * The number of statuses the account has made
     * 
     */
    @JsonProperty("statuses_count")
    public void setStatusesCount(Integer statusesCount) {
        this.statusesCount = statusesCount;
    }

    /**
     * URL of the user's profile page (can be remote)
     * 
     */
    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    /**
     * URL of the user's profile page (can be remote)
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

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(acct).append(avatar).append(avatarStatic).append(createdAt).append(displayName).append(followersCount).append(followingCount).append(header).append(headerStatic).append(id).append(locked).append(note).append(oauthAuthentications).append(statusesCount).append(url).append(username).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Account) == false) {
            return false;
        }
        Account rhs = ((Account) other);
        return new EqualsBuilder().append(acct, rhs.acct).append(avatar, rhs.avatar).append(avatarStatic, rhs.avatarStatic).append(createdAt, rhs.createdAt).append(displayName, rhs.displayName).append(followersCount, rhs.followersCount).append(followingCount, rhs.followingCount).append(header, rhs.header).append(headerStatic, rhs.headerStatic).append(id, rhs.id).append(locked, rhs.locked).append(note, rhs.note).append(oauthAuthentications, rhs.oauthAuthentications).append(statusesCount, rhs.statusesCount).append(url, rhs.url).append(username, rhs.username).isEquals();
    }

}
