package epam;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.io.StringWriter;

/**
 * handler for custom jsp tag to support json rendering
 */
public class JsonTagHandler extends SimpleTagSupport {

    @Override
    public void doTag() throws JspException, IOException {
        final JspWriter jspWriter = getJspContext().getOut();
        final StringWriter stringWriter = new StringWriter();
        final StringBuilder bodyContent = new StringBuilder();
        getJspBody().invoke(stringWriter);
        String json = stringWriter.getBuffer().toString();
        if (isJSONValid(json)) {
            for(int i=0;i< json.length();i++){
                if(json.charAt(i)=='}'){
                    bodyContent.append("</div>");
                }
                bodyContent.append(json.charAt(i));
                if(json.charAt(i)=='{'){
                    bodyContent.append("<div class='tab'>");
                }
                if(json.charAt(i)==','){
                    bodyContent.append("<br>");
                }
            }
            // Output to the JSP writer
            jspWriter.write(bodyContent.toString());
        } else {
            jspWriter.write("Not valid JSON");
        }
    }

    /**
     * JSON validator
     * @param test String (JSON)
     * @return boolean
     */
    public boolean isJSONValid(String test) {
        try {
            new JSONObject(test);
        } catch (JSONException ex) {
            try {
                new JSONArray(test);
            } catch (JSONException ex1) {
                return false;
            }
        }
        return true;
    }
}
