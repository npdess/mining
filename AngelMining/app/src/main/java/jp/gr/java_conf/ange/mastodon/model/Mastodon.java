
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
    "attachment",
    "card",
    "context",
    "error",
    "instance",
    "mention",
    "notification",
    "relationship",
    "report",
    "results",
    "status",
    "tag"
})
public class Mastodon {

    @JsonProperty("account")
    private Account account;
    @JsonProperty("application")
    private Application application;
    @JsonProperty("attachment")
    private Attachment attachment;
    @JsonProperty("card")
    private Card card;
    @JsonProperty("context")
    private Context context;
    @JsonProperty("error")
    private Error error;
    @JsonProperty("instance")
    private Instance instance;
    @JsonProperty("mention")
    private Mention mention;
    @JsonProperty("notification")
    private Notification notification;
    @JsonProperty("relationship")
    private Relationship relationship;
    @JsonProperty("report")
    private Report report;
    @JsonProperty("results")
    private Results results;
    @JsonProperty("status")
    private Status status;
    @JsonProperty("tag")
    private Tag tag;

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

    @JsonProperty("attachment")
    public Attachment getAttachment() {
        return attachment;
    }

    @JsonProperty("attachment")
    public void setAttachment(Attachment attachment) {
        this.attachment = attachment;
    }

    @JsonProperty("card")
    public Card getCard() {
        return card;
    }

    @JsonProperty("card")
    public void setCard(Card card) {
        this.card = card;
    }

    @JsonProperty("context")
    public Context getContext() {
        return context;
    }

    @JsonProperty("context")
    public void setContext(Context context) {
        this.context = context;
    }

    @JsonProperty("error")
    public Error getError() {
        return error;
    }

    @JsonProperty("error")
    public void setError(Error error) {
        this.error = error;
    }

    @JsonProperty("instance")
    public Instance getInstance() {
        return instance;
    }

    @JsonProperty("instance")
    public void setInstance(Instance instance) {
        this.instance = instance;
    }

    @JsonProperty("mention")
    public Mention getMention() {
        return mention;
    }

    @JsonProperty("mention")
    public void setMention(Mention mention) {
        this.mention = mention;
    }

    @JsonProperty("notification")
    public Notification getNotification() {
        return notification;
    }

    @JsonProperty("notification")
    public void setNotification(Notification notification) {
        this.notification = notification;
    }

    @JsonProperty("relationship")
    public Relationship getRelationship() {
        return relationship;
    }

    @JsonProperty("relationship")
    public void setRelationship(Relationship relationship) {
        this.relationship = relationship;
    }

    @JsonProperty("report")
    public Report getReport() {
        return report;
    }

    @JsonProperty("report")
    public void setReport(Report report) {
        this.report = report;
    }

    @JsonProperty("results")
    public Results getResults() {
        return results;
    }

    @JsonProperty("results")
    public void setResults(Results results) {
        this.results = results;
    }

    @JsonProperty("status")
    public Status getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(Status status) {
        this.status = status;
    }

    @JsonProperty("tag")
    public Tag getTag() {
        return tag;
    }

    @JsonProperty("tag")
    public void setTag(Tag tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(account).append(application).append(attachment).append(card).append(context).append(error).append(instance).append(mention).append(notification).append(relationship).append(report).append(results).append(status).append(tag).toHashCode();
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
        return new EqualsBuilder().append(account, rhs.account).append(application, rhs.application).append(attachment, rhs.attachment).append(card, rhs.card).append(context, rhs.context).append(error, rhs.error).append(instance, rhs.instance).append(mention, rhs.mention).append(notification, rhs.notification).append(relationship, rhs.relationship).append(report, rhs.report).append(results, rhs.results).append(status, rhs.status).append(tag, rhs.tag).isEquals();
    }

}
