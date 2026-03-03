package model;

public class CreateJiraRequest {

    private Fields fields;

    public Fields getFields() {
        return fields;
    }

    public void setFields(Fields fields) {
        this.fields = fields;
    }

    // ================= INNER CLASSES =================

    public static class Fields {

        private Project project;
        private String summary;
        private IssueType issuetype;
        private User assignee;

        public Project getProject() {
            return project;
        }

        public void setProject(Project project) {
            this.project = project;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public IssueType getIssuetype() {
            return issuetype;
        }

        public void setIssuetype(IssueType issuetype) {
            this.issuetype = issuetype;
        }

        public User getAssignee() {
            return assignee;
        }

        public void setAssignee(User assignee) {
            this.assignee = assignee;
        }
    }

    public static class Project {

        private String key;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }
    }

    public static class IssueType {

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class User {

        private String accountId;

        public String getAccountId() {
            return accountId;
        }

        public void setAccountId(String accountId) {
            this.accountId = accountId;
        }
    }
}
