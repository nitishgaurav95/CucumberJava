package pojo;

import java.util.List;

public class JiraCommentRequest {

    private Body body;

    public JiraCommentRequest() {}

    public JiraCommentRequest(Body body) {
        this.body = body;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    // ---------- INNER CLASSES ----------

    public static class Body {
        private String type;
        private int version;
        private List<Content> content;

        public Body() {}

        public Body(String type, int version, List<Content> content) {
            this.type = type;
            this.version = version;
            this.content = content;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getVersion() {
            return version;
        }

        public void setVersion(int version) {
            this.version = version;
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
        private List<Text> content;

        public Content() {}

        public Content(String type, List<Text> content) {
            this.type = type;
            this.content = content;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public List<Text> getContent() {
            return content;
        }

        public void setContent(List<Text> content) {
            this.content = content;
        }
    }

    public static class Text {
        private String type;
        private String text;

        public Text() {}

        public Text(String type, String text) {
            this.type = type;
            this.text = text;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }
}