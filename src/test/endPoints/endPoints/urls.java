public class urls {

    public static final String CREATE_ISSUE = "/rest/api/3/issue";
    public static final String ASSIGN_ISSUE = "/rest/api/3/issue/{issueKey}/assignee";
    public static final String GET_ISSUE = "/rest/api/3/issue/{issueKey}";
    public static final String GET_TRANSITION_ISSUE = "/rest/api/3/issue/{issueKey}/transitions";
    public static final String GET_ASSIGNEE_ISSUE = "/rest/api/3/issue/{issueKey}/assignee";
    public static final String GET_ISSUE_WITHOUT_PERMISSIONS = "/rest/api/3/issue/{issueKey}";
    public static final String GET_ISSUE_WITHOUT_MANDATORY_FIELDS = "/rest/api/3/issue/INVALID-1";
    public static final String GET_ISSUE_WITH_INVALID_KEY = "/rest/api/3/issue/INVALID-KEY";
    public static final String CREATE_ISSUE_WITH_INVALID_KEY = "/rest/api/3/issue/INVALID-KEY";
    public static final String UPDATE_COMMENT = "/rest/api/3/issue/{issueKey}/comment/{commentId}";
    public static final String CREATE_COMMENT = "/rest/api/3/issue/{issueKey}/comment";
    public static final String TRANSITION_ISSUE = "/rest/api/3/issue/{issueKey}/transitions";
    public static final String UPDATE_ISSUE = "/rest/api/3/issue/{issueKey}";
}
