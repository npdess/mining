
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
    "action_taken",
    "id"
})
public class Report {

    /**
     * The action taken in response to the report
     * 
     */
    @JsonProperty("action_taken")
    @JsonPropertyDescription("The action taken in response to the report")
    private Object actionTaken;
    /**
     * The ID of the report
     * 
     */
    @JsonProperty("id")
    @JsonPropertyDescription("The ID of the report")
    private Integer id;

    /**
     * The action taken in response to the report
     * 
     */
    @JsonProperty("action_taken")
    public Object getActionTaken() {
        return actionTaken;
    }

    /**
     * The action taken in response to the report
     * 
     */
    @JsonProperty("action_taken")
    public void setActionTaken(Object actionTaken) {
        this.actionTaken = actionTaken;
    }

    /**
     * The ID of the report
     * 
     */
    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    /**
     * The ID of the report
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
        return new HashCodeBuilder().append(actionTaken).append(id).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Report) == false) {
            return false;
        }
        Report rhs = ((Report) other);
        return new EqualsBuilder().append(actionTaken, rhs.actionTaken).append(id, rhs.id).isEquals();
    }

}
