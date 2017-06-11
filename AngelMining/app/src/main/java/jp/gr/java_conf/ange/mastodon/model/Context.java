
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
    "ancestors",
    "descendants"
})
public class Context {

    /**
     * The ancestors of the status in the conversation, as a list of Statuses
     * 
     */
    @JsonProperty("ancestors")
    @JsonPropertyDescription("The ancestors of the status in the conversation, as a list of Statuses")
    private Object ancestors;
    /**
     * The descendants of the status in the conversation, as a list of Statuses
     * 
     */
    @JsonProperty("descendants")
    @JsonPropertyDescription("The descendants of the status in the conversation, as a list of Statuses")
    private Object descendants;

    /**
     * The ancestors of the status in the conversation, as a list of Statuses
     * 
     */
    @JsonProperty("ancestors")
    public Object getAncestors() {
        return ancestors;
    }

    /**
     * The ancestors of the status in the conversation, as a list of Statuses
     * 
     */
    @JsonProperty("ancestors")
    public void setAncestors(Object ancestors) {
        this.ancestors = ancestors;
    }

    /**
     * The descendants of the status in the conversation, as a list of Statuses
     * 
     */
    @JsonProperty("descendants")
    public Object getDescendants() {
        return descendants;
    }

    /**
     * The descendants of the status in the conversation, as a list of Statuses
     * 
     */
    @JsonProperty("descendants")
    public void setDescendants(Object descendants) {
        this.descendants = descendants;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(ancestors).append(descendants).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Context) == false) {
            return false;
        }
        Context rhs = ((Context) other);
        return new EqualsBuilder().append(ancestors, rhs.ancestors).append(descendants, rhs.descendants).isEquals();
    }

}
