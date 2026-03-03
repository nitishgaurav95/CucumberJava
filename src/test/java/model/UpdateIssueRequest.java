package model;

import java.util.List;

public class UpdateIssueRequest {
    private Fields fields;

    public Fields getFields() {
        return fields;
    }

    public void setFields(Fields fields) {
        this.fields = fields;
    }

    // ================= INNER CLASSES =================

    public static class Fields {

        private String summary;
        private Description description;     

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }
        public Description getDescription() {
            return description;
        }       
        public void setDescription(Description description) {
            this.description = description;
        }
    }
    
    public static class Description {
        private String type;
        private int version;
        private List<Content> content;

        public String getType() {
            return type;
        }
        public void setType(String type) {
            this.type = type;
        }
        public int getVersion() {
            return version;
        }
        public List<Content> getContent() {
            return content;
        }   
        public void setContent(List<Content> content) {
            this.content = content;
        }
    }
    public static class Content {

        private String type;
        private List<TextContent> content;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public List<TextContent> getContent() {
            return content;
        }

        public void setContent(List<TextContent> content) {
            this.content = content;
        }
    }

    public static class TextContent {

        private String text;
        private String type;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}
