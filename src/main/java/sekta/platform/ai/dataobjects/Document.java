package sekta.platform.ai.dataobjects;

import java.util.HashMap;
import java.util.Map;

public class Document {
    
    public Map<String, Integer> tokens;   
    public String category;
    
    public Document() {
        tokens = new HashMap<String, Integer>();
    }
}
