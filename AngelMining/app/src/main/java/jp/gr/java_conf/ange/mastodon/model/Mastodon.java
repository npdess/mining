
package jp.gr.java_conf.ange.mastodon.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;


/**
 * Mastodon REST API V1 schemed JSON Hyper Schema draft v4. created by @npdess.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "account",
    "application",
    "mention",
    "attachment",
    "tag",
    "status"
})
public class Mastodon {

    @JsonProperty("account")
    private Account account;
    @JsonProperty("application")
    private Application application;
    @JsonProperty("mention")
    private Mention mention;
    @JsonProperty("attachment")
    private Attachment attachment;
    @JsonProperty("tag")
    private Tag tag;
    @JsonProperty("status")
    private Status status;

    @JsonProperty("account")
    public Account getAccount() {
        return account;
    }

    @JsonProperty("account")
    public void setAccount(Account account) {
        this.account = account;
    }

    @JsonProperty("application")
    public Application getApplication() {
        return application;
    }

    @JsonProperty("application")
    public void setApplication(Application application) {
        this.application = application;
    }

    @JsonProperty("mention")
    public Mention getMention() {
        return mention;
    }

    @JsonProperty("mention")
    public void setMention(Mention mention) {
        this.mention = mention;
    }

    @JsonProperty("attachment")
    public Attachment getAttachment() {
        return attachment;
    }

    @JsonProperty("attachment")
    public void setAttachment(Attachment attachment) {
        this.attachment = attachment;
    }

    @JsonProperty("tag")
    public Tag getTag() {
        return tag;
    }

    @JsonProperty("tag")
    public void setTag(Tag tag) {
        this.tag = tag;
    }

    @JsonProperty("status")
    public Status getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(account).append(application).append(mention).append(attachment).append(tag).append(status).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Mastodon) == false) {
            return false;
        }
        Mastodon rhs = ((Mastodon) other);
        return new EqualsBuilder().append(account, rhs.account).append(application, rhs.application).append(mention, rhs.mention).append(attachment, rhs.attachment).append(tag, rhs.tag).append(status, rhs.status).isEquals();
    }

}
