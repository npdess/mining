
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
    "description",
    "email",
    "title",
    "url",
    "version"
})
public class Instance {

    /**
     * A description for the instance
     * 
     */
    @JsonProperty("description")
    @JsonPropertyDescription("A description for the instance")
    private String description;
    /**
     * An email address which can be used to contact the instance administrator
     * 
     */
    @JsonProperty("email")
    @JsonPropertyDescription("An email address which can be used to contact the instance administrator")
    private String email;
    /**
     * The instance's title
     * 
     */
    @JsonProperty("title")
    @JsonPropertyDescription("The instance's title")
    private String title;
    /**
     * URI of the current instance
     * 
     */
    @JsonProperty("url")
    @JsonPropertyDescription("URI of the current instance")
    private String url;
    /**
     * The Mastodon version used by instance (as of version 1.3).
     * 
     */
    @JsonProperty("version")
    @JsonPropertyDescription("The Mastodon version used by instance (as of version 1.3).")
    private Object version;

    /**
     * A description for the instance
     * 
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * A description for the instance
     * 
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * An email address which can be used to contact the instance administrator
     * 
     */
    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    /**
     * An email address which can be used to contact the instance administrator
     * 
     */
    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * The instance's title
     * 
     */
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    /**
     * The instance's title
     * 
     */
    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * URI of the current instance
     * 
     */
    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    /**
     * URI of the current instance
     * 
     */
    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * The Mastodon version used by instance (as of version 1.3).
     * 
     */
    @JsonProperty("version")
    public Object getVersion() {
        return version;
    }

    /**
     * The Mastodon version used by instance (as of version 1.3).
     * 
     */
    @JsonProperty("version")
    public void setVersion(Object version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(description).append(email).append(title).append(url).append(version).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Instance) == false) {
            return false;
        }
        Instance rhs = ((Instance) other);
        return new EqualsBuilder().append(description, rhs.description).append(email, rhs.email).append(title, rhs.title).append(url, rhs.url).append(version, rhs.version).isEquals();
    }

}
