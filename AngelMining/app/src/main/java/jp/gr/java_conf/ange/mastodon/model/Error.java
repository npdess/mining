
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
    "error"
})
public class Error {

    /**
     * A textual description of the error
     * 
     */
    @JsonProperty("error")
    @JsonPropertyDescription("A textual description of the error")
    private String error;

    /**
     * A textual description of the error
     * 
     */
    @JsonProperty("error")
    public String getError() {
        return error;
    }

    /**
     * A textual description of the error
     * 
     */
    @JsonProperty("error")
    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(error).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Error) == false) {
            return false;
        }
        Error rhs = ((Error) other);
        return new EqualsBuilder().append(error, rhs.error).isEquals();
    }

}
