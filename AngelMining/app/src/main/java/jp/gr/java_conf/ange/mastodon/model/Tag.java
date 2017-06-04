
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
    "url"
})
public class Tag {

    /**
     * The hashtag, not including the preceding \#
     * 
     */
    @JsonProperty("name")
    @JsonPropertyDescription("The hashtag, not including the preceding \\#")
    private String name;
    /**
     * The URL of the hashtag
     * 
     */
    @JsonProperty("url")
    @JsonPropertyDescription("The URL of the hashtag")
    private String url;

    /**
     * The hashtag, not including the preceding \#
     * 
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * The hashtag, not including the preceding \#
     * 
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * The URL of the hashtag
     * 
     */
    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    /**
     * The URL of the hashtag
     * 
     */
    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(name).append(url).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Tag) == false) {
            return false;
        }
        Tag rhs = ((Tag) other);
        return new EqualsBuilder().append(name, rhs.name).append(url, rhs.url).isEquals();
    }

}
