
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
    "name",
    "website"
})
public class Application {

    /**
     * Name of the app
     * 
     */
    @JsonProperty("name")
    @JsonPropertyDescription("Name of the app")
    private String name;
    /**
     * Homepage URL of the app
     * 
     */
    @JsonProperty("website")
    @JsonPropertyDescription("Homepage URL of the app")
    private String website;

    /**
     * Name of the app
     * 
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Name of the app
     * 
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Homepage URL of the app
     * 
     */
    @JsonProperty("website")
    public String getWebsite() {
        return website;
    }

    /**
     * Homepage URL of the app
     * 
     */
    @JsonProperty("website")
    public void setWebsite(String website) {
        this.website = website;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(name).append(website).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Application) == false) {
            return false;
        }
        Application rhs = ((Application) other);
        return new EqualsBuilder().append(name, rhs.name).append(website, rhs.website).isEquals();
    }

}
