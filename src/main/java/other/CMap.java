package other;

import java.util.TreeMap;

public class CMap extends TreeMap<String, Object> {

    @Override
    public CMap put(String key, Object value) {
        super.put(key, value);
        return this;
    }

}
